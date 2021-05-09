package cn.cashbang.core.modules.venuesbook.manager;

import java.util.List;

import cn.cashbang.core.common.entity.Page;
import cn.cashbang.core.common.entity.Query;
import cn.cashbang.core.modules.venuesbook.entity.BActivityReplyEntity;

/**
 * 活动评论表
 *
 * @author daibangzhu
 * @email xxx@daibangzhu.cn
 * @url www.daibangzhu.cn
 * @date 2021年5月09日 PM1:27:16
 */
public interface BActivityReplyManager {

	List<BActivityReplyEntity> listBActivityReply(Page<BActivityReplyEntity> page, Query search);
	
	int saveBActivityReply(BActivityReplyEntity bActivityReply);
	
	BActivityReplyEntity getBActivityReplyById(Long id);
	
	int updateBActivityReply(BActivityReplyEntity bActivityReply);
	
	int batchRemove(Long[] id);
	
}
