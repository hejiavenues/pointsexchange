package cn.cashbang.core.modules.venuesbook.dao;

import org.apache.ibatis.annotations.Mapper;

import cn.cashbang.core.modules.venuesbook.entity.BActivityEntryEntity;
import cn.cashbang.core.modules.sys.dao.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 活动报名记录表
 *
 * @author daibangzhu
 * @email xxx@daibangzhu.cn
 * @url www.daibangzhu.cn
 * @date 2020年12月22日 下午1:12:46
 */
@Mapper
public interface BActivityEntryMapper extends BaseMapper<BActivityEntryEntity> {

    List<BActivityEntryEntity> getUserListById(@Param("activityId")String activityId, @Param("uid")String uid);

    int deleteByActivityId(String activityId);
}
