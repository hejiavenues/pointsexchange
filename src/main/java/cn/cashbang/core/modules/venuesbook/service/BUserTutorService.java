package cn.cashbang.core.modules.venuesbook.service;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import cn.cashbang.core.common.entity.Page;
import cn.cashbang.core.common.entity.Result;
import cn.cashbang.core.modules.venuesbook.entity.BUserTutorEntity;

/**
 * 志愿者导师信息表
 *
 * @author daibangzhu
 * @email xxx@daibangzhu.cn
 * @url www.daibangzhu.cn
 * @date 2021年6月15日 下午7:23:45
 */
public interface BUserTutorService {

	Page<BUserTutorEntity> listBUserTutor(Map<String, Object> params);
	
	Result saveBUserTutor(BUserTutorEntity bUserTutor);
	
	Result getBUserTutorById(String id);
	
	Result updateBUserTutor(MultipartFile imgFile,BUserTutorEntity bUserTutor);
	
	Result batchRemove(Long[] id);

	Result passApply(String[] id);
	
	Result refuseApply(String[] id);
	
}
