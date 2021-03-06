package cn.cashbang.core.modules.venuesbook.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.cashbang.core.common.entity.Page;
import cn.cashbang.core.common.entity.Query;
import cn.cashbang.core.modules.venuesbook.dao.BExchangeRecordMapper;
import cn.cashbang.core.modules.venuesbook.entity.BExchangeRecordEntity;
import cn.cashbang.core.modules.venuesbook.manager.BExchangeRecordManager;

/**
 * 积分兑换记录表
 *
 * @author daibangzhu
 * @email xxx@daibangzhu.cn
 * @url www.daibangzhu.cn
 * @date 2021年3月05日 下午1:02:51
 */
@Component("bExchangeRecordManager")
public class BExchangeRecordManagerImpl implements BExchangeRecordManager {

	@Autowired
	private BExchangeRecordMapper bExchangeRecordMapper;
	

	@Override
	public List<BExchangeRecordEntity> listBExchangeRecord(Page<BExchangeRecordEntity> page, Query search) {
		return bExchangeRecordMapper.listForPage(page, search);
	}

	@Override
	public int saveBExchangeRecord(BExchangeRecordEntity bExchangeRecord) {
		return bExchangeRecordMapper.save(bExchangeRecord);
	}

	@Override
	public BExchangeRecordEntity getBExchangeRecordById(Long id) {
		BExchangeRecordEntity bExchangeRecord = bExchangeRecordMapper.getObjectById(id);
		return bExchangeRecord;
	}

	@Override
	public int updateBExchangeRecord(BExchangeRecordEntity bExchangeRecord) {
		return bExchangeRecordMapper.update(bExchangeRecord);
	}

	@Override
	public int batchRemove(Long[] id) {
		int count = bExchangeRecordMapper.batchRemove(id);
		return count;
	}
	
}
