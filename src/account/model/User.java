/**
 * 用户表Model
 */
package account.model;
public class User
{
	// ID
	private Long id = 0L;
	// 用户名
	private String username = "";
	// 备注
	private String memo = "";
	//欠款记录
	private double qkjl = 0 ;
	//已还金额
	private double yhje = 0;
	//当前欠款金额
	private double dqqkje = 0;
	//创建时间
	private String createtime = "";
	public String getCreatetime()
	{
		return createtime;
	}

	public void setCreatetime(String createtime)
	{
		this.createtime = createtime;
	}

	public double getQkjl()
	{
		return qkjl;
	}

	public void setQkjl(double qkjl)
	{
		this.qkjl = qkjl;
	}

	public double getYhje()
	{
		return yhje;
	}

	public void setYhje(double yhje)
	{
		this.yhje = yhje;
	}

	public double getDqqkje()
	{
		return dqqkje;
	}

	public void setDqqkje(double dqqkje)
	{
		this.dqqkje = dqqkje;
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getMemo()
	{
		return memo;
	}

	public void setMemo(String memo)
	{
		this.memo = memo;
	}
}