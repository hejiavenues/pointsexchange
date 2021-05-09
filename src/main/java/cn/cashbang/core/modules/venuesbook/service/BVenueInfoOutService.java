package cn.cashbang.core.modules.venuesbook.service;

import java.util.Map;

import cn.cashbang.core.common.entity.Page;
import cn.cashbang.core.common.entity.Result;
import cn.cashbang.core.modules.venuesbook.entity.BVenueInfoOutEntity;

/**
 * 外部场馆信息表
 *
 * @author daibangzhu
 * @email xxx@daibangzhu.cn
 * @url www.daibangzhu.cn
 * @date 2021年5月09日 下午3:01:01
 */
public interface BVenueInfoOutService {

	Page<BVenueInfoOutEntity> listBVenueInfoOut(Map<String, Object> params);
	
	Result saveBVenueInfoOut(BVenueInfoOutEntity bVenueInfoOut);
	
	Result getBVenueInfoOutById(Long id);
	
	Result updateBVenueInfoOut(BVenueInfoOutEntity bVenueInfoOut);
	
	Result batchRemove(String[] id);
	
}
