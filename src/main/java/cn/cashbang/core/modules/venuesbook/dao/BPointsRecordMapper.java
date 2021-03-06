package cn.cashbang.core.modules.venuesbook.dao;

import org.apache.ibatis.annotations.Mapper;

import cn.cashbang.core.modules.venuesbook.entity.BPointsRecordEntity;
import cn.cashbang.core.modules.sys.dao.BaseMapper;

/**
 * 积分增减记录表
 *
 * @author daibangzhu
 * @email xxx@daibangzhu.cn
 * @url www.daibangzhu.cn
 * @date 2021年3月05日 下午2:01:23
 */
@Mapper
public interface BPointsRecordMapper extends BaseMapper<BPointsRecordEntity> {
	
}
