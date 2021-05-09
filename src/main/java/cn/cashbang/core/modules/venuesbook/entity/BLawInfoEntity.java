package cn.cashbang.core.modules.venuesbook.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 法律体检表
 *
 * @author daibangzhu
 * @email xxx@daibangzhu.cn
 * @url www.daibangzhu.cn
 * @date 2021年5月09日 下午3:00:03
 */
public class BLawInfoEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	private String lawId;
	
	/**
	 * 律师事务所名字
	 */
	private String lawName;
	
	/**
	 * 地址
	 */
	private String address;
	
	/**
	 * 联系方式
	 */
	private String phone;
	
	/**
	 * 服务描述
	 */
	private String remark;
	
	/**
	 * 
	 */
	private Date createTime;
	
	/**
	 * 
	 */
	private Date updateTime;
	

	public BLawInfoEntity() {
		super();
	}

	public void setLawId(String lawId) {
		this.lawId = lawId;
	}
	
	public String getLawId() {
		return lawId;
	}
	
	public void setLawName(String lawName) {
		this.lawName = lawName;
	}
	
	public String getLawName() {
		return lawName;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public String getRemark() {
		return remark;
	}
	
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	public Date getCreateTime() {
		return createTime;
	}
	
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	public Date getUpdateTime() {
		return updateTime;
	}
	
}
