package cn.cashbang.core.modules.venuesbook.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;



/**
 * 
 *
 * @author daibangzhu
 * @email xxx@daibangzhu.cn
 * @url www.daibangzhu.cn
 * @date 2021年3月04日 下午1:11:01
 */
public class BGoodsDtoEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 主键ID
	 */
	private String gid;
	
	/**
	 * 商品名称
	 */
	private String goodsName;
	
	/**
	 * 图片路径
	 */
	private String goodsPicurl;
	
	/**
	 * 所需积分
	 */
	private BigDecimal points;
	
	/**
	 * 市场价
	 */
	private BigDecimal price;
	
	/**
	 * 上架状态（1，上架 2 下架）
	 */
	private Integer goodsStatus;

    private String remark;
    private Integer goodsCount;

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(Integer goodsCount) {
        this.goodsCount = goodsCount;
    }
	
	public BGoodsDtoEntity() {
		super();
	}

	public void setGid(String gid) {
		this.gid = gid;
	}
	
	public String getGid() {
		return gid;
	}
	
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	
	public String getGoodsName() {
		return goodsName;
	}
	
	public void setGoodsPicurl(String goodsPicurl) {
		this.goodsPicurl = goodsPicurl;
	}
	
	public String getGoodsPicurl() {
		return goodsPicurl;
	}
	
	public void setPoints(BigDecimal points) {
		this.points = points;
	}
	
	public BigDecimal getPoints() {
		return points;
	}
	
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	public BigDecimal getPrice() {
		return price;
	}
	
	public void setGoodsStatus(Integer goodsStatus) {
		this.goodsStatus = goodsStatus;
	}
	
	public Integer getGoodsStatus() {
		return goodsStatus;
	}
	
}
