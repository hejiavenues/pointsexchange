package cn.cashbang.core.modules.venuesbook.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.cashbang.core.common.entity.Page;
import cn.cashbang.core.common.entity.Query;
import cn.cashbang.core.common.entity.Result;
import cn.cashbang.core.common.utils.CommonUtils;
import cn.cashbang.core.modules.venuesbook.entity.BActivityReplyEntity;
import cn.cashbang.core.modules.venuesbook.manager.BActivityReplyManager;
import cn.cashbang.core.modules.venuesbook.service.BActivityReplyService;

/**
 * 活动评论表
 *
 * @author daibangzhu
 * @email xxx@daibangzhu.cn
 * @url www.daibangzhu.cn
 * @date 2021年5月09日 PM1:27:16
 */
@Service("bActivityReplyService")
public class BActivityReplyServiceImpl implements BActivityReplyService {

	@Autowired
	private BActivityReplyManager bActivityReplyManager;

	@Override
	public Page<BActivityReplyEntity> listBActivityReply(Map<String, Object> params) {
		Query query = new Query(params);
		Page<BActivityReplyEntity> page = new Page<>(query);
		bActivityReplyManager.listBActivityReply(page, query);
		return page;
	}

	@Override
	public Result saveBActivityReply(BActivityReplyEntity role) {
		int count = bActivityReplyManager.saveBActivityReply(role);
		return CommonUtils.msg(count);
	}

	@Override
	public Result getBActivityReplyById(Long id) {
		BActivityReplyEntity bActivityReply = bActivityReplyManager.getBActivityReplyById(id);
		return CommonUtils.msg(bActivityReply);
	}

	@Override
	public Result updateBActivityReply(BActivityReplyEntity bActivityReply) {
		int count = bActivityReplyManager.updateBActivityReply(bActivityReply);
		return CommonUtils.msg(count);
	}

	@Override
	public Result batchRemove(Long[] id) {
		int count = bActivityReplyManager.batchRemove(id);
		return CommonUtils.msg(id, count);
	}

}
