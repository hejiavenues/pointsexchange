package cn.cashbang.core.modules.venuesbook.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 外部场馆信息表
 *
 * @author daibangzhu
 * @email xxx@daibangzhu.cn
 * @url www.daibangzhu.cn
 * @date 2021年5月09日 下午3:01:01
 */
public class BVenueInfoOutEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 主键
	 */
	private String venueId;
	
	/**
	 * 场馆名称
	 */
	private String venueName;
	
	/**
	 * 最大容纳人数
	 */
	private Integer maxPeople;
	
	/**
	 * 场馆地址
	 */
	private String address;
	
	/**
	 * 所属企业用户Id
	 */
	private String userId;
	
	private String userName;
	
	/**
	 * 支持的活动类型，字符串
	 */
	private String supportActiveType;
	
	/**
	 * 图片地址
	 */
	private String iconUrl;
	
	/**
	 * 0可用1隐藏
	 */
	private Integer status;
	
	private String statusStr;
	
	/**
	 * 开放时间
	 */
	private String openTime;
	
	/**
	 * 支持活动内容
	 */
	private String activityRemark;
	
	/**
	 * 创建时间
	 */
	private Date createTime;
	
	/**
	 * 修改时间
	 */
	private Date updateTime;
	

	public BVenueInfoOutEntity() {
		super();
	}

	public void setVenueId(String venueId) {
		this.venueId = venueId;
	}
	
	public String getVenueId() {
		return venueId;
	}
	
	public void setVenueName(String venueName) {
		this.venueName = venueName;
	}
	
	public String getVenueName() {
		return venueName;
	}
	
	public void setMaxPeople(Integer maxPeople) {
		this.maxPeople = maxPeople;
	}
	
	public Integer getMaxPeople() {
		return maxPeople;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public void setSupportActiveType(String supportActiveType) {
		this.supportActiveType = supportActiveType;
	}
	
	public String getSupportActiveType() {
		return supportActiveType;
	}
	
	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}
	
	public String getIconUrl() {
		return iconUrl;
	}
	
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public Integer getStatus() {
		return status;
	}
	
	public void setOpenTime(String openTime) {
		this.openTime = openTime;
	}
	
	public String getOpenTime() {
		return openTime;
	}
	
	public void setActivityRemark(String activityRemark) {
		this.activityRemark = activityRemark;
	}
	
	public String getActivityRemark() {
		return activityRemark;
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

	public String getStatusStr() {
		return statusStr;
	}

	public void setStatusStr(String statusStr) {
		this.statusStr = statusStr;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}
