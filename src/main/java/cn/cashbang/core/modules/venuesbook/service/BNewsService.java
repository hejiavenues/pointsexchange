package cn.cashbang.core.modules.venuesbook.service;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import cn.cashbang.core.common.entity.Page;
import cn.cashbang.core.common.entity.Result;
import cn.cashbang.core.modules.venuesbook.entity.BNewsEntity;
import cn.cashbang.core.modules.venuesbook.entity.BNewsEntityDto;

/**
 * 文章列表信息
 *
 * @author daibangzhu
 * @email xxx@daibangzhu.cn
 * @url www.daibangzhu.cn
 * @date 2021年7月12日 下午7:56:51
 */
public interface BNewsService {

	Page<BNewsEntity> listBNews(Map<String, Object> params);
	
	Result saveBNews(MultipartFile imgFile, BNewsEntity bNews);
	
	Result getBNewsById(String id);
	
	Result updateBNews(MultipartFile imgFile, BNewsEntityDto bNews);
	
	Result batchRemove(String[] id);
	
}
