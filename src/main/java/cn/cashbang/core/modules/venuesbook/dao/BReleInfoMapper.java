package cn.cashbang.core.modules.venuesbook.dao;

import org.apache.ibatis.annotations.Mapper;

import cn.cashbang.core.modules.venuesbook.entity.BReleInfoEntity;
import cn.cashbang.core.modules.sys.dao.BaseMapper;

/**
 * 企业上下游关系信息表
 *
 * @author daibangzhu
 * @email xxx@daibangzhu.cn
 * @url www.daibangzhu.cn
 * @date 2021年6月18日 下午9:56:11
 */
@Mapper
public interface BReleInfoMapper extends BaseMapper<BReleInfoEntity> {
	
}
