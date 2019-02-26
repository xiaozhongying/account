/**
 * Dao
 */
package account.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import dswork.core.db.BaseDao;
import account.model.Financial;
import account.model.Repay;

@Repository
@SuppressWarnings("all")
public class RepayDao extends BaseDao<Repay, Long>
{
	@Override
	public Class getEntityClass()
	{
		return RepayDao.class;
	}
	/**通过用户id获取还款记录数*/
	public List<Repay> queryHkje(Map<String, Object> map){
		return executeSelectList("queryHkje", map);
	}
}