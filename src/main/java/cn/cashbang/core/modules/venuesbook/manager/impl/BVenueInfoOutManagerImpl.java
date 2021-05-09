package cn.cashbang.core.modules.venuesbook.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.cashbang.core.common.entity.Page;
import cn.cashbang.core.common.entity.Query;
import cn.cashbang.core.modules.venuesbook.dao.BVenueInfoOutMapper;
import cn.cashbang.core.modules.venuesbook.entity.BVenueInfoOutEntity;
import cn.cashbang.core.modules.venuesbook.manager.BVenueInfoOutManager;

/**
 * 外部场馆信息表
 *
 * @author daibangzhu
 * @email xxx@daibangzhu.cn
 * @url www.daibangzhu.cn
 * @date 2021年5月09日 下午3:01:01
 */
@Component("bVenueInfoOutManager")
public class BVenueInfoOutManagerImpl implements BVenueInfoOutManager {

	@Autowired
	private BVenueInfoOutMapper bVenueInfoOutMapper;
	

	@Override
	public List<BVenueInfoOutEntity> listBVenueInfoOut(Page<BVenueInfoOutEntity> page, Query search) {
		List<BVenueInfoOutEntity> lists = bVenueInfoOutMapper.listForPage(page, search);
		for(BVenueInfoOutEntity entity:lists) {
			if(entity.getStatus().intValue() == 1) {
				entity.setStatusStr("已隐藏");
			}else if(entity.getStatus().intValue() == 0) {
				entity.setStatusStr("已启用");
			}else {
				entity.setStatusStr("未知");
			}
		}
		return lists;
	}

	@Override
	public int saveBVenueInfoOut(BVenueInfoOutEntity bVenueInfoOut) {
		return bVenueInfoOutMapper.save(bVenueInfoOut);
	}

	@Override
	public BVenueInfoOutEntity getBVenueInfoOutById(Long id) {
		BVenueInfoOutEntity bVenueInfoOut = bVenueInfoOutMapper.getObjectById(id);
		return bVenueInfoOut;
	}

	@Override
	public int updateBVenueInfoOut(BVenueInfoOutEntity bVenueInfoOut) {
		return bVenueInfoOutMapper.update(bVenueInfoOut);
	}

	@Override
	public int batchRemove(String[] id) {
		int count = bVenueInfoOutMapper.batchRemove(id);
		return count;
	}
	
}
