/**
 * 客户欠款明细账Model
 */
package account.model;
public class Financial
{
	// ID
	private Long id = 0L;
	// 欠款人名称
	private String name = "";
	// 欠款金额
	private double qkje = 0;
	// 欠款日期
	private String datetime = "";
	// 欠款描述
	private String memo = "";
	//创建时间
	private String createtime = "";
	//欠款人ID
	private Long userid = 0L;

	public Long getUserid()
	{
		return userid;
	}

	public void setUserid(Long userid)
	{
		this.userid = userid;
	}

	public String getCreatetime()
	{
		return createtime;
	}

	public void setCreatetime(String createtime)
	{
		this.createtime = createtime;
	}

	public void setQkje(double qkje)
	{
		this.qkje = qkje;
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public double getQkje()
	{
		return qkje;
	}

	public void setQkje(float qkje)
	{
		this.qkje = qkje;
	}

	public String getDatetime()
	{
		return datetime;
	}

	public void setDatetime(String datetime)
	{
		this.datetime = datetime;
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