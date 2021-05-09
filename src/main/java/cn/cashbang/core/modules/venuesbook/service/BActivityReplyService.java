package cn.cashbang.core.modules.venuesbook.service;

import java.util.Map;

import cn.cashbang.core.common.entity.Page;
import cn.cashbang.core.common.entity.Result;
import cn.cashbang.core.modules.venuesbook.entity.BActivityReplyEntity;

/**
 * 活动评论表
 *
 * @author daibangzhu
 * @email xxx@daibangzhu.cn
 * @url www.daibangzhu.cn
 * @date 2021年5月09日 PM1:27:16
 */
public interface BActivityReplyService {

	Page<BActivityReplyEntity> listBActivityReply(Map<String, Object> params);
	
	Result saveBActivityReply(BActivityReplyEntity bActivityReply);
	
	Result getBActivityReplyById(Long id);
	
	Result updateBActivityReply(BActivityReplyEntity bActivityReply);
	
	Result batchRemove(Long[] id);
	
}
