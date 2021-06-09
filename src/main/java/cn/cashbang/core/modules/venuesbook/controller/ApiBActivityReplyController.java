package cn.cashbang.core.modules.venuesbook.controller;

import cn.cashbang.core.common.annotation.SysLog;
import cn.cashbang.core.common.entity.Page;
import cn.cashbang.core.common.entity.Result;
import cn.cashbang.core.common.utils.CommonUtils;
import cn.cashbang.core.modules.sys.controller.AbstractController;
import cn.cashbang.core.modules.venuesbook.entity.BActivityReplyEntity;
import cn.cashbang.core.modules.venuesbook.entity.BCommunityActivitiesEntity;
import cn.cashbang.core.modules.venuesbook.service.BActivityReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 活动评论表
 *
 * @author daibangzhu
 * @email xxx@daibangzhu.cn
 * @url www.daibangzhu.cn
 * @date 2021年5月09日 PM1:27:16
 */
@RestController
@RequestMapping("/api/activityreply")
public class ApiBActivityReplyController extends AbstractController {
	
	@Autowired
	private BActivityReplyService bActivityReplyService;
	
	/**
	 * 列表
	 * @param activityId
	 * @return
	 */
	@RequestMapping("/list")
	public  Map<String, Object> list(int page,String activityId,String pageSize) {

        Map<String, Object> params = new HashMap<>();
        Map<String, Object> result = new HashMap<>();

        if(pageSize==null||pageSize=="")   {
            pageSize="3";
        }

        params.put("pageNumber",page);
        params.put("pageSize",Integer.valueOf(pageSize));
        params.put("sortOrde","asc");
        params.put("activityId",activityId);

        Page<BActivityReplyEntity> list = bActivityReplyService.listBActivityReply(params);
        if(list.getTotal()>0){
            result.put("code",0);
            result.put("rows",list.getRows());
            result.put("page",page);
            result.put("msg","查询成功！");
        }
        else{
            result.put("code",-1);
            result.put("rows",null);
            result.put("msg","还没有人评论快来评论吧！");
        }
        return result;
	}
		
	/**
	 * 新增
	 * @param uid
	 * @return
	 */
	@SysLog("新增活动评论表")
	@RequestMapping("/save")
	public Result save(String uid,String content,String activityId,String picUrl ) {
        BActivityReplyEntity bActivityReply = new BActivityReplyEntity();
        bActivityReply.setActivityId(activityId);
        bActivityReply.setUid(uid);
        bActivityReply.setContent(content);
        String uuid = CommonUtils.createUUID();
        bActivityReply.setCreateTime(new Date());
        bActivityReply.setReplyId(uuid);
        bActivityReply.setPicUrl(picUrl);
		return bActivityReplyService.saveBActivityReply(bActivityReply);
	}
	
	/**
	 * 根据id查询详情
	 * @param id
	 * @return
	 */
	@RequestMapping("/info")
	public Result getById(@RequestBody Long id) {
		return bActivityReplyService.getBActivityReplyById(id);
	}
	
	/**
	 * 修改
	 * @param bActivityReply
	 * @return
	 */
	@SysLog("修改活动评论表")
	@RequestMapping("/update")
	public Result update(@RequestBody BActivityReplyEntity bActivityReply) {
		return bActivityReplyService.updateBActivityReply(bActivityReply);
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@SysLog("删除活动评论表")
	@RequestMapping("/remove")
	public Result batchRemove(@RequestBody Long[] id) {
		return bActivityReplyService.batchRemove(id);
	}
	
}
