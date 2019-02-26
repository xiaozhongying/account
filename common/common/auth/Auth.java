package common.auth;

public class Auth
{
	//id
	private Long id;
	/**
	 * 用户名
	 */
	private String account;
	/**
	 * 用户名
	 */
	private String name;
	/**
	 * 用户类型
	 * @return
	 */
	private String type;
	public Long getId()
	{
		return id;
	}
	public void setId(Long id)
	{
		this.id = id;
	}
	public String getAccount()
	{
		return account;
	}
	public void setAccount(String account)
	{
		this.account = account;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getType()
	{
		return type;
	}
	public void setType(String type)
	{
		this.type = type;
	}
	

	
	
}
