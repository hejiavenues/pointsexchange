package cn.cashbang.core.modules.venuesbook.dao;

import org.apache.ibatis.annotations.Mapper;

import cn.cashbang.core.modules.venuesbook.entity.BGoodsInfoEntity;
import cn.cashbang.core.modules.sys.dao.BaseMapper;

/**
 * 
 *
 * @author daibangzhu
 * @email xxx@daibangzhu.cn
 * @url www.daibangzhu.cn
 * @date 2021年3月04日 下午1:11:01
 */
@Mapper
public interface BGoodsInfoMapper extends BaseMapper<BGoodsInfoEntity> {

	BGoodsInfoEntity getObjectByName(String goodsName);
	
}
