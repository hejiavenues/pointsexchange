package cn.cashbang.core.modules.venuesbook.dao;

import org.apache.ibatis.annotations.Mapper;

import cn.cashbang.core.modules.venuesbook.entity.BVenueInfoOutEntity;
import cn.cashbang.core.modules.sys.dao.BaseMapper;

/**
 * 外部场馆信息表
 *
 * @author daibangzhu
 * @email xxx@daibangzhu.cn
 * @url www.daibangzhu.cn
 * @date 2021年5月09日 下午3:01:01
 */
@Mapper
public interface BVenueInfoOutMapper extends BaseMapper<BVenueInfoOutEntity> {
	
}
