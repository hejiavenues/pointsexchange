package cn.cashbang.core.modules.venuesbook.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 社区活动信息表
 *
 * @author daibangzhu
 * @email xxx@daibangzhu.cn
 * @url www.daibangzhu.cn
 * @date 2021年2月27日 PM9:46:01
 */
public class BCommunityActivitiesDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 活动id
	 */
	private String comActivityId;
	
	/**
	 * 发起人id
	 */
	private String uid;
	
	/**
	 * 活动名称
	 */
	private String activityName;
	
	/**
	 * 活动人数
	 */
	private Integer activityCount;
	
	/**
	 * 活动类型
	 */
	private String activityType;
	
	/**
	 * 活动内容
	 */
	private String activityContent;
	
	/**
	 * 活动时段
	 */
	private String activityTime;
	

	private String address;
	
	private String picUrl;

    /**
     * 预约人姓名
     */
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BCommunityActivitiesDTO() {
		super();
	}

	public void setComActivityId(String comActivityId) {
		this.comActivityId = comActivityId;
	}
	
	public String getComActivityId() {
		return comActivityId;
	}
	
	public void setUid(String uid) {
		this.uid = uid;
	}
	
	public String getUid() {
		return uid;
	}
	
	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}
	
	public String getActivityName() {
		return activityName;
	}
	
	public void setActivityCount(Integer activityCount) {
		this.activityCount = activityCount;
	}
	
	public Integer getActivityCount() {
		return activityCount;
	}
	
	public void setActivityType(String activityType) {
		this.activityType = activityType;
	}
	
	public String getActivityType() {
		return activityType;
	}
	
	public void setActivityContent(String activityContent) {
		this.activityContent = activityContent;
	}
	
	public String getActivityContent() {
		return activityContent;
	}
	
	public void setActivityTime(String activityTime) {
		this.activityTime = activityTime;
	}
	
	public String getActivityTime() {
		return activityTime;
	}
	
	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
	
}
