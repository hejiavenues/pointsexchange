package cn.cashbang.core.modules.venuesbook.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.cashbang.core.common.entity.Page;
import cn.cashbang.core.common.entity.Query;
import cn.cashbang.core.common.entity.Result;
import cn.cashbang.core.common.utils.CommonUtils;
import cn.cashbang.core.modules.venuesbook.entity.BVenueInfoOutEntity;
import cn.cashbang.core.modules.venuesbook.manager.BVenueInfoOutManager;
import cn.cashbang.core.modules.venuesbook.service.BVenueInfoOutService;

/**
 * 外部场馆信息表
 *
 * @author daibangzhu
 * @email xxx@daibangzhu.cn
 * @url www.daibangzhu.cn
 * @date 2021年5月09日 下午3:01:01
 */
@Service("bVenueInfoOutService")
public class BVenueInfoOutServiceImpl implements BVenueInfoOutService {

	@Autowired
	private BVenueInfoOutManager bVenueInfoOutManager;

	@Override
	public Page<BVenueInfoOutEntity> listBVenueInfoOut(Map<String, Object> params) {
		Query query = new Query(params);
		Page<BVenueInfoOutEntity> page = new Page<>(query);
		bVenueInfoOutManager.listBVenueInfoOut(page, query);
		return page;
	}

	@Override
	public Result saveBVenueInfoOut(BVenueInfoOutEntity role) {
		int count = bVenueInfoOutManager.saveBVenueInfoOut(role);
		return CommonUtils.msg(count);
	}

	@Override
	public Result getBVenueInfoOutById(Long id) {
		BVenueInfoOutEntity bVenueInfoOut = bVenueInfoOutManager.getBVenueInfoOutById(id);
		return CommonUtils.msg(bVenueInfoOut);
	}

	@Override
	public Result updateBVenueInfoOut(BVenueInfoOutEntity bVenueInfoOut) {
		int count = bVenueInfoOutManager.updateBVenueInfoOut(bVenueInfoOut);
		return CommonUtils.msg(count);
	}

	@Override
	public Result batchRemove(String[] id) {
		int count = bVenueInfoOutManager.batchRemove(id);
		return CommonUtils.msg(id, count);
	}

}
