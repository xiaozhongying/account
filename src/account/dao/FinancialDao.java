/**
 * 客户欠款明细账Dao
 */
package account.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import dswork.core.db.BaseDao;
import account.model.Financial;

@Repository
@SuppressWarnings("all")
public class FinancialDao extends BaseDao<Financial, Long>
{
	@Override
	public Class getEntityClass()
	{
		return FinancialDao.class;
	}
	/**通过用户id获取欠款记录数*/
	public List<Financial> queryQkjl(Map<String, Object> map){
		return executeSelectList("queryQkjl", map);
	}
}