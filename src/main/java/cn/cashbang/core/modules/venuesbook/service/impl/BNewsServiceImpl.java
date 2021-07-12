package cn.cashbang.core.modules.venuesbook.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.cashbang.core.common.entity.Page;
import cn.cashbang.core.common.entity.Query;
import cn.cashbang.core.common.entity.Result;
import cn.cashbang.core.common.utils.CommonUtils;
import cn.cashbang.core.modules.venuesbook.entity.BNewsEntity;
import cn.cashbang.core.modules.venuesbook.manager.BNewsManager;
import cn.cashbang.core.modules.venuesbook.service.BNewsService;

/**
 * 文章列表信息
 *
 * @author daibangzhu
 * @email xxx@daibangzhu.cn
 * @url www.daibangzhu.cn
 * @date 2021年7月12日 下午7:56:51
 */
@Service("bNewsService")
public class BNewsServiceImpl implements BNewsService {

	@Autowired
	private BNewsManager bNewsManager;

	@Override
	public Page<BNewsEntity> listBNews(Map<String, Object> params) {
		Query query = new Query(params);
		Page<BNewsEntity> page = new Page<>(query);
		bNewsManager.listBNews(page, query);
		return page;
	}

	@Override
	public Result saveBNews(BNewsEntity role) {
		int count = bNewsManager.saveBNews(role);
		return CommonUtils.msg(count);
	}

	@Override
	public Result getBNewsById(Long id) {
		BNewsEntity bNews = bNewsManager.getBNewsById(id);
		return CommonUtils.msg(bNews);
	}

	@Override
	public Result updateBNews(BNewsEntity bNews) {
		int count = bNewsManager.updateBNews(bNews);
		return CommonUtils.msg(count);
	}

	@Override
	public Result batchRemove(Long[] id) {
		int count = bNewsManager.batchRemove(id);
		return CommonUtils.msg(id, count);
	}

}
