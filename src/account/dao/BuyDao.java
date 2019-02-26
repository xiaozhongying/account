/**
 * Dao
 */
package account.dao;

import org.springframework.stereotype.Repository;
import dswork.core.db.BaseDao;
import account.model.Buy;

@Repository
@SuppressWarnings("all")
public class BuyDao extends BaseDao<Buy, Long>
{
	@Override
	public Class getEntityClass()
	{
		return BuyDao.class;
	}
}