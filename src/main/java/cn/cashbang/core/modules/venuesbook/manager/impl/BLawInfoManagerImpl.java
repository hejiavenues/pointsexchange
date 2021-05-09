package cn.cashbang.core.modules.venuesbook.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.cashbang.core.common.entity.Page;
import cn.cashbang.core.common.entity.Query;
import cn.cashbang.core.modules.venuesbook.dao.BLawInfoMapper;
import cn.cashbang.core.modules.venuesbook.entity.BLawInfoEntity;
import cn.cashbang.core.modules.venuesbook.manager.BLawInfoManager;

/**
 * 法律体检表
 *
 * @author daibangzhu
 * @email xxx@daibangzhu.cn
 * @url www.daibangzhu.cn
 * @date 2021年5月09日 下午3:00:03
 */
@Component("bLawInfoManager")
public class BLawInfoManagerImpl implements BLawInfoManager {

	@Autowired
	private BLawInfoMapper bLawInfoMapper;
	

	@Override
	public List<BLawInfoEntity> listBLawInfo(Page<BLawInfoEntity> page, Query search) {
		return bLawInfoMapper.listForPage(page, search);
	}

	@Override
	public int saveBLawInfo(BLawInfoEntity bLawInfo) {
		return bLawInfoMapper.save(bLawInfo);
	}

	@Override
	public BLawInfoEntity getBLawInfoById(String id) {
		BLawInfoEntity bLawInfo = bLawInfoMapper.getObjectById(id);
		return bLawInfo;
	}
	@Override
	public BLawInfoEntity getBLawInfoByName(String id) {
		BLawInfoEntity bLawInfo = bLawInfoMapper.getBLawInfoByName(id);
		return bLawInfo;
	}

	@Override
	public int updateBLawInfo(BLawInfoEntity bLawInfo) {
		return bLawInfoMapper.update(bLawInfo);
	}

	@Override
	public int batchRemove(String[] id) {
		int count = bLawInfoMapper.batchRemove(id);
		return count;
	}
	
}
