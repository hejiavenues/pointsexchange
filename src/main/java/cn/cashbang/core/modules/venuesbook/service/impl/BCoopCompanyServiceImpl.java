package cn.cashbang.core.modules.venuesbook.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.cashbang.core.common.entity.Page;
import cn.cashbang.core.common.entity.Query;
import cn.cashbang.core.common.entity.Result;
import cn.cashbang.core.common.utils.CommonUtils;
import cn.cashbang.core.modules.venuesbook.entity.BCoopCompanyEntity;
import cn.cashbang.core.modules.venuesbook.manager.BCoopCompanyManager;
import cn.cashbang.core.modules.venuesbook.service.BCoopCompanyService;

/**
 * 合作企业列表信息
 *
 * @author daibangzhu
 * @email xxx@daibangzhu.cn
 * @url www.daibangzhu.cn
 * @date 2021年7月12日 下午7:57:27
 */
@Service("bCoopCompanyService")
public class BCoopCompanyServiceImpl implements BCoopCompanyService {

	@Autowired
	private BCoopCompanyManager bCoopCompanyManager;

	@Override
	public Page<BCoopCompanyEntity> listBCoopCompany(Map<String, Object> params) {
		Query query = new Query(params);
		Page<BCoopCompanyEntity> page = new Page<>(query);
		bCoopCompanyManager.listBCoopCompany(page, query);
		return page;
	}

	@Override
	public Result saveBCoopCompany(BCoopCompanyEntity role) {
		int count = bCoopCompanyManager.saveBCoopCompany(role);
		return CommonUtils.msg(count);
	}

	@Override
	public Result getBCoopCompanyById(Long id) {
		BCoopCompanyEntity bCoopCompany = bCoopCompanyManager.getBCoopCompanyById(id);
		return CommonUtils.msg(bCoopCompany);
	}

	@Override
	public Result updateBCoopCompany(BCoopCompanyEntity bCoopCompany) {
		int count = bCoopCompanyManager.updateBCoopCompany(bCoopCompany);
		return CommonUtils.msg(count);
	}

	@Override
	public Result batchRemove(Long[] id) {
		int count = bCoopCompanyManager.batchRemove(id);
		return CommonUtils.msg(id, count);
	}

}
