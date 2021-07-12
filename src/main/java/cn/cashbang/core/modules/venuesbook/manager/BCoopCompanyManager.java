package cn.cashbang.core.modules.venuesbook.manager;

import java.util.List;

import cn.cashbang.core.common.entity.Page;
import cn.cashbang.core.common.entity.Query;
import cn.cashbang.core.modules.venuesbook.entity.BCoopCompanyEntity;

/**
 * 合作企业列表信息
 *
 * @author daibangzhu
 * @email xxx@daibangzhu.cn
 * @url www.daibangzhu.cn
 * @date 2021年7月12日 下午7:57:27
 */
public interface BCoopCompanyManager {

	List<BCoopCompanyEntity> listBCoopCompany(Page<BCoopCompanyEntity> page, Query search);
	
	int saveBCoopCompany(BCoopCompanyEntity bCoopCompany);
	
	BCoopCompanyEntity getBCoopCompanyById(Long id);
	
	int updateBCoopCompany(BCoopCompanyEntity bCoopCompany);
	
	int batchRemove(Long[] id);
	
}
