package cn.cashbang.core.modules.venuesbook.service;

import java.util.Map;

import cn.cashbang.core.common.entity.Page;
import cn.cashbang.core.common.entity.Result;
import cn.cashbang.core.modules.venuesbook.entity.BPointsRecordEntity;

/**
 * 积分增减记录表
 *
 * @author daibangzhu
 * @email xxx@daibangzhu.cn
 * @url www.daibangzhu.cn
 * @date 2021年3月05日 下午2:01:23
 */
public interface BPointsRecordService {

	Page<BPointsRecordEntity> listBPointsRecord(Map<String, Object> params);
	
	Result saveBPointsRecord(BPointsRecordEntity bPointsRecord);
	
	Result getBPointsRecordById(Long id);
	
	Result updateBPointsRecord(BPointsRecordEntity bPointsRecord);
	
	Result batchRemove(Long[] id);
	
}
