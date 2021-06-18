package cn.cashbang.core.modules.venuesbook.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.cashbang.core.common.entity.Page;
import cn.cashbang.core.common.entity.Query;
import cn.cashbang.core.modules.venuesbook.dao.BReleInfoMapper;
import cn.cashbang.core.modules.venuesbook.entity.BReleInfoEntity;
import cn.cashbang.core.modules.venuesbook.manager.BReleInfoManager;

/**
 * 企业上下游关系信息表
 *
 * @author daibangzhu
 * @email xxx@daibangzhu.cn
 * @url www.daibangzhu.cn
 * @date 2021年6月18日 下午9:56:11
 */
@Component("bReleInfoManager")
public class BReleInfoManagerImpl implements BReleInfoManager {

	@Autowired
	private BReleInfoMapper bReleInfoMapper;
	

	@Override
	public List<BReleInfoEntity> listBReleInfo(Page<BReleInfoEntity> page, Query search) {
		return bReleInfoMapper.listForPage(page, search);
	}

	@Override
	public int saveBReleInfo(BReleInfoEntity bReleInfo) {
		return bReleInfoMapper.save(bReleInfo);
	}

	@Override
	public BReleInfoEntity getBReleInfoById(String id) {
		BReleInfoEntity bReleInfo = bReleInfoMapper.getObjectById(id);
		return bReleInfo;
	}

	@Override
	public int updateBReleInfo(BReleInfoEntity bReleInfo) {
		return bReleInfoMapper.update(bReleInfo);
	}

	@Override
	public int batchRemove(Long[] id) {
		int count = bReleInfoMapper.batchRemove(id);
		return count;
	}
	
}
