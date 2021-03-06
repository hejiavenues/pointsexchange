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
import cn.cashbang.core.modules.venuesbook.entity.BPointsRecordEntity;
import cn.cashbang.core.modules.venuesbook.service.BPointsRecordService;

/**
 * 积分增减记录表
 *
 * @author daibangzhu
 * @email xxx@daibangzhu.cn
 * @url www.daibangzhu.cn
 * @date 2021年3月05日 下午2:01:23
 */
@RestController
@RequestMapping("/venuesbook/pointsrecord")
public class BPointsRecordController extends AbstractController {
	
	@Autowired
	private BPointsRecordService bPointsRecordService;
	
	/**
	 * 列表
	 * @param params
	 * @return
	 */
	@RequestMapping("/list")
	public Page<BPointsRecordEntity> list(@RequestBody Map<String, Object> params) {
		return bPointsRecordService.listBPointsRecord(params);
	}
		
	/**
	 * 新增
	 * @param bPointsRecord
	 * @return
	 */
	@SysLog("新增积分增减记录表")
	@RequestMapping("/save")
	public Result save(@RequestBody BPointsRecordEntity bPointsRecord) {
		return bPointsRecordService.saveBPointsRecord(bPointsRecord);
	}
	
	/**
	 * 根据id查询详情
	 * @param id
	 * @return
	 */
	@RequestMapping("/info")
	public Result getById(@RequestBody Long id) {
		return bPointsRecordService.getBPointsRecordById(id);
	}
	
	/**
	 * 修改
	 * @param bPointsRecord
	 * @return
	 */
	@SysLog("修改积分增减记录表")
	@RequestMapping("/update")
	public Result update(@RequestBody BPointsRecordEntity bPointsRecord) {
		return bPointsRecordService.updateBPointsRecord(bPointsRecord);
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@SysLog("删除积分增减记录表")
	@RequestMapping("/remove")
	public Result batchRemove(@RequestBody Long[] id) {
		return bPointsRecordService.batchRemove(id);
	}
	
}
