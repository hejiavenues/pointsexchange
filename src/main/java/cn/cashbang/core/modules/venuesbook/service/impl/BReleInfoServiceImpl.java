package cn.cashbang.core.modules.venuesbook.service.impl;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.cashbang.core.common.entity.Page;
import cn.cashbang.core.common.entity.Query;
import cn.cashbang.core.common.entity.Result;
import cn.cashbang.core.common.utils.CommonUtils;
import cn.cashbang.core.modules.venuesbook.entity.BReleInfoEntity;
import cn.cashbang.core.modules.venuesbook.manager.BReleInfoManager;
import cn.cashbang.core.modules.venuesbook.service.BReleInfoService;

/**
 * 企业上下游关系信息表
 *
 * @author daibangzhu
 * @email xxx@daibangzhu.cn
 * @url www.daibangzhu.cn
 * @date 2021年6月18日 下午9:56:11
 */
@Service("bReleInfoService")
public class BReleInfoServiceImpl implements BReleInfoService {

	@Autowired
	private BReleInfoManager bReleInfoManager;

	@Override
	public Page<BReleInfoEntity> listBReleInfo(Map<String, Object> params) {
		Query query = new Query(params);
		Page<BReleInfoEntity> page = new Page<>(query);
		bReleInfoManager.listBReleInfo(page, query);
		return page;
	}

	@Override
	public Result saveBReleInfo(BReleInfoEntity role) {
		int count = bReleInfoManager.saveBReleInfo(role);
		return CommonUtils.msg(count);
	}

	@Override
	public Result getBReleInfoById(String id) {
		BReleInfoEntity bReleInfo = bReleInfoManager.getBReleInfoById(id);
		return CommonUtils.msg(bReleInfo);
	}

	@Override
	public Result updateBReleInfo(BReleInfoEntity bReleInfo) {
		bReleInfo.setUpdateTime(new Date());
		int count = bReleInfoManager.updateBReleInfo(bReleInfo);
		return CommonUtils.msg(count);
	}

	@Override
	public Result batchRemove(Long[] id) {
		int count = bReleInfoManager.batchRemove(id);
		return CommonUtils.msg(id, count);
	}

}
