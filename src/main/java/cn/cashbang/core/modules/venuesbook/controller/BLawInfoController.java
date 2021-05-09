package cn.cashbang.core.modules.venuesbook.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.druid.util.StringUtils;

import cn.cashbang.core.common.annotation.SysLog;
import cn.cashbang.core.modules.sys.controller.AbstractController;
import cn.cashbang.core.common.entity.Page;
import cn.cashbang.core.common.entity.Result;
import cn.cashbang.core.modules.venuesbook.entity.BLawInfoEntity;
import cn.cashbang.core.modules.venuesbook.service.BLawInfoService;

/**
 * 法律体检表
 *
 * @author daibangzhu
 * @email xxx@daibangzhu.cn
 * @url www.daibangzhu.cn
 * @date 2021年5月09日 下午3:00:03
 */
@RestController
@RequestMapping("/venuesbook/lawinfo")
public class BLawInfoController extends AbstractController {
	
	@Autowired
	private BLawInfoService bLawInfoService;
	
	/**
	 * 列表
	 * @param params
	 * @return
	 */
	@RequestMapping("/list")
	public Page<BLawInfoEntity> list(@RequestBody Map<String, Object> params) {
		return bLawInfoService.listBLawInfo(params);
	}
		
	/**
	 * 新增
	 * @param bLawInfo
	 * @return
	 */
	@SysLog("新增法律体检表")
	@RequestMapping("/save")
	public Result save(@RequestBody BLawInfoEntity bLawInfo) {
		return bLawInfoService.saveBLawInfo(bLawInfo);
	}
	
	/**
	 * 根据id查询详情
	 * @param id
	 * @return
	 */
	@RequestMapping("/info")
	public Result getById(@RequestBody String id) {
		if(!StringUtils.isEmpty(id)) {
			id = id.replace("\"", "");
		}
		return bLawInfoService.getBLawInfoById(id);
	}
	
	/**
	 * 修改
	 * @param bLawInfo
	 * @return
	 */
	@SysLog("修改法律体检表")
	@RequestMapping("/update")
	public Result update(@RequestBody BLawInfoEntity bLawInfo) {
		return bLawInfoService.updateBLawInfo(bLawInfo);
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@SysLog("删除法律体检表")
	@RequestMapping("/remove")
	public Result batchRemove(@RequestBody String[] id) {
		return bLawInfoService.batchRemove(id);
	}
	
}
