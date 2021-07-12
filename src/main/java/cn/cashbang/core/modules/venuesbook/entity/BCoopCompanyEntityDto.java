package cn.cashbang.core.modules.venuesbook.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 合作企业列表信息
 *
 * @author daibangzhu
 * @email xxx@daibangzhu.cn
 * @url www.daibangzhu.cn
 * @date 2021年7月12日 下午7:57:27
 */
public class BCoopCompanyEntityDto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 主键
	 */
	private String cid;
	
	/**
	 * 公司图标
	 */
	private String companyLogo;
	
	/**
	 * 公司名字
	 */
	private String companyName;
	

	public BCoopCompanyEntityDto() {
		super();
	}

	public void setCid(String cid) {
		this.cid = cid;
	}
	
	public String getCid() {
		return cid;
	}
	
	public void setCompanyLogo(String companyLogo) {
		this.companyLogo = companyLogo;
	}
	
	public String getCompanyLogo() {
		return companyLogo;
	}
	
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	public String getCompanyName() {
		return companyName;
	}
	
}
