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
import cn.cashbang.core.modules.venuesbook.entity.BExchangeRecordEntity;
import cn.cashbang.core.modules.venuesbook.service.BExchangeRecordService;

/**
 * 积分兑换记录表
 *
 * @author daibangzhu
 * @email xxx@daibangzhu.cn
 * @url www.daibangzhu.cn
 * @date 2021年3月05日 下午1:02:51
 */
@RestController
@RequestMapping("/venuesbook/exchrecord")
public class BExchangeRecordController extends AbstractController {
	
	@Autowired
	private BExchangeRecordService bExchangeRecordService;
	
	/**
	 * 列表
	 * @param params
	 * @return
	 */
	@RequestMapping("/list")
	public Page<BExchangeRecordEntity> list(@RequestBody Map<String, Object> params) {
		return bExchangeRecordService.listBExchangeRecord(params);
	}
		
	/**
	 * 新增
	 * @param bExchangeRecord
	 * @return
	 */
	@SysLog("新增积分兑换记录表")
	@RequestMapping("/save")
	public Result save(@RequestBody BExchangeRecordEntity bExchangeRecord) {
		return bExchangeRecordService.saveBExchangeRecord(bExchangeRecord);
	}
	
	/**
	 * 根据id查询详情
	 * @param id
	 * @return
	 */
	@RequestMapping("/info")
	public Result getById(@RequestBody Long id) {
		return bExchangeRecordService.getBExchangeRecordById(id);
	}
	
	/**
	 * 修改
	 * @param bExchangeRecord
	 * @return
	 */
	@SysLog("修改积分兑换记录表")
	@RequestMapping("/update")
	public Result update(@RequestBody BExchangeRecordEntity bExchangeRecord) {
		return bExchangeRecordService.updateBExchangeRecord(bExchangeRecord);
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@SysLog("删除积分兑换记录表")
	@RequestMapping("/remove")
	public Result batchRemove(@RequestBody Long[] id) {
		return bExchangeRecordService.batchRemove(id);
	}
	
}
