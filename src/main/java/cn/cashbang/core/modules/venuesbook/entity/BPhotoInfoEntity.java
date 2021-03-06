package cn.cashbang.core.modules.venuesbook.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 随拍信息表
 *
 * @author daibangzhu
 * @email xxx@daibangzhu.cn
 * @url www.daibangzhu.cn
 * @date 2020年12月22日 下午1:12:01
 */
public class BPhotoInfoEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 主键
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
	 * 内容
	 */
	private String content;
	
	/**
	 * 图片地址逗号隔开
	 */
	private String pitureUrls;
	/**
	 * 图片地址逗号隔开
	 */
	private String[] arraypitureUrl = new String[8];
	
	/**
	 * 社区id
	 */
	private String committeeId;
	/**
	 * 社区名称
	 */
	private String committeeName;
	
	/**
	 * 状态 1.正常 2.删除
	 */
	private Integer status;
	/**
	 * 状态 1.正常 2.删除
	 */
	private String statusDesc;
	
	/**
	 * 创建时间
	 */
	private Date createTime;
	
	/**
	 * 更新时间
	 */
	private Date updateTime;

	private String iconUrl;

	public String getIconUrl() {
		return iconUrl;
	}

	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}

	public BPhotoInfoEntity() {
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
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setPitureUrls(String pitureUrls) {
		this.pitureUrls = pitureUrls;
	}
	
	public String getPitureUrls() {
		return pitureUrls;
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

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String[] getArraypitureUrl() {
		return arraypitureUrl;
	}

	public void setArraypitureUrl(String[] arraypitureUrl) {
		this.arraypitureUrl = arraypitureUrl;
	}

	public String getCommitteeName() {
		return committeeName;
	}

	public void setCommitteeName(String committeeName) {
		this.committeeName = committeeName;
	}

	public String getStatusDesc() {
		return statusDesc;
	}

	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}
	
}
