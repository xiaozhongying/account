/**
 * 功能:用户表Controller
 * 开发人员:无名氏
 * 创建时间:2019-2-11 14:00:15
 */
package account.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.el.ELException;

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
@RequestMapping("/manage/account/user")
public class ManageAccountUserController extends BaseController
{
	@Autowired
	private ManageAccountUserService service;
	@Autowired
	private ManageAccountFinancialService financialservice;

	//添加
	@RequestMapping
	public String addUser1()
	{
		return "/manage/account/user/addUser.jsp";
	}

	@RequestMapping
	public void addUser2(User po)
	{
		try
		{
			//通过名字查找，判断该用户是否已经存在
			Map<String, Object> map=new HashMap<>();
			map.put("username", po.getUsername());
			List<User> userlist=service.queryList(map);
			if(userlist.size()>0){
				throw new Exception("该用户已存在");
			}
			po.setId(UniqueId.genId());
			po.setCreatetime(TimeUtil.getCurrentTime());
			service.save(po);
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
	public void delUser()
	{
		try
		{
			//根据用户id查看该用户是否有欠款记录，有则不能删除
			Map<String, Object> map=new HashMap<>();
			map.put("userid", req.getLong("keyIndex"));
			List<Financial> flist=financialservice.queryList(map);
			if(flist.size()>0){
				throw new Exception("该用户存在欠款记录，不能删除");
			}
			service.deleteBatch(CollectionUtil.toLongArray(req.getLongArray("keyIndex", 0)));
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
	public String updUser1()
	{
		Long id = req.getLong("keyIndex");
		put("po", service.get(id));
		put("page", req.getInt("page", 1));
		return "/manage/account/user/updUser.jsp";
	}

	@RequestMapping
	public void updUser2(User po)
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
	public String getUser()
	{
		Page<User> pageModel = service.queryPage(getPageRequest());
		put("pageModel", pageModel);
		put("pageNav", new PageNav<User>(request, pageModel));
		return "/manage/account/user/getUser.jsp";
	}

	//明细
	@RequestMapping
	public String getUserById()
	{
		Long id = req.getLong("keyIndex");
		put("po", service.get(id));
		return "/manage/account/user/getUserById.jsp";
	}
}
