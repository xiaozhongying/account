/**
 * Model
 */
package account.model;
public class Buy
{
	// ID
	private Long id = 0L;
	// 进货人
	private String name = "";
	// 货物名称
	private String hwmc = "";
	// 进货金额
	private double jhje = 0;
	// 进货说明
	private String memo = "";
	// 进货日期
	private String jhrq = "";
	// 创建时间
	private String createtime = "";

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

	public String getHwmc()
	{
		return hwmc;
	}

	public void setHwmc(String hwmc)
	{
		this.hwmc = hwmc;
	}



	public double getJhje()
	{
		return jhje;
	}

	public void setJhje(double jhje)
	{
		this.jhje = jhje;
	}

	public String getMemo()
	{
		return memo;
	}

	public void setMemo(String memo)
	{
		this.memo = memo;
	}

	public String getJhrq()
	{
		return jhrq;
	}

	public void setJhrq(String jhrq)
	{
		this.jhrq = jhrq;
	}

	public String getCreatetime()
	{
		return createtime;
	}

	public void setCreatetime(String createtime)
	{
		this.createtime = createtime;
	}
}