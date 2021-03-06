package cn.cashbang.core.modules.venuesbook.service;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import cn.cashbang.core.common.entity.Page;
import cn.cashbang.core.common.entity.Result;
import cn.cashbang.core.modules.venuesbook.entity.BGoodsInfoEntity;

/**
 * 
 *
 * @author daibangzhu
 * @email xxx@daibangzhu.cn
 * @url www.daibangzhu.cn
 * @date 2021年3月04日 下午1:11:01
 */
public interface BGoodsInfoService {

	Page<BGoodsInfoEntity> listBGoodsInfo(Map<String, Object> params);
	
	Result saveBGoodsInfo(MultipartFile file,BGoodsInfoEntity bGoodsInfo);
	
	Result getBGoodsInfoById(String id);
	
	Result updateBGoodsInfo(MultipartFile imgFile,BGoodsInfoEntity bGoodsInfo);
	
	Result batchRemove(String[] id);
	
}
