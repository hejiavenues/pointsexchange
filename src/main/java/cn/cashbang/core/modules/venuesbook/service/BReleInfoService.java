package cn.cashbang.core.modules.venuesbook.service;

import java.util.Map;

import cn.cashbang.core.common.entity.Page;
import cn.cashbang.core.common.entity.Result;
import cn.cashbang.core.modules.venuesbook.entity.BReleInfoEntity;

/**
 * 企业上下游关系信息表
 *
 * @author daibangzhu
 * @email xxx@daibangzhu.cn
 * @url www.daibangzhu.cn
 * @date 2021年6月18日 下午9:56:11
 */
public interface BReleInfoService {

	Page<BReleInfoEntity> listBReleInfo(Map<String, Object> params);
	
	Result saveBReleInfo(BReleInfoEntity bReleInfo);
	
	Result getBReleInfoById(String id);
	
	Result updateBReleInfo(BReleInfoEntity bReleInfo);
	
	Result batchRemove(Long[] id);
	
}
