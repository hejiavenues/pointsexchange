package cn.cashbang.core.modules.venuesbook.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.cashbang.core.common.entity.Page;
import cn.cashbang.core.common.entity.Query;
import cn.cashbang.core.common.entity.Result;
import cn.cashbang.core.common.utils.CommonUtils;
import cn.cashbang.core.modules.venuesbook.entity.BRecruitInfoEntity;
import cn.cashbang.core.modules.venuesbook.manager.BRecruitInfoManager;
import cn.cashbang.core.modules.venuesbook.service.BRecruitInfoService;

/**
 * 招聘信息表
 *
 * @author daibangzhu
 * @email xxx@daibangzhu.cn
 * @url www.daibangzhu.cn
 * @date 2021年5月09日 下午2:54:48
 */
@Service("bRecruitInfoService")
public class BRecruitInfoServiceImpl implements BRecruitInfoService {

	@Autowired
	private BRecruitInfoManager bRecruitInfoManager;

	@Override
	public Page<BRecruitInfoEntity> listBRecruitInfo(Map<String, Object> params) {
		Query query = new Query(params);
		Page<BRecruitInfoEntity> page = new Page<>(query);
		bRecruitInfoManager.listBRecruitInfo(page, query);
		return page;
	}

	@Override
	public Result saveBRecruitInfo(BRecruitInfoEntity role) {
		int count = bRecruitInfoManager.saveBRecruitInfo(role);
		return CommonUtils.msg(count);
	}

	@Override
	public Result getBRecruitInfoById(Long id) {
		BRecruitInfoEntity bRecruitInfo = bRecruitInfoManager.getBRecruitInfoById(id);
		return CommonUtils.msg(bRecruitInfo);
	}

	@Override
	public Result updateBRecruitInfo(BRecruitInfoEntity bRecruitInfo) {
		int count = bRecruitInfoManager.updateBRecruitInfo(bRecruitInfo);
		return CommonUtils.msg(count);
	}

	@Override
	public Result batchRemove(String[] id) {
		int count = bRecruitInfoManager.batchRemove(id);
		return CommonUtils.msg(id, count);
	}

}
