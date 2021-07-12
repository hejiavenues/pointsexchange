package cn.cashbang.core.modules.venuesbook.service;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import cn.cashbang.core.common.entity.Page;
import cn.cashbang.core.common.entity.Result;
import cn.cashbang.core.modules.venuesbook.entity.BCoopCompanyEntity;
import cn.cashbang.core.modules.venuesbook.entity.BCoopCompanyEntityDto;

/**
 * 合作企业列表信息
 *
 * @author daibangzhu
 * @email xxx@daibangzhu.cn
 * @url www.daibangzhu.cn
 * @date 2021年7月12日 下午7:57:27
 */
public interface BCoopCompanyService {

	Page<BCoopCompanyEntity> listBCoopCompany(Map<String, Object> params);
	
	Result saveBCoopCompany(MultipartFile imgFile,BCoopCompanyEntity bCoopCompany);
	
	Result getBCoopCompanyById(String id);
	
	Result updateBCoopCompany(MultipartFile imgFile,BCoopCompanyEntityDto bCoopCompany);
	
	Result batchRemove(String[] id);
	
}
