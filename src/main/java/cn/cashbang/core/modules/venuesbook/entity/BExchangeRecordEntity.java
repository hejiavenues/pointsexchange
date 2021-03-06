package cn.cashbang.core.modules.venuesbook.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 积分兑换记录表
 *
 * @author daibangzhu
 * @email xxx@daibangzhu.cn
 * @url www.daibangzhu.cn
 * @date 2021年3月05日 下午1:02:51
 */
public class BExchangeRecordEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 主键
	 */
	private String id;
	
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
	private String umobile;
	/**
	 * 用户id
	 */
	private String companyName;
	/**
	 * 角色id （1.普通用户 2.企业用户）
	 */
	private Integer userRole;
	/**
	 * 商品id
	 */
	private String gid;
	/**
	 * 商品id
	 */
	private String gname;
	
	private Integer gpoints;
	/**
	 * 消耗的积分
	 */
	private String points;
	
	/**
	 * 兑换状态（1、成功 2、取消），备用字段
	 */
	private Integer exStatus;
	
	/**
	 * 兑换时间
	 */
	private Date createTime;
	
	/**
	 * 修改时间
	 */
	private Date updateTime;
	

	public BExchangeRecordEntity() {
		super();
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
	
	public void setUid(String uid) {
		this.uid = uid;
	}
	
	public String getUid() {
		return uid;
	}
	
	public void setGid(String gid) {
		this.gid = gid;
	}
	
	public String getGid() {
		return gid;
	}
	
	public void setPoints(String points) {
		this.points = points;
	}
	
	public String getPoints() {
		return points;
	}
	
	public void setExStatus(Integer exStatus) {
		this.exStatus = exStatus;
	}
	
	public Integer getExStatus() {
		return exStatus;
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

	public String getUmobile() {
		return umobile;
	}

	public void setUmobile(String umobile) {
		this.umobile = umobile;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Integer getUserRole() {
		return userRole;
	}

	public void setUserRole(Integer userRole) {
		this.userRole = userRole;
	}

	public String getGname() {
		return gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}

	public Integer getGpoints() {
		return gpoints;
	}

	public void setGpoints(Integer gpoints) {
		this.gpoints = gpoints;
	}
	
}
