package cn.cashbang.core.modules.venuesbook.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.cashbang.core.common.entity.Page;
import cn.cashbang.core.common.entity.Query;
import cn.cashbang.core.modules.venuesbook.dao.BActivityReplyMapper;
import cn.cashbang.core.modules.venuesbook.entity.BActivityReplyEntity;
import cn.cashbang.core.modules.venuesbook.manager.BActivityReplyManager;

/**
 * 活动评论表
 *
 * @author daibangzhu
 * @email xxx@daibangzhu.cn
 * @url www.daibangzhu.cn
 * @date 2021年5月09日 PM1:27:16
 */
@Component("bActivityReplyManager")
public class BActivityReplyManagerImpl implements BActivityReplyManager {

	@Autowired
	private BActivityReplyMapper bActivityReplyMapper;
	

	@Override
	public List<BActivityReplyEntity> listBActivityReply(Page<BActivityReplyEntity> page, Query search) {
		return bActivityReplyMapper.listForPage(page, search);
	}

	@Override
	public int saveBActivityReply(BActivityReplyEntity bActivityReply) {
		return bActivityReplyMapper.save(bActivityReply);
	}

	@Override
	public BActivityReplyEntity getBActivityReplyById(Long id) {
		BActivityReplyEntity bActivityReply = bActivityReplyMapper.getObjectById(id);
		return bActivityReply;
	}

	@Override
	public int updateBActivityReply(BActivityReplyEntity bActivityReply) {
		return bActivityReplyMapper.update(bActivityReply);
	}

	@Override
	public int batchRemove(Long[] id) {
		int count = bActivityReplyMapper.batchRemove(id);
		return count;
	}
	
}
