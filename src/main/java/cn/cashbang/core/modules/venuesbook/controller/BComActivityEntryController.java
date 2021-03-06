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
import cn.cashbang.core.modules.venuesbook.entity.BComActivityEntryEntity;
import cn.cashbang.core.modules.venuesbook.service.BComActivityEntryService;

/**
 * 活动报名记录表
 *
 * @author daibangzhu
 * @email xxx@daibangzhu.cn
 * @url www.daibangzhu.cn
 * @date 2021年2月28日 PM2:16:50
 */
@RestController
@RequestMapping("/venuesbook/comactivityentry")
public class BComActivityEntryController extends AbstractController {
	
	@Autowired
	private BComActivityEntryService bComActivityEntryService;
	
	/**
	 * 列表
	 * @param params
	 * @return
	 */
	@RequestMapping("/list")
	public Page<BComActivityEntryEntity> list(@RequestBody Map<String, Object> params) {
		return bComActivityEntryService.listBComActivityEntry(params);
	}
		
	/**
	 * 新增
	 * @param bComActivityEntry
	 * @return
	 */
	@SysLog("新增活动报名记录表")
	@RequestMapping("/save")
	public Result save(@RequestBody BComActivityEntryEntity bComActivityEntry) {
		return bComActivityEntryService.saveBComActivityEntry(bComActivityEntry);
	}
	
	/**
	 * 根据id查询详情
	 * @param id
	 * @return
	 */
	@RequestMapping("/info")
	public Result getById(@RequestBody Long id) {
		return bComActivityEntryService.getBComActivityEntryById(id);
	}
	
	/**
	 * 修改
	 * @param bComActivityEntry
	 * @return
	 */
	@SysLog("修改活动报名记录表")
	@RequestMapping("/update")
	public Result update(@RequestBody BComActivityEntryEntity bComActivityEntry) {
		return bComActivityEntryService.updateBComActivityEntry(bComActivityEntry);
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@SysLog("删除活动报名记录表")
	@RequestMapping("/remove")
	public Result batchRemove(@RequestBody String[] id) {
		return bComActivityEntryService.batchRemove(id);
	}

}
