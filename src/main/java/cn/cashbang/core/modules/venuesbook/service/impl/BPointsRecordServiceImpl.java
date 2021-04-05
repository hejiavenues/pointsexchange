package cn.cashbang.core.modules.venuesbook.service.impl;

import java.util.Date;
import java.util.Map;

import cn.cashbang.core.modules.venuesbook.entity.BUserEntity;
import cn.cashbang.core.modules.venuesbook.manager.BUserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.cashbang.core.common.entity.Page;
import cn.cashbang.core.common.entity.Query;
import cn.cashbang.core.common.entity.Result;
import cn.cashbang.core.common.utils.CommonUtils;
import cn.cashbang.core.common.utils.StringUtils;
import cn.cashbang.core.modules.venuesbook.entity.BPointsRecordEntity;
import cn.cashbang.core.modules.venuesbook.manager.BPointsRecordManager;
import cn.cashbang.core.modules.venuesbook.service.BPointsRecordService;

/**
 * 积分增减记录表
 *
 * @author daibangzhu
 * @email xxx@daibangzhu.cn
 * @url www.daibangzhu.cn
 * @date 2021年3月05日 下午2:01:23
 */
@Service("bPointsRecordService")
public class BPointsRecordServiceImpl implements BPointsRecordService {

	@Autowired
	private BPointsRecordManager bPointsRecordManager;

    @Autowired
    private BUserManager bUserManager;

	@Override
	public Page<BPointsRecordEntity> listBPointsRecord(Map<String, Object> params) {
		Query query = new Query(params);
		Page<BPointsRecordEntity> page = new Page<>(query);
		bPointsRecordManager.listBPointsRecord(page, query);
		return page;
	}

	@Override
	public Result saveBPointsRecord(BPointsRecordEntity role) {
		role.setPid(CommonUtils.createUUID());
		if(role.getAccessType().intValue() == 4) {
			if(StringUtils.isEmpty(role.getUid())) {
				return Result.error("发放失败，用户信息为空");
			}
		}
		role.setCreateTime(new Date());
		role.setUpdateTime(new Date());
		int count = bPointsRecordManager.saveBPointsRecord(role);

		// 同时更新用户的积分
        BUserEntity user = bUserManager.getBUserById(role.getUid());
        // 更新用户的分数
        user.setPoints(user.getPoints().subtract(role.getPoints()));
        System.out.println("这次奖励的分数是"+ role.getPoints());

        bUserManager.updateBUser(user);
		return CommonUtils.msg(count);
	}

	@Override
	public Result getBPointsRecordById(Long id) {
		BPointsRecordEntity bPointsRecord = bPointsRecordManager.getBPointsRecordById(id);
		return CommonUtils.msg(bPointsRecord);
	}

	@Override
	public Result updateBPointsRecord(BPointsRecordEntity bPointsRecord) {
		int count = bPointsRecordManager.updateBPointsRecord(bPointsRecord);
		return CommonUtils.msg(count);
	}

	@Override
	public Result batchRemove(Long[] id) {
		int count = bPointsRecordManager.batchRemove(id);
		return CommonUtils.msg(id, count);
	}

}
