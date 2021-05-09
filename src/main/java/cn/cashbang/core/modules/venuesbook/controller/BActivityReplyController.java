package cn.cashbang.core.modules.venuesbook.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.cashbang.core.common.annotation.SysLog;
import cn.cashbang.core.modules.sys.controller.AbstractController;
import cn.cashbang.core.common.entity.Page;
import cn.cashbang.core.common.entity.Result;
import cn.cashbang.core.modules.venuesbook.entity.BActivityReplyEntity;
import cn.cashbang.core.modules.venuesbook.service.BActivityReplyService;

/**
 * 活动评论表
 *
 * @author daibangzhu
 * @email xxx@daibangzhu.cn
 * @url www.daibangzhu.cn
 * @date 2021年5月09日 PM1:27:16
 */
@RestController
@RequestMapping("/venuesbook/activityreply")
public class BActivityReplyController extends AbstractController {
	
	@Autowired
	private BActivityReplyService bActivityReplyService;
	
	/**
	 * 列表
	 * @param params
	 * @return
	 */
	@RequestMapping("/list")
	public Page<BActivityReplyEntity> list(@RequestBody Map<String, Object> params) {
		return bActivityReplyService.listBActivityReply(params);
	}
		
	/**
	 * 新增
	 * @param bActivityReply
	 * @return
	 */
	@SysLog("新增活动评论表")
	@RequestMapping("/save")
	public Result save(@RequestBody BActivityReplyEntity bActivityReply) {
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
