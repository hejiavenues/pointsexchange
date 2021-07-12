package cn.cashbang.core.modules.venuesbook.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.cashbang.core.common.entity.Page;
import cn.cashbang.core.common.entity.Query;
import cn.cashbang.core.modules.venuesbook.dao.BCoopCompanyMapper;
import cn.cashbang.core.modules.venuesbook.entity.BCoopCompanyEntity;
import cn.cashbang.core.modules.venuesbook.manager.BCoopCompanyManager;

/**
 * 合作企业列表信息
 *
 * @author daibangzhu
 * @email xxx@daibangzhu.cn
 * @url www.daibangzhu.cn
 * @date 2021年7月12日 下午7:57:27
 */
@Component("bCoopCompanyManager")
public class BCoopCompanyManagerImpl implements BCoopCompanyManager {

	@Autowired
	private BCoopCompanyMapper bCoopCompanyMapper;
	

	@Override
	public List<BCoopCompanyEntity> listBCoopCompany(Page<BCoopCompanyEntity> page, Query search) {
		return bCoopCompanyMapper.listForPage(page, search);
	}

	@Override
	public int saveBCoopCompany(BCoopCompanyEntity bCoopCompany) {
		return bCoopCompanyMapper.save(bCoopCompany);
	}

	@Override
	public BCoopCompanyEntity getBCoopCompanyById(String id) {
		BCoopCompanyEntity bCoopCompany = bCoopCompanyMapper.getObjectById(id);
		return bCoopCompany;
	}

	@Override
	public int updateBCoopCompany(BCoopCompanyEntity bCoopCompany) {
		return bCoopCompanyMapper.update(bCoopCompany);
	}

	@Override
	public int batchRemove(String[] id) {
		int count = bCoopCompanyMapper.batchRemove(id);
		return count;
	}
	
}
