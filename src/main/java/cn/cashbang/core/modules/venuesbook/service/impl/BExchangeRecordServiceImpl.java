package cn.cashbang.core.modules.venuesbook.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.cashbang.core.common.entity.Page;
import cn.cashbang.core.common.entity.Query;
import cn.cashbang.core.common.entity.Result;
import cn.cashbang.core.common.utils.CommonUtils;
import cn.cashbang.core.modules.venuesbook.entity.BExchangeRecordEntity;
import cn.cashbang.core.modules.venuesbook.manager.BExchangeRecordManager;
import cn.cashbang.core.modules.venuesbook.service.BExchangeRecordService;

/**
 * 积分兑换记录表
 *
 * @author daibangzhu
 * @email xxx@daibangzhu.cn
 * @url www.daibangzhu.cn
 * @date 2021年3月05日 下午1:02:51
 */
@Service("bExchangeRecordService")
public class BExchangeRecordServiceImpl implements BExchangeRecordService {

	@Autowired
	private BExchangeRecordManager bExchangeRecordManager;

	@Override
	public Page<BExchangeRecordEntity> listBExchangeRecord(Map<String, Object> params) {
		Query query = new Query(params);
		Page<BExchangeRecordEntity> page = new Page<>(query);
		bExchangeRecordManager.listBExchangeRecord(page, query);
		return page;
	}

	@Override
	public Result saveBExchangeRecord(BExchangeRecordEntity role) {
		int count = bExchangeRecordManager.saveBExchangeRecord(role);
		return CommonUtils.msg(count);
	}

	@Override
	public Result getBExchangeRecordById(Long id) {
		BExchangeRecordEntity bExchangeRecord = bExchangeRecordManager.getBExchangeRecordById(id);
		return CommonUtils.msg(bExchangeRecord);
	}

	@Override
	public Result updateBExchangeRecord(BExchangeRecordEntity bExchangeRecord) {
		int count = bExchangeRecordManager.updateBExchangeRecord(bExchangeRecord);
		return CommonUtils.msg(count);
	}

	@Override
	public Result batchRemove(Long[] id) {
		int count = bExchangeRecordManager.batchRemove(id);
		return CommonUtils.msg(id, count);
	}

}
