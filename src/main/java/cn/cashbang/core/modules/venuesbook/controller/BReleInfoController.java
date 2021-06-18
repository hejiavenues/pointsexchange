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
import cn.cashbang.core.common.utils.StringUtils;
import cn.cashbang.core.modules.venuesbook.entity.BReleInfoEntity;
import cn.cashbang.core.modules.venuesbook.service.BReleInfoService;

/**
 * 企业上下游关系信息表
 *
 * @author daibangzhu
 * @email xxx@daibangzhu.cn
 * @url www.daibangzhu.cn
 * @date 2021年6月18日 下午9:56:11
 */
@RestController
@RequestMapping("/venuesbook/releinfo")
public class BReleInfoController extends AbstractController {
	
	@Autowired
	private BReleInfoService bReleInfoService;
	
	/**
	 * 列表
	 * @param params
	 * @return
	 */
	@RequestMapping("/list")
	public Page<BReleInfoEntity> list(@RequestBody Map<String, Object> params) {
		return bReleInfoService.listBReleInfo(params);
	}
		
	/**
	 * 新增
	 * @param bReleInfo
	 * @return
	 */
	@SysLog("新增企业上下游关系信息表")
	@RequestMapping("/save")
	public Result save(@RequestBody BReleInfoEntity bReleInfo) {
		return bReleInfoService.saveBReleInfo(bReleInfo);
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
		return bReleInfoService.getBReleInfoById(id);
	}
	
	/**
	 * 修改
	 * @param bReleInfo
	 * @return
	 */
	@RequestMapping("/update")
	public Result update(@RequestBody BReleInfoEntity bReleInfo) {
		return bReleInfoService.updateBReleInfo(bReleInfo);
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@SysLog("删除企业上下游关系信息表")
	@RequestMapping("/remove")
	public Result batchRemove(@RequestBody Long[] id) {
		return bReleInfoService.batchRemove(id);
	}
	
}
