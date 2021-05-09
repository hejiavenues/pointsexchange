package cn.cashbang.core.modules.venuesbook.manager;

import java.util.List;

import cn.cashbang.core.common.entity.Page;
import cn.cashbang.core.common.entity.Query;
import cn.cashbang.core.modules.venuesbook.entity.BVenueInfoOutEntity;

/**
 * 外部场馆信息表
 *
 * @author daibangzhu
 * @email xxx@daibangzhu.cn
 * @url www.daibangzhu.cn
 * @date 2021年5月09日 下午3:01:01
 */
public interface BVenueInfoOutManager {

	List<BVenueInfoOutEntity> listBVenueInfoOut(Page<BVenueInfoOutEntity> page, Query search);
	
	int saveBVenueInfoOut(BVenueInfoOutEntity bVenueInfoOut);
	
	BVenueInfoOutEntity getBVenueInfoOutById(Long id);
	
	int updateBVenueInfoOut(BVenueInfoOutEntity bVenueInfoOut);
	
	int batchRemove(String[] id);
	
}
