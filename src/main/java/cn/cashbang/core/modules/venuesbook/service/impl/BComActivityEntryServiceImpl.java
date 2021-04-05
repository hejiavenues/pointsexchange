package cn.cashbang.core.modules.venuesbook.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import cn.cashbang.core.common.utils.StringUtils;
import cn.cashbang.core.modules.venuesbook.entity.*;
import cn.cashbang.core.modules.venuesbook.manager.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.cashbang.core.common.entity.Page;
import cn.cashbang.core.common.entity.Query;
import cn.cashbang.core.common.entity.Result;
import cn.cashbang.core.common.utils.CommonUtils;
import cn.cashbang.core.modules.venuesbook.service.BComActivityEntryService;

/**
 * 活动报名记录表
 *
 * @author daibangzhu
 * @email xxx@daibangzhu.cn
 * @url www.daibangzhu.cn
 * @date 2021年2月28日 PM2:16:50
 */
@Service("bComActivityEntryService")
public class BComActivityEntryServiceImpl implements BComActivityEntryService {

	@Autowired
	private BComActivityEntryManager bComActivityEntryManager;

    @Autowired
    private BUserManager bUserManager;


    @Autowired
    private BPointsRecordManager bPointsRecordManager;

    @Autowired
    private BCommunityActivitiesManager bCommunityActivitiesManager;

	@Override
	public Page<BComActivityEntryEntity> listBComActivityEntry(Map<String, Object> params) {
        if(!com.alibaba.druid.util.StringUtils.isEmpty((String)params.get("activityId"))) {
            params.put("activityId", ((String)params.get("activityId")).replace("\"", ""));
        }
		Query query = new Query(params);
		Page<BComActivityEntryEntity> page = new Page<>(query);
		bComActivityEntryManager.listBComActivityEntry(page, query);
		return page;
	}

	@Override
	public Result saveBComActivityEntry(BComActivityEntryEntity role) {

        // 查询是不是已经报过名了
        List<BComActivityEntryEntity> entityList = bComActivityEntryManager
                .getUserListById(role.getComActivityId(),role.getUid());

        if(entityList!=null){
            if(entityList.size()>0){
                return  Result.error("您已经报名该活动，不能再重复报名！");
            }
        }

        //根据userId查询用户信息
        BUserEntity bUser = bUserManager.getBUserById(role.getUid());

        role.setUname(bUser.getUname());
        role.setMobile(bUser.getMobile());

		int count = bComActivityEntryManager.saveBComActivityEntry(role);
		return CommonUtils.msg(count);
	}

	@Override
	public Result getBComActivityEntryById(Long id) {
		BComActivityEntryEntity bComActivityEntry = bComActivityEntryManager.getBComActivityEntryById(id);
		return CommonUtils.msg(bComActivityEntry);
	}

	@Override
	public Result updateBComActivityEntry(BComActivityEntryEntity bComActivityEntry) {

	    // 判断是不是已经签到了，不能重复签到
        List<BComActivityEntryEntity> entityList = bComActivityEntryManager
                .getUserListById(bComActivityEntry.getComActivityId(),bComActivityEntry.getUid());

        if(entityList!=null){
            if(entityList.size()>0){
                if(entityList.get(0).getIspresent()==1){
                    return  Result.error("您已经签到了该活动，无需重复签到！");
                }

                if(entityList.get(0).getStatus()==2){
                    return  Result.error("您已取消参加该活动，不能签到！");
                }
            }
        }
        else{
            return  Result.error("您没有报名参加该活动，不能签到！");
        }


        int count = bComActivityEntryManager.updateBComActivityEntry(bComActivityEntry);

		if(count>0){

		    // 签到成功加积分
            BUserEntity user = bUserManager.getBUserById(bComActivityEntry.getUid());

            // 更新用户的分数
            BCommunityActivitiesEntity act =bCommunityActivitiesManager
                    .getBCommunityActivitiesById(bComActivityEntry.getComActivityId());
            user.setPoints(user.getPoints().add(act.getActivityHour()));   // TODO 暂定奖励的是活动的时长
            bUserManager.updateBUser(user);

            // 新增积分记录
            BPointsRecordEntity role = new BPointsRecordEntity();
            role.setPid(CommonUtils.createUUID());
            role.setAccessType(1); // 1、参加活动 2、发布随拍 3、兑换商品 4.管理员奖励
            role.setCreateTime(new Date());
            role.setUpdateTime(new Date());
            role.setUid(bComActivityEntry.getUid());
            role.setPoints(act.getActivityHour());   // TODO  暂定奖励的是活动的时长
            BCommunityActivitiesEntity ca = bCommunityActivitiesManager
                    .getBCommunityActivitiesById(bComActivityEntry.getComActivityId());
            if(ca!=null){
                role.setRemark("参加了活动："+ ca.getActivityName());
            }

            bPointsRecordManager.saveBPointsRecord(role);
        }

		return CommonUtils.msg(count);
	}

	@Override
	public Result batchRemove(String[] id) {
		int count = bComActivityEntryManager.batchRemove(id);
		return CommonUtils.msg(id, count);
	}

    @Override
    public Result getUserListById(String actId,String uid){

        List<BComActivityEntryEntity> entity = bComActivityEntryManager.getUserListById(actId,uid);

        return  Result.ok().put("raws", entity);
    }
}
