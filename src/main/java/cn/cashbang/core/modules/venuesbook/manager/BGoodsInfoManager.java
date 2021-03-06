package cn.cashbang.core.modules.venuesbook.manager;

import java.util.List;

import cn.cashbang.core.common.entity.Page;
import cn.cashbang.core.common.entity.Query;
import cn.cashbang.core.modules.venuesbook.entity.BGoodsInfoEntity;

/**
 * 
 *
 * @author daibangzhu
 * @email xxx@daibangzhu.cn
 * @url www.daibangzhu.cn
 * @date 2021年3月04日 下午1:11:01
 */
public interface BGoodsInfoManager {

	List<BGoodsInfoEntity> listBGoodsInfo(Page<BGoodsInfoEntity> page, Query search);
	
	int saveBGoodsInfo(BGoodsInfoEntity bGoodsInfo);
	
	BGoodsInfoEntity getBGoodsInfoById(String id);
	
	int updateBGoodsInfo(BGoodsInfoEntity bGoodsInfo);
	
	int batchRemove(String[] id);

	BGoodsInfoEntity getBGoogsInfoByName(String goodsName);
	
}
