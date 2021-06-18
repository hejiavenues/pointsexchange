package cn.cashbang.core.modules.venuesbook.manager;

import java.util.List;

import cn.cashbang.core.common.entity.Page;
import cn.cashbang.core.common.entity.Query;
import cn.cashbang.core.modules.venuesbook.entity.BReleInfoEntity;

/**
 * 企业上下游关系信息表
 *
 * @author daibangzhu
 * @email xxx@daibangzhu.cn
 * @url www.daibangzhu.cn
 * @date 2021年6月18日 下午9:56:11
 */
public interface BReleInfoManager {

	List<BReleInfoEntity> listBReleInfo(Page<BReleInfoEntity> page, Query search);
	
	int saveBReleInfo(BReleInfoEntity bReleInfo);
	
	BReleInfoEntity getBReleInfoById(String id);
	
	int updateBReleInfo(BReleInfoEntity bReleInfo);
	
	int batchRemove(Long[] id);
	
}
