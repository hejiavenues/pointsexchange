package cn.cashbang.core.modules.venuesbook.manager;

import java.util.List;

import cn.cashbang.core.common.entity.Page;
import cn.cashbang.core.common.entity.Query;
import cn.cashbang.core.modules.venuesbook.entity.BNewsEntity;

/**
 * 文章列表信息
 *
 * @author daibangzhu
 * @email xxx@daibangzhu.cn
 * @url www.daibangzhu.cn
 * @date 2021年7月12日 下午7:56:51
 */
public interface BNewsManager {

	List<BNewsEntity> listBNews(Page<BNewsEntity> page, Query search);
	
	int saveBNews(BNewsEntity bNews);
	
	BNewsEntity getBNewsById(Long id);
	
	int updateBNews(BNewsEntity bNews);
	
	int batchRemove(Long[] id);
	
}
