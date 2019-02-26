/**
 * 功能:Controller
 * 开发人员:无名氏
 * 创建时间:2019-2-11 17:38:32
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
import account.model.Repay;
import account.model.User;
import account.service.ManageAccountRepayService;
import account.service.ManageAccountUserService;

@Scope("prototype")
@Controller
@RequestMapping("/manage/account/repay")
public class ManageAccountRepayController extends BaseController
{
	@Autowired
	private ManageAccountRepayService service;
	@Autowired
	private ManageAccountUserService userservice;

	//添加
	@RequestMapping
	public String addRepay1()
	{
		put("userid", req.getLong("userid"));
		put("username", req.getString("username"));
		return "/manage/account/repay/addRepay.jsp";
	}

	@RequestMapping
	public void addRepay2(Repay po)
	{
		try
		{
			//获取当前用户
			User user=userservice.get(po.getUserid());
			//如果应还金额为0,抛出异常
			if(user.getDqqkje()==0){
				throw new Exception("当前欠款金额为0,不能进行还款操作");
			}
			//如果还款金额大于应还金额，不能进行操作
			if(po.getHkje()>user.getDqqkje()){
				throw new Exception("还款金额不能大于当前欠款金额,不能进行还款操作");
			}
			Map<String, Object> map=new HashMap<>();
			map.put("userid", po.getUserid());
			po.setId(UniqueId.genId());
			po.setCreatetime(TimeUtil.getCurrentTime());
			service.save(po);
			//还款成功后更新还款总额
			List<Repay> rlist=service.queryHkje(map);
			if(rlist.size()>0){
				user.setYhje(rlist.get(0).getHkje());
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
	public void delRepay()
	{
		try
		{
			Repay po=service.get(req.getLong("keyIndex"));
			Map<String, Object> map=new HashMap<>();
			map.put("userid", po.getUserid());
			service.deleteBatch(CollectionUtil.toLongArray(req.getLongArray("keyIndex", 0)));
			//删除成功后更新还款总额
			User user=userservice.get(po.getUserid());
			List<Repay> rlist=service.queryHkje(map);
			if(rlist.size()>0){
				user.setYhje(rlist.get(0).getHkje());
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
	public String updRepay1()
	{
		Long id = req.getLong("keyIndex");
		put("po", service.get(id));
		put("page", req.getInt("page", 1));
		return "/manage/account/repay/updRepay.jsp";
	}

	@RequestMapping
	public void updRepay2(Repay po)
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
	public String getRepay()
	{
		Page<Repay> pageModel = service.queryPage(getPageRequest());
		put("pageModel", pageModel);
		put("userid", req.getLong("userid"));
		put("pageNav", new PageNav<Repay>(request, pageModel));
		return "/manage/account/repay/getRepay.jsp";
	}

	//明细
	@RequestMapping
	public String getRepayById()
	{
		Long id = req.getLong("keyIndex");
		put("po", service.get(id));
		return "/manage/account/repay/getRepayById.jsp";
	}
}
