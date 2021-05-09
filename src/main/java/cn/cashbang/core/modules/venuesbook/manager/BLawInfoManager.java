package cn.cashbang.core.modules.venuesbook.manager;

import java.util.List;

import cn.cashbang.core.common.entity.Page;
import cn.cashbang.core.common.entity.Query;
import cn.cashbang.core.modules.venuesbook.entity.BLawInfoEntity;

/**
 * 法律体检表
 *
 * @author daibangzhu
 * @email xxx@daibangzhu.cn
 * @url www.daibangzhu.cn
 * @date 2021年5月09日 下午3:00:03
 */
public interface BLawInfoManager {

	List<BLawInfoEntity> listBLawInfo(Page<BLawInfoEntity> page, Query search);
	
	int saveBLawInfo(BLawInfoEntity bLawInfo);
	
	BLawInfoEntity getBLawInfoById(String id);
	
	int updateBLawInfo(BLawInfoEntity bLawInfo);
	
	int batchRemove(String[] id);

	BLawInfoEntity getBLawInfoByName(String lawName);
	
}
