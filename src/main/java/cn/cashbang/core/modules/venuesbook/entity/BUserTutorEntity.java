package cn.cashbang.core.modules.venuesbook.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 志愿者导师信息表
 *
 * @author daibangzhu
 * @email xxx@daibangzhu.cn
 * @url www.daibangzhu.cn
 * @date 2021年6月15日 下午7:23:45
 */
public class BUserTutorEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	private String uid;
	
	/**
	 * 用户名称
	 */
	private String uname;
	
	/**
	 * 用户性别（1.男 0.女）
	 */
	private Integer sex;
	
	private String sexStr;
	
	/**
	 * 手机号
	 */
	private String mobile;
	
	/**
	 * 个人特长
	 */
	private String skill;
	
	/**
	 * 特长说明
	 */
	private String skillDes;
	
	/**
	 * 头像地址
	 */
	private String iconUrl;
	
	/**
	 * 导师宣传图
	 */
	private String idcardBackUrl;
	
	/**
	 * 居委会id
	 */
	private String committeeId;
	
	/**
	 * 状态 0.审核中 1.审核通过 2.审核拒绝
	 */
	private Integer status;
	
	/**
	 * 创建时间
	 */
	private Date createTime;
	
	/**
	 * 更新时间
	 */
	private Date updateTime;
	
	private String committeeName;
	
	private String statusStr;
	

	public BUserTutorEntity() {
		super();
	}

	public void setUid(String uid) {
		this.uid = uid;
	}
	
	public String getUid() {
		return uid;
	}
	
	public void setUname(String uname) {
		this.uname = uname;
	}
	
	public String getUname() {
		return uname;
	}
	
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	
	public Integer getSex() {
		return sex;
	}
	
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	public String getMobile() {
		return mobile;
	}
	
	public void setSkill(String skill) {
		this.skill = skill;
	}
	
	public String getSkill() {
		return skill;
	}
	
	public void setSkillDes(String skillDes) {
		this.skillDes = skillDes;
	}
	
	public String getSkillDes() {
		return skillDes;
	}
	
	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}
	
	public String getIconUrl() {
		return iconUrl;
	}
	
	public void setIdcardBackUrl(String idcardBackUrl) {
		this.idcardBackUrl = idcardBackUrl;
	}
	
	public String getIdcardBackUrl() {
		return idcardBackUrl;
	}
	
	public void setCommitteeId(String committeeId) {
		this.committeeId = committeeId;
	}
	
	public String getCommitteeId() {
		return committeeId;
	}
	
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public Integer getStatus() {
		return status;
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

	public String getSexStr() {
		return sexStr;
	}

	public void setSexStr(String sexStr) {
		this.sexStr = sexStr;
	}

	public String getCommitteeName() {
		return committeeName;
	}

	public void setCommitteeName(String committeeName) {
		this.committeeName = committeeName;
	}

	public String getStatusStr() {
		return statusStr;
	}

	public void setStatusStr(String statusStr) {
		this.statusStr = statusStr;
	}
	
}
