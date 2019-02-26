/**
 * 客户欠款明细账Service
 */
package account.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dswork.core.db.EntityDao;
import dswork.core.db.BaseService;
import account.model.Financial;
import account.dao.FinancialDao;

@Service
@SuppressWarnings("all")
public class ManageAccountFinancialService extends BaseService<Financial, Long>
{
	@Autowired
	private FinancialDao dao;

	@Override
	protected EntityDao getEntityDao()
	{
		return dao;
	}
	/**通过用户id获取欠款记录数*/
	public List<Financial> queryQkjl(Map<String, Object> map){
		return dao.queryQkjl(map);
	}
}
