package cn.cashbang.core.modules.venuesbook.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 招聘信息表
 *
 * @author daibangzhu
 * @email xxx@daibangzhu.cn
 * @url www.daibangzhu.cn
 * @date 2021年5月09日 下午2:54:48
 */
public class BRecruitInfoEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	private String recruitId;
	
	/**
	 * 所属企业用户Id
	 */
	private String userId;
	
	private String userName;
	
	/**
	 * 招聘人称呼
	 */
	private String hrName;
	
	/**
	 * 招聘人联系方式
	 */
	private String phone;
	
	/**
	 * 岗位名称
	 */
	private String jobName;
	
	/**
	 * 薪资待遇
	 */
	private String salary;
	
	/**
	 * 岗位描述描述
	 */
	private String remark;
	
	/**
	 * 招聘人数
	 */
	private String recruitNumber;
	
	/**
	 * 
	 */
	private Date createTime;
	
	/**
	 * 
	 */
	private Date updateTime;
	
    private String companyName;

    private String address;



	public BRecruitInfoEntity() {
		super();
	}

	public void setRecruitId(String recruitId) {
		this.recruitId = recruitId;
	}

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRecruitId() {
		return recruitId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public void setHrName(String hrName) {
		this.hrName = hrName;
	}
	
	public String getHrName() {
		return hrName;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	
	public String getJobName() {
		return jobName;
	}
	
	public void setSalary(String salary) {
		this.salary = salary;
	}
	
	public String getSalary() {
		return salary;
	}
	
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public String getRemark() {
		return remark;
	}
	
	public void setRecruitNumber(String recruitNumber) {
		this.recruitNumber = recruitNumber;
	}
	
	public String getRecruitNumber() {
		return recruitNumber;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}
