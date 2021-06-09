package cn.cashbang.core.modules.venuesbook.service.impl;

import java.util.Map;

import cn.cashbang.core.common.utils.StringUtils;
import cn.cashbang.core.common.utils.WebUtils;
import cn.cashbang.core.modules.venuesbook.entity.BAccessTokenEntity;
import cn.cashbang.core.modules.venuesbook.entity.BUserEntity;
import cn.cashbang.core.modules.venuesbook.manager.BAccessTokenManager;
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


    @Autowired
    private BAccessTokenManager bAccessTokenManager;

	@Override
	public Page<BActivityReplyEntity> listBActivityReply(Map<String, Object> params) {
		Query query = new Query(params);
		Page<BActivityReplyEntity> page = new Page<>(query);
		bActivityReplyManager.listBActivityReply(page, query);
		return page;
	}

	@Override
	public Result saveBActivityReply(BActivityReplyEntity role) {

        int count = 0;
        BAccessTokenEntity token = bAccessTokenManager.getBAccessTokenById(1L);
        String content = role.getContent();
        String code = WebUtils.msgCheck(token.getAccessToken(),content);
        System.out.println("content"+content);
        if("40001".equals(code)||"42001".equals(code)){
            String tokenString = WebUtils.getAccessToken();
            if(StringUtils.isNotBlank(tokenString)){

                BAccessTokenEntity bAccessToken = new BAccessTokenEntity();
                bAccessToken.setId(1);
                bAccessToken.setAccessToken(tokenString);
                bAccessTokenManager.updateBAccessToken(bAccessToken);
            }
            code = WebUtils.msgCheck(tokenString,content);
        }
        if("0".equals(code)){

            count = bActivityReplyManager.saveBActivityReply(role);
        }
        else {
            return Result.error("上传的信息中含有敏感内容，请修改后再上传。");
        }

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
