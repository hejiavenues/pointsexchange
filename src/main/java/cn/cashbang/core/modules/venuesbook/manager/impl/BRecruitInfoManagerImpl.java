package cn.cashbang.core.modules.venuesbook.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.cashbang.core.common.entity.Page;
import cn.cashbang.core.common.entity.Query;
import cn.cashbang.core.modules.venuesbook.dao.BRecruitInfoMapper;
import cn.cashbang.core.modules.venuesbook.entity.BRecruitInfoEntity;
import cn.cashbang.core.modules.venuesbook.manager.BRecruitInfoManager;

/**
 * 招聘信息表
 *
 * @author daibangzhu
 * @email xxx@daibangzhu.cn
 * @url www.daibangzhu.cn
 * @date 2021年5月09日 下午2:54:48
 */
@Component("bRecruitInfoManager")
public class BRecruitInfoManagerImpl implements BRecruitInfoManager {

	@Autowired
	private BRecruitInfoMapper bRecruitInfoMapper;
	

	@Override
	public List<BRecruitInfoEntity> listBRecruitInfo(Page<BRecruitInfoEntity> page, Query search) {
		return bRecruitInfoMapper.listForPage(page, search);
	}

	@Override
	public int saveBRecruitInfo(BRecruitInfoEntity bRecruitInfo) {
		return bRecruitInfoMapper.save(bRecruitInfo);
	}

	@Override
	public BRecruitInfoEntity getBRecruitInfoById(Long id) {
		BRecruitInfoEntity bRecruitInfo = bRecruitInfoMapper.getObjectById(id);
		return bRecruitInfo;
	}

	@Override
	public int updateBRecruitInfo(BRecruitInfoEntity bRecruitInfo) {
		return bRecruitInfoMapper.update(bRecruitInfo);
	}

	@Override
	public int batchRemove(String[] id) {
		int count = bRecruitInfoMapper.batchRemove(id);
		return count;
	}
	
}
