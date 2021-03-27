package cn.cashbang.core.modules.venuesbook.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 积分增减记录表
 *
 * @author daibangzhu
 * @email xxx@daibangzhu.cn
 * @url www.daibangzhu.cn
 * @date 2021年3月05日 下午2:01:23
 */
public class BPointsRecordEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	private String pid;
	
	/**
	 * 用户id
	 */
	private String uid;
	/**
	 * 用户id
	 */
	private String uname;
	/**
	 * 用户id
	 */
	private String remark;
	
	/**
	 * 获得的积分数量
	 */
	private Integer points;
	
	/**
	 * 获取或消耗方式（1、参加活动 2、发布随拍 3、兑换商品）
	 */
	private Integer accessType;
	
	/**
	 * 创建时间
	 */
	private Date createTime;
	
	/**
	 * 修改时间
	 */
	private Date updateTime;
	

	public BPointsRecordEntity() {
		super();
	}

	public void setPid(String pid) {
		this.pid = pid;
	}
	
	public String getPid() {
		return pid;
	}
	
	public void setUid(String uid) {
		this.uid = uid;
	}
	
	public String getUid() {
		return uid;
	}
	
	public void setPoints(Integer points) {
		this.points = points;
	}
	
	public Integer getPoints() {
		return points;
	}
	
	public void setAccessType(Integer accessType) {
		this.accessType = accessType;
	}
	
	public Integer getAccessType() {
		return accessType;
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

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
