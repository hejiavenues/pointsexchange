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
import cn.cashbang.core.modules.venuesbook.entity.BVenueInfoOutEntity;
import cn.cashbang.core.modules.venuesbook.service.BVenueInfoOutService;

/**
 * 外部场馆信息表
 *
 * @author daibangzhu
 * @email xxx@daibangzhu.cn
 * @url www.daibangzhu.cn
 * @date 2021年5月09日 下午3:01:01
 */
@RestController
@RequestMapping("/venuesbook/outvenueinfo")
public class BVenueInfoOutController extends AbstractController {
	
	@Autowired
	private BVenueInfoOutService bVenueInfoOutService;
	
	/**
	 * 列表
	 * @param params
	 * @return
	 */
	@RequestMapping("/list")
	public Page<BVenueInfoOutEntity> list(@RequestBody Map<String, Object> params) {
		return bVenueInfoOutService.listBVenueInfoOut(params);
	}
		
	/**
	 * 新增
	 * @param bVenueInfoOut
	 * @return
	 */
	@SysLog("新增外部场馆信息表")
	@RequestMapping("/save")
	public Result save(@RequestBody BVenueInfoOutEntity bVenueInfoOut) {
		return bVenueInfoOutService.saveBVenueInfoOut(bVenueInfoOut);
	}
	
	/**
	 * 根据id查询详情
	 * @param id
	 * @return
	 */
	@RequestMapping("/info")
	public Result getById(@RequestBody Long id) {
		return bVenueInfoOutService.getBVenueInfoOutById(id);
	}
	
	/**
	 * 修改
	 * @param bVenueInfoOut
	 * @return
	 */
	@SysLog("修改外部场馆信息表")
	@RequestMapping("/update")
	public Result update(@RequestBody BVenueInfoOutEntity bVenueInfoOut) {
		return bVenueInfoOutService.updateBVenueInfoOut(bVenueInfoOut);
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@SysLog("删除外部场馆信息表")
	@RequestMapping("/remove")
	public Result batchRemove(@RequestBody String[] id) {
		return bVenueInfoOutService.batchRemove(id);
	}
	
}
