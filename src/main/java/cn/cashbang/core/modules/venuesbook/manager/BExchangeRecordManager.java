package cn.cashbang.core.modules.venuesbook.manager;

import java.util.List;

import cn.cashbang.core.common.entity.Page;
import cn.cashbang.core.common.entity.Query;
import cn.cashbang.core.modules.venuesbook.entity.BExchangeRecordEntity;

/**
 * 积分兑换记录表
 *
 * @author daibangzhu
 * @email xxx@daibangzhu.cn
 * @url www.daibangzhu.cn
 * @date 2021年3月05日 下午1:02:51
 */
public interface BExchangeRecordManager {

	List<BExchangeRecordEntity> listBExchangeRecord(Page<BExchangeRecordEntity> page, Query search);
	
	int saveBExchangeRecord(BExchangeRecordEntity bExchangeRecord);
	
	BExchangeRecordEntity getBExchangeRecordById(Long id);
	
	int updateBExchangeRecord(BExchangeRecordEntity bExchangeRecord);
	
	int batchRemove(Long[] id);
	
}
