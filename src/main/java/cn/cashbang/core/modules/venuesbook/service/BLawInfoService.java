package cn.cashbang.core.modules.venuesbook.service;

import java.util.Map;

import cn.cashbang.core.common.entity.Page;
import cn.cashbang.core.common.entity.Result;
import cn.cashbang.core.modules.venuesbook.entity.BLawInfoEntity;

/**
 * 法律体检表
 *
 * @author daibangzhu
 * @email xxx@daibangzhu.cn
 * @url www.daibangzhu.cn
 * @date 2021年5月09日 下午3:00:03
 */
public interface BLawInfoService {

	Page<BLawInfoEntity> listBLawInfo(Map<String, Object> params);
	
	Result saveBLawInfo(BLawInfoEntity bLawInfo);
	
	Result getBLawInfoById(String id);
	
	Result updateBLawInfo(BLawInfoEntity bLawInfo);
	
	Result batchRemove(String[] id);
	
}
