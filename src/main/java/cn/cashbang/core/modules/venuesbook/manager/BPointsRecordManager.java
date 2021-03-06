package cn.cashbang.core.modules.venuesbook.manager;

import java.util.List;

import cn.cashbang.core.common.entity.Page;
import cn.cashbang.core.common.entity.Query;
import cn.cashbang.core.modules.venuesbook.entity.BPointsRecordEntity;

/**
 * 积分增减记录表
 *
 * @author daibangzhu
 * @email xxx@daibangzhu.cn
 * @url www.daibangzhu.cn
 * @date 2021年3月05日 下午2:01:23
 */
public interface BPointsRecordManager {

	List<BPointsRecordEntity> listBPointsRecord(Page<BPointsRecordEntity> page, Query search);
	
	int saveBPointsRecord(BPointsRecordEntity bPointsRecord);
	
	BPointsRecordEntity getBPointsRecordById(Long id);
	
	int updateBPointsRecord(BPointsRecordEntity bPointsRecord);
	
	int batchRemove(Long[] id);
	
}
