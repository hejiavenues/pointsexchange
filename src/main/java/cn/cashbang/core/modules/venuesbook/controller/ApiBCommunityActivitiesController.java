package cn.cashbang.core.modules.venuesbook.controller;

import cn.cashbang.core.common.annotation.SysLog;
import cn.cashbang.core.common.entity.Page;
import cn.cashbang.core.common.entity.Result;
import cn.cashbang.core.common.utils.CommonUtils;
import cn.cashbang.core.common.utils.QRCodeUtils;
import cn.cashbang.core.modules.sys.controller.AbstractController;
import cn.cashbang.core.modules.venuesbook.entity.BActivitiesEntity;
import cn.cashbang.core.modules.venuesbook.entity.BActivityEntryEntity;
import cn.cashbang.core.modules.venuesbook.entity.BComActivityEntryEntity;
import cn.cashbang.core.modules.venuesbook.entity.BCommunityActivitiesEntity;
import cn.cashbang.core.modules.venuesbook.service.BComActivityEntryService;
import cn.cashbang.core.modules.venuesbook.service.BCommunityActivitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 社区活动信息表
 *
 * @author daibangzhu
 * @email xxx@daibangzhu.cn
 * @url www.daibangzhu.cn
 * @date 2021年2月27日 PM9:46:01
 */
@RestController
@RequestMapping("/api/comactivity")
public class ApiBCommunityActivitiesController extends AbstractController {
	
	@Autowired
	private BCommunityActivitiesService bCommunityActivitiesService;

    @Autowired
    private BComActivityEntryService bComActivityEntryService;
	
	/**
	 * 列表
	 * @param page
	 * @return
	 */
	@RequestMapping("/list")
	public Map<String, Object> list(int page,String queryAcName,String queryUid,
                                    String queryDate) {
		//return bCommunityActivitiesService.listBCommunityActivities(params);

        Map<String, Object> params = new HashMap<>();
        Map<String, Object> result = new HashMap<>();

        params.put("pageNumber",page);
        params.put("pageSize",5);
        params.put("aStatus",1);  // 只有公开的活动才需要报名
        params.put("sortOrde","asc");
        params.put("queryAcName",queryAcName);
        params.put("queryUid",queryUid);
        params.put("queryDate",queryDate);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String nowDate = simpleDateFormat.format(new Date()) ;
        params.put("nowDate",nowDate);

//        params.put("queryComId",queryComId);
//        params.put("queryActType",queryActType);
//        params.put("queryCount",queryCount);

        Page<BCommunityActivitiesEntity> list = bCommunityActivitiesService.listBCommunityActivities(params);
        if(list.getTotal()>0){
            result.put("code",0);
            result.put("rows",list.getRows());
            result.put("page",page);
            result.put("msg","查询成功！");
        }
        else{
            result.put("code",-1);
            result.put("rows",null);
            result.put("msg","没有查询到数据！");
        }
        return result;
	}

    /**
     * 列表
     * @param page
     * @return
     */
    @RequestMapping("/listBefore")
    public Map<String, Object> listBefore(int page,String queryAcName,String queryUid,
                                    String queryDate) {
        //return bCommunityActivitiesService.listBCommunityActivities(params);

        Map<String, Object> params = new HashMap<>();
        Map<String, Object> result = new HashMap<>();

        params.put("pageNumber",page);
        params.put("pageSize",5);
        params.put("aStatus",1);  // 只有公开的活动才需要报名
        params.put("sortOrde","asc");
        params.put("queryAcName",queryAcName);
        params.put("queryUid",queryUid);
        params.put("queryDate",queryDate);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String nowDate = simpleDateFormat.format(new Date()) ;
        params.put("beforeDate",nowDate);

//        params.put("queryComId",queryComId);
//        params.put("queryActType",queryActType);
//        params.put("queryCount",queryCount);

        Page<BCommunityActivitiesEntity> list = bCommunityActivitiesService.listBCommunityActivities(params);
        if(list.getTotal()>0){
            result.put("code",0);
            result.put("rows",list.getRows());
            result.put("page",page);
            result.put("msg","查询成功！");
        }
        else{
            result.put("code",-1);
            result.put("rows",null);
            result.put("msg","没有查询到数据！");
        }
        return result;
    }
		
	/**
	 * 新增
	 * @param activityTime
	 * @return
	 */
	@SysLog("新增社区活动信息表")
	@RequestMapping("/saveReply")
	public Result save(String userId,String activityTime, String address,String activityIconUrl,
                       String activityName,String activityType,String activityContent,int activityCount) {

        BCommunityActivitiesEntity bCommunityActivities = new BCommunityActivitiesEntity();
        bCommunityActivities.setUid(userId);
        bCommunityActivities.setActivityContent(activityContent);
        bCommunityActivities.setActivityTime(activityTime);
        bCommunityActivities.setActivityType(activityType);
        bCommunityActivities.setActivityName(activityName);
        bCommunityActivities.setActivityCount(activityCount);
        String uuid = CommonUtils.createUUID();
        bCommunityActivities.setComActivityId(uuid);
        bCommunityActivities.setCreateTime(new Date());
        bCommunityActivities.setAddress(address);
        bCommunityActivities.setPicUrl(activityIconUrl);

		return bCommunityActivitiesService.saveBCommunityActivities(null,bCommunityActivities);
	}

    /**
     * 新增
     * @param activityId
     * @return
     */
    @SysLog("新增活动报名记录表")
    @RequestMapping("/entryActById")
    public Result save(String activityId,String userId) {

        BComActivityEntryEntity  bActivityEntry = new  BComActivityEntryEntity();
        bActivityEntry.setComActivityId(activityId);
        bActivityEntry.setUid(userId);
        bActivityEntry.setStatus(1);
        String uuid = CommonUtils.createUUID();
        bActivityEntry.setEid(uuid);
        bActivityEntry.setCreateTime(new Date());
        bActivityEntry.setIspresent(Integer.valueOf(0));
        
        return bComActivityEntryService.saveBComActivityEntry(bActivityEntry);
    }

    /**
     * 取消活动报名接口
     * @param activityId
     * @return
     */
    @RequestMapping("/cancelActById")
    public Result cancelActById(String activityId,String userId) {

        BComActivityEntryEntity bActivityEntry = new BComActivityEntryEntity();
        bActivityEntry.setComActivityId(activityId);
        bActivityEntry.setUid(userId);
        bActivityEntry.setStatus(2);  // 取消

        return bComActivityEntryService.updateBComActivityEntry(bActivityEntry);
    }

    /**
     * 活动签到接口
     * @param activityId
     * @return
     */
    @RequestMapping("/signActById")
    public Result signActById(String activityId,String userId) {

        BComActivityEntryEntity bActivityEntry = new BComActivityEntryEntity();
        bActivityEntry.setComActivityId(activityId);
        bActivityEntry.setUid(userId);
        bActivityEntry.setIspresent(Integer.valueOf(1));  // 签到

        return bComActivityEntryService.updateBComActivityEntry(bActivityEntry);
    }


    @RequestMapping("/listActByUserId")
    public Result listActByUserId(String uid){

        return  bCommunityActivitiesService.listActByUserId(uid);
    }

    @RequestMapping("/getUserListById")
    public Result getUserListById(String activityId){

        return   bComActivityEntryService.getUserListById(activityId,null);
    }


    @RequestMapping("/listByCreateUser")
    public Result listByCreateUser(String uid){

        return   bCommunityActivitiesService.listByCreateUser(uid);
    }

    /**
	 * 根据id查询详情
	 * @param activityId
	 * @return
	 */
	@RequestMapping("/getActById")
	public Result getById(String activityId)
    {
		return bCommunityActivitiesService.getBCommunityActivitiesById(activityId);
	}

//    @RequestMapping("/creatQRCode")
//    public Result creatQRCode(String activityId)  throws  Exception {
//
//        String text = "activityId="+activityId;  //这里设置自定义网站url或文字
//        String logoPath = "D:\\picture\\1.jpg"; //二维码图片
//        String destPath = "D:\\picture\\";		//保存地址
//        //调用工具类
//        System.out.println(QRCodeUtils.encode(text, logoPath, destPath, true,"123"));
//        return Result.ok("生成成功");
//    }
}
