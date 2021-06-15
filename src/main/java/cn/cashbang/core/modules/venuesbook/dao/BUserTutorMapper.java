package cn.cashbang.core.modules.venuesbook.dao;

import org.apache.ibatis.annotations.Mapper;

import cn.cashbang.core.modules.venuesbook.entity.BUserTutorEntity;
import cn.cashbang.core.modules.sys.dao.BaseMapper;

/**
 * 志愿者导师信息表
 *
 * @author daibangzhu
 * @email xxx@daibangzhu.cn
 * @url www.daibangzhu.cn
 * @date 2021年6月15日 下午7:23:45
 */
@Mapper
public interface BUserTutorMapper extends BaseMapper<BUserTutorEntity> {

	int passApply(String[] id);

	int refuseApply(String[] id);
	
}
