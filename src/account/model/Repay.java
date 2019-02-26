/**
 * Model
 */
package account.model;
public class Repay
{
	// ID
	private Long id = 0L;
	// 姓名
	private String name = "";
	// 还款金额(元)
	private float hkje = 0F;
	// 说明
	private String memo = "";
	// 还款日期
	private String hkrq = "";
	// 创建时间
	private String createtime = "";
	// 还款人ID
	private long userid = 0L;

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

	public float getHkje()
	{
		return hkje;
	}

	public void setHkje(float hkje)
	{
		this.hkje = hkje;
	}

	public String getMemo()
	{
		return memo;
	}

	public void setMemo(String memo)
	{
		this.memo = memo;
	}

	public String getHkrq()
	{
		return hkrq;
	}

	public void setHkrq(String hkrq)
	{
		this.hkrq = hkrq;
	}

	public String getCreatetime()
	{
		return createtime;
	}

	public void setCreatetime(String createtime)
	{
		this.createtime = createtime;
	}

	public long getUserid()
	{
		return userid;
	}

	public void setUserid(long userid)
	{
		this.userid = userid;
	}
}