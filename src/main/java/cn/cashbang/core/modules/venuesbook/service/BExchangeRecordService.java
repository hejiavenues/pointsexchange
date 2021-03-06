package cn.cashbang.core.modules.venuesbook.service;

import java.util.Map;

import cn.cashbang.core.common.entity.Page;
import cn.cashbang.core.common.entity.Result;
import cn.cashbang.core.modules.venuesbook.entity.BExchangeRecordEntity;

/**
 * 积分兑换记录表
 *
 * @author daibangzhu
 * @email xxx@daibangzhu.cn
 * @url www.daibangzhu.cn
 * @date 2021年3月05日 下午1:02:51
 */
public interface BExchangeRecordService {

	Page<BExchangeRecordEntity> listBExchangeRecord(Map<String, Object> params);
	
	Result saveBExchangeRecord(BExchangeRecordEntity bExchangeRecord);
	
	Result getBExchangeRecordById(Long id);
	
	Result updateBExchangeRecord(BExchangeRecordEntity bExchangeRecord);
	
	Result batchRemove(Long[] id);
	
}
