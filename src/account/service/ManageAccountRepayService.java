/**
 * Service
 */
package account.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dswork.core.db.EntityDao;
import dswork.core.db.BaseService;
import account.model.Repay;
import account.dao.RepayDao;

@Service
@SuppressWarnings("all")
public class ManageAccountRepayService extends BaseService<Repay, Long>
{
	@Autowired
	private RepayDao dao;

	@Override
	protected EntityDao getEntityDao()
	{
		return dao;
	}
	/**通过用户id获取还款记录数*/
	public List<Repay> queryHkje(Map<String, Object> map){
		return dao.queryHkje(map);
	}
}
