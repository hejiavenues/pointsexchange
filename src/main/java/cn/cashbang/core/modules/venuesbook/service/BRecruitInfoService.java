package cn.cashbang.core.modules.venuesbook.service;

import java.util.Map;

import cn.cashbang.core.common.entity.Page;
import cn.cashbang.core.common.entity.Result;
import cn.cashbang.core.modules.venuesbook.entity.BRecruitInfoEntity;

/**
 * 招聘信息表
 *
 * @author daibangzhu
 * @email xxx@daibangzhu.cn
 * @url www.daibangzhu.cn
 * @date 2021年5月09日 下午2:54:48
 */
public interface BRecruitInfoService {

	Page<BRecruitInfoEntity> listBRecruitInfo(Map<String, Object> params);
	
	Result saveBRecruitInfo(BRecruitInfoEntity bRecruitInfo);
	
	Result getBRecruitInfoById(Long id);
	
	Result updateBRecruitInfo(BRecruitInfoEntity bRecruitInfo);
	
	Result batchRemove(String[] id);
	
}
