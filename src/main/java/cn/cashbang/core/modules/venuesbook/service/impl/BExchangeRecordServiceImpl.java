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
import cn.cashbang.core.modules.venuesbook.entity.BExchangeRecordEntity;
import cn.cashbang.core.modules.venuesbook.manager.BExchangeRecordManager;
import cn.cashbang.core.modules.venuesbook.service.BExchangeRecordService;

/**
 * 积分兑换记录表
 *
 * @author daibangzhu
 * @email xxx@daibangzhu.cn
 * @url www.daibangzhu.cn
 * @date 2021年3月05日 下午1:02:51
 */
@Service("bExchangeRecordService")
public class BExchangeRecordServiceImpl implements BExchangeRecordService {

	@Autowired
	private BExchangeRecordManager bExchangeRecordManager;
    @Autowired
    private BUserManager bUserManager;

	@Override
	public Page<BExchangeRecordEntity> listBExchangeRecord(Map<String, Object> params) {
		Query query = new Query(params);
		Page<BExchangeRecordEntity> page = new Page<>(query);
		bExchangeRecordManager.listBExchangeRecord(page, query);
		return page;
	}

	@Override
	public Result saveBExchangeRecord(BExchangeRecordEntity role) {

        BUserEntity user = bUserManager.getBUserById(role.getUid());

        if(user.getPoints()<Integer.valueOf(role.getPoints())){
              return Result.error("分数不够不能兑换,快去攒积分吧。");
        }

        String uuid = CommonUtils.createUUID();
        role.setId(uuid);
        role.setCreateTime(new Date());
		int count = bExchangeRecordManager.saveBExchangeRecord(role);

        // 更新用户的分数
        user.setPoints(user.getPoints()+Integer.valueOf(role.getPoints()));
        bUserManager.updateBUser(user);

		return CommonUtils.msg(count);
	}

	@Override
	public Result getBExchangeRecordById(Long id) {
		BExchangeRecordEntity bExchangeRecord = bExchangeRecordManager.getBExchangeRecordById(id);
		return CommonUtils.msg(bExchangeRecord);
	}

	@Override
	public Result updateBExchangeRecord(BExchangeRecordEntity bExchangeRecord) {
		int count = bExchangeRecordManager.updateBExchangeRecord(bExchangeRecord);
		return CommonUtils.msg(count);
	}

	@Override
	public Result batchRemove(Long[] id) {
		int count = bExchangeRecordManager.batchRemove(id);
		return CommonUtils.msg(id, count);
	}

}
