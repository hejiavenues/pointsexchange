package cn.cashbang.core.modules.venuesbook.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.cashbang.core.common.entity.Page;
import cn.cashbang.core.common.entity.Query;
import cn.cashbang.core.modules.venuesbook.dao.BGoodsInfoMapper;
import cn.cashbang.core.modules.venuesbook.entity.BGoodsInfoEntity;
import cn.cashbang.core.modules.venuesbook.manager.BGoodsInfoManager;

/**
 * 
 *
 * @author daibangzhu
 * @email xxx@daibangzhu.cn
 * @url www.daibangzhu.cn
 * @date 2021年3月04日 下午1:11:01
 */
@Component("bGoodsInfoManager")
public class BGoodsInfoManagerImpl implements BGoodsInfoManager {

	@Autowired
	private BGoodsInfoMapper bGoodsInfoMapper;
	

	@Override
	public List<BGoodsInfoEntity> listBGoodsInfo(Page<BGoodsInfoEntity> page, Query search) {
		return bGoodsInfoMapper.listForPage(page, search);
	}

	@Override
	public int saveBGoodsInfo(BGoodsInfoEntity bGoodsInfo) {
		return bGoodsInfoMapper.save(bGoodsInfo);
	}

	@Override
	public BGoodsInfoEntity getBGoodsInfoById(String id) {
		BGoodsInfoEntity bGoodsInfo = bGoodsInfoMapper.getObjectById(id);
		return bGoodsInfo;
	}

	@Override
	public BGoodsInfoEntity getBGoogsInfoByName(String goodsName) {
		BGoodsInfoEntity bGoodsInfo = bGoodsInfoMapper.getObjectByName(goodsName);
		return bGoodsInfo;
	}
	
	@Override
	public int updateBGoodsInfo(BGoodsInfoEntity bGoodsInfo) {
		return bGoodsInfoMapper.update(bGoodsInfo);
	}

	@Override
	public int batchRemove(String[] id) {
		int count = bGoodsInfoMapper.batchRemove(id);
		return count;
	}
	
}
