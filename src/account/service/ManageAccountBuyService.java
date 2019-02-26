/**
 * Service
 */
package account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dswork.core.db.EntityDao;
import dswork.core.db.BaseService;
import account.model.Buy;
import account.dao.BuyDao;

@Service
@SuppressWarnings("all")
public class ManageAccountBuyService extends BaseService<Buy, Long>
{
	@Autowired
	private BuyDao dao;

	@Override
	protected EntityDao getEntityDao()
	{
		return dao;
	}
}
