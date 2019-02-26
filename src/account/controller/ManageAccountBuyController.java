/**
 * 功能:Controller
 * 开发人员:无名氏
 * 创建时间:2019-2-9 23:19:53
 */
package account.controller;

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
import account.model.Buy;
import account.service.ManageAccountBuyService;

@Scope("prototype")
@Controller
@RequestMapping("/manage/account/buy")
public class ManageAccountBuyController extends BaseController
{
	@Autowired
	private ManageAccountBuyService service;

	//添加
	@RequestMapping
	public String addBuy1()
	{
		return "/manage/account/buy/addBuy.jsp";
	}

	@RequestMapping
	public void addBuy2(Buy po)
	{
		try
		{
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
	public void delBuy()
	{
		try
		{
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
	public String updBuy1()
	{
		Long id = req.getLong("keyIndex");
		put("po", service.get(id));
		put("page", req.getInt("page", 1));
		return "/manage/account/buy/updBuy.jsp";
	}

	@RequestMapping
	public void updBuy2(Buy po)
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
	public String getBuy()
	{
		Page<Buy> pageModel = service.queryPage(getPageRequest());
		put("pageModel", pageModel);
		put("pageNav", new PageNav<Buy>(request, pageModel));
		return "/manage/account/buy/getBuy.jsp";
	}

	//明细
	@RequestMapping
	public String getBuyById()
	{
		Long id = req.getLong("keyIndex");
		put("po", service.get(id));
		return "/manage/account/buy/getBuyById.jsp";
	}
}
