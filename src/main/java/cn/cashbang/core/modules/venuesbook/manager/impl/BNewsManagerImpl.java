package cn.cashbang.core.modules.venuesbook.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.cashbang.core.common.entity.Page;
import cn.cashbang.core.common.entity.Query;
import cn.cashbang.core.modules.venuesbook.dao.BNewsMapper;
import cn.cashbang.core.modules.venuesbook.entity.BNewsEntity;
import cn.cashbang.core.modules.venuesbook.manager.BNewsManager;

/**
 * 文章列表信息
 *
 * @author daibangzhu
 * @email xxx@daibangzhu.cn
 * @url www.daibangzhu.cn
 * @date 2021年7月12日 下午7:56:51
 */
@Component("bNewsManager")
public class BNewsManagerImpl implements BNewsManager {

	@Autowired
	private BNewsMapper bNewsMapper;
	

	@Override
	public List<BNewsEntity> listBNews(Page<BNewsEntity> page, Query search) {
		return bNewsMapper.listForPage(page, search);
	}

	@Override
	public int saveBNews(BNewsEntity bNews) {
		return bNewsMapper.save(bNews);
	}

	@Override
	public BNewsEntity getBNewsById(String id) {
		BNewsEntity bNews = bNewsMapper.getObjectById(id);
		return bNews;
	}

	@Override
	public int updateBNews(BNewsEntity bNews) {
		return bNewsMapper.update(bNews);
	}

	@Override
	public int batchRemove(String[] id) {
		int count = bNewsMapper.batchRemove(id);
		return count;
	}
	
}
