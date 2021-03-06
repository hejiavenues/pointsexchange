package cn.cashbang.core.modules.venuesbook.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.cashbang.core.common.entity.Page;
import cn.cashbang.core.common.entity.Query;
import cn.cashbang.core.common.entity.Result;
import cn.cashbang.core.common.utils.CommonUtils;
import cn.cashbang.core.modules.venuesbook.entity.BPointsRecordEntity;
import cn.cashbang.core.modules.venuesbook.manager.BPointsRecordManager;
import cn.cashbang.core.modules.venuesbook.service.BPointsRecordService;

/**
 * 积分增减记录表
 *
 * @author daibangzhu
 * @email xxx@daibangzhu.cn
 * @url www.daibangzhu.cn
 * @date 2021年3月05日 下午2:01:23
 */
@Service("bPointsRecordService")
public class BPointsRecordServiceImpl implements BPointsRecordService {

	@Autowired
	private BPointsRecordManager bPointsRecordManager;

	@Override
	public Page<BPointsRecordEntity> listBPointsRecord(Map<String, Object> params) {
		Query query = new Query(params);
		Page<BPointsRecordEntity> page = new Page<>(query);
		bPointsRecordManager.listBPointsRecord(page, query);
		return page;
	}

	@Override
	public Result saveBPointsRecord(BPointsRecordEntity role) {
		int count = bPointsRecordManager.saveBPointsRecord(role);
		return CommonUtils.msg(count);
	}

	@Override
	public Result getBPointsRecordById(Long id) {
		BPointsRecordEntity bPointsRecord = bPointsRecordManager.getBPointsRecordById(id);
		return CommonUtils.msg(bPointsRecord);
	}

	@Override
	public Result updateBPointsRecord(BPointsRecordEntity bPointsRecord) {
		int count = bPointsRecordManager.updateBPointsRecord(bPointsRecord);
		return CommonUtils.msg(count);
	}

	@Override
	public Result batchRemove(Long[] id) {
		int count = bPointsRecordManager.batchRemove(id);
		return CommonUtils.msg(id, count);
	}

}