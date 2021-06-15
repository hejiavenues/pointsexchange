package cn.cashbang.core.modules.venuesbook.manager;

import java.util.List;

import cn.cashbang.core.common.entity.Page;
import cn.cashbang.core.common.entity.Query;
import cn.cashbang.core.modules.venuesbook.entity.BUserTutorEntity;

/**
 * 志愿者导师信息表
 *
 * @author daibangzhu
 * @email xxx@daibangzhu.cn
 * @url www.daibangzhu.cn
 * @date 2021年6月15日 下午7:23:45
 */
public interface BUserTutorManager {

	List<BUserTutorEntity> listBUserTutor(Page<BUserTutorEntity> page, Query search);
	
	int saveBUserTutor(BUserTutorEntity bUserTutor);
	
	BUserTutorEntity getBUserTutorById(String id);
	
	int updateBUserTutor(BUserTutorEntity bUserTutor);
	
	int batchRemove(Long[] id);

	int passApply(String[] id);
	
	int refuseApply(String[] id);
	
}
