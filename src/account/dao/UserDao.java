/**
 * 用户表Dao
 */
package account.dao;

import org.springframework.stereotype.Repository;
import dswork.core.db.BaseDao;
import account.model.User;

@Repository
@SuppressWarnings("all")
public class UserDao extends BaseDao<User, Long>
{
	@Override
	public Class getEntityClass()
	{
		return UserDao.class;
	}
}