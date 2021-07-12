package cn.cashbang.core.modules.venuesbook.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 文章列表信息
 *
 * @author daibangzhu
 * @email xxx@daibangzhu.cn
 * @url www.daibangzhu.cn
 * @date 2021年7月12日 下午7:56:51
 */
public class BNewsEntityDto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 主键
	 */
	private String nid;
	
	/**
	 * 文章标题
	 */
	private String title;
	
	/**
	 * 文章图片
	 */
	private String newsImg;
	
	/**
	 * 文章内容
	 */
	private String newsContent;
	
	/**
	 * 是否可用（1.可用 0.不可用）
	 */
	//private Integer isuse;
	

	public BNewsEntityDto() {
		super();
	}

	public void setNid(String nid) {
		this.nid = nid;
	}
	
	public String getNid() {
		return nid;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setNewsImg(String newsImg) {
		this.newsImg = newsImg;
	}
	
	public String getNewsImg() {
		return newsImg;
	}
	
	public void setNewsContent(String newsContent) {
		this.newsContent = newsContent;
	}
	
	public String getNewsContent() {
		return newsContent;
	}
	
	/*
	 * public void setIsuse(Integer isuse) { this.isuse = isuse; }
	 * 
	 * public Integer getIsuse() { return isuse; }
	 */
	
}
