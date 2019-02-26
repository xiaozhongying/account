/**
 * 用户表Service
 */
package account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dswork.core.db.EntityDao;
import dswork.core.db.BaseService;
import account.model.User;
import account.dao.UserDao;

@Service
@SuppressWarnings("all")
public class ManageAccountUserService extends BaseService<User, Long>
{
	@Autowired
	private UserDao dao;

	@Override
	protected EntityDao getEntityDao()
	{
		return dao;
	}
}
