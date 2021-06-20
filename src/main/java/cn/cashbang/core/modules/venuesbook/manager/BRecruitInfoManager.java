package cn.cashbang.core.modules.venuesbook.manager;

import java.util.List;

import cn.cashbang.core.common.entity.Page;
import cn.cashbang.core.common.entity.Query;
import cn.cashbang.core.modules.venuesbook.entity.BRecruitInfoEntity;

/**
 * 招聘信息表
 *
 * @author daibangzhu
 * @email xxx@daibangzhu.cn
 * @url www.daibangzhu.cn
 * @date 2021年5月09日 下午2:54:48
 */
public interface BRecruitInfoManager {

	List<BRecruitInfoEntity> listBRecruitInfo(Page<BRecruitInfoEntity> page, Query search);
	
	int saveBRecruitInfo(BRecruitInfoEntity bRecruitInfo);
	
	BRecruitInfoEntity getBRecruitInfoById(String id);
	
	int updateBRecruitInfo(BRecruitInfoEntity bRecruitInfo);
	
	int batchRemove(String[] id);
	
}
