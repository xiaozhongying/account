/**
 * 功能:客户欠款明细账Controller
 * 开发人员:无名氏
 * 创建时间:2019-2-9 21:36:05
 */
package account.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import dswork.mvc.BaseController;
import dswork.core.page.Page;
import dswork.core.page.PageNav;
import dswork.core.util.CollectionUtil;
import dswork.core.util.TimeUtil;
import dswork.core.util.UniqueId;
import account.model.Financial;
import account.model.User;
import account.service.ManageAccountFinancialService;
import account.service.ManageAccountUserService;

@Scope("prototype")
@Controller
@RequestMapping("/manage/account/financial")
public class ManageAccountFinancialController extends BaseController
{
	@Autowired
	private ManageAccountFinancialService service;
	@Autowired
	private ManageAccountUserService userservice;

	//添加
	@RequestMapping
	public String addFinancial1()
	{
		put("userid", req.getLong("userid"));
		put("username", req.getString("username"));
		return "/manage/account/financial/addFinancial.jsp";
	}

	@RequestMapping
	public void addFinancial2(Financial po)
	{
		try
		{
			Map<String, Object> map=new HashMap<>();
			map.put("userid", po.getUserid());
			po.setId(UniqueId.genId());
			po.setCreatetime(TimeUtil.getCurrentTime());
			service.save(po);
			//添加欠款成功则更新欠款记录
			User user=userservice.get(po.getUserid());
			List<Financial> list=service.queryQkjl(map);
			if(list.size()==1){
				user.setQkjl(list.get(0).getQkje());
				double dqqkje=user.getQkjl()-user.getYhje();
				user.setDqqkje(dqqkje);
			}
			userservice.update(user);
			print(1);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			print("0:" + e.getMessage());
		}
	}

	//删除
	@RequestMapping
	public void delFinancial()
	{
		try
		{
			//删除记录更新借款总额
			Financial po=service.get(req.getLong("keyIndex"));
			User user=userservice.get(po.getUserid());
			//如果删除后欠款当前欠款金额小于0，则抛出异常
			double dqje=user.getDqqkje()-po.getQkje();
			if(dqje<0){
				throw new Exception("当前欠款金额不能小于0,操作有误");
			}
			Map<String, Object> map=new HashMap<>();
			map.put("userid", po.getUserid());
			service.deleteBatch(CollectionUtil.toLongArray(req.getLongArray("keyIndex", 0)));
			//删除欠款成功则更新欠款记录
			List<Financial> list=service.queryQkjl(map);
			if(list.size()==1){
				user.setQkjl(list.get(0).getQkje());
				double dqqkje=user.getQkjl()-user.getYhje();
				user.setDqqkje(dqqkje);
			}
			userservice.update(user);

			print(1);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			print("0:" + e.getMessage());
		}
	}

	//修改
	@RequestMapping
	public String updFinancial1()
	{
		Long id = req.getLong("keyIndex");
		put("po", service.get(id));
		put("page", req.getInt("page", 1));
		return "/manage/account/financial/updFinancial.jsp";
	}

	@RequestMapping
	public void updFinancial2(Financial po)
	{
		try
		{
			service.update(po);
			print(1);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			print("0:" + e.getMessage());
		}
	}

	//获得分页
	@RequestMapping
	public String getFinancial()
	{
		Page<Financial> pageModel = service.queryPage(getPageRequest());
		put("pageModel", pageModel);
		put("userid", req.getLong("userid"));
		put("pageNav", new PageNav<Financial>(request, pageModel));
		return "/manage/account/financial/getFinancial.jsp";
	}

	//明细
	@RequestMapping
	public String getFinancialById()
	{
		Long id = req.getLong("keyIndex");
		put("po", service.get(id));
		return "/manage/account/financial/getFinancialById.jsp";
	}
}
