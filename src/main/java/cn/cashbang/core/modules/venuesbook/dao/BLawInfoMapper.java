package cn.cashbang.core.modules.venuesbook.dao;

import org.apache.ibatis.annotations.Mapper;

import cn.cashbang.core.modules.venuesbook.entity.BLawInfoEntity;
import cn.cashbang.core.modules.sys.dao.BaseMapper;

/**
 * 法律体检表
 *
 * @author daibangzhu
 * @email xxx@daibangzhu.cn
 * @url www.daibangzhu.cn
 * @date 2021年5月09日 下午3:00:03
 */
@Mapper
public interface BLawInfoMapper extends BaseMapper<BLawInfoEntity> {

	BLawInfoEntity getBLawInfoByName(String id);
	
}
