package cn.cashbang.core.modules.venuesbook.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.cashbang.core.common.entity.Page;
import cn.cashbang.core.common.entity.Query;
import cn.cashbang.core.modules.venuesbook.dao.BPointsRecordMapper;
import cn.cashbang.core.modules.venuesbook.entity.BPointsRecordEntity;
import cn.cashbang.core.modules.venuesbook.manager.BPointsRecordManager;

/**
 * 积分增减记录表
 *
 * @author daibangzhu
 * @email xxx@daibangzhu.cn
 * @url www.daibangzhu.cn
 * @date 2021年3月05日 下午2:01:23
 */
@Component("bPointsRecordManager")
public class BPointsRecordManagerImpl implements BPointsRecordManager {

	@Autowired
	private BPointsRecordMapper bPointsRecordMapper;
	

	@Override
	public List<BPointsRecordEntity> listBPointsRecord(Page<BPointsRecordEntity> page, Query search) {
		return bPointsRecordMapper.listForPage(page, search);
	}

	@Override
	public int saveBPointsRecord(BPointsRecordEntity bPointsRecord) {
		return bPointsRecordMapper.save(bPointsRecord);
	}

	@Override
	public BPointsRecordEntity getBPointsRecordById(Long id) {
		BPointsRecordEntity bPointsRecord = bPointsRecordMapper.getObjectById(id);
		return bPointsRecord;
	}

	@Override
	public int updateBPointsRecord(BPointsRecordEntity bPointsRecord) {
		return bPointsRecordMapper.update(bPointsRecord);
	}

	@Override
	public int batchRemove(Long[] id) {
		int count = bPointsRecordMapper.batchRemove(id);
		return count;
	}
	
}
