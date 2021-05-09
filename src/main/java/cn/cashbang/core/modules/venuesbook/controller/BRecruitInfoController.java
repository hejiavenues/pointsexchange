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
import cn.cashbang.core.modules.venuesbook.entity.BRecruitInfoEntity;
import cn.cashbang.core.modules.venuesbook.service.BRecruitInfoService;

/**
 * 招聘信息表
 *
 * @author daibangzhu
 * @email xxx@daibangzhu.cn
 * @url www.daibangzhu.cn
 * @date 2021年5月09日 下午2:54:48
 */
@RestController
@RequestMapping("/venuesbook/recruitInfo")
public class BRecruitInfoController extends AbstractController {
	
	@Autowired
	private BRecruitInfoService bRecruitInfoService;
	
	/**
	 * 列表
	 * @param params
	 * @return
	 */
	@RequestMapping("/list")
	public Page<BRecruitInfoEntity> list(@RequestBody Map<String, Object> params) {
		return bRecruitInfoService.listBRecruitInfo(params);
	}
		
	/**
	 * 新增
	 * @param bRecruitInfo
	 * @return
	 */
	@RequestMapping("/save")
	public Result save(@RequestBody BRecruitInfoEntity bRecruitInfo) {
		return bRecruitInfoService.saveBRecruitInfo(bRecruitInfo);
	}
	
	/**
	 * 根据id查询详情
	 * @param id
	 * @return
	 */
	@RequestMapping("/info")
	public Result getById(@RequestBody Long id) {
		return bRecruitInfoService.getBRecruitInfoById(id);
	}
	
	/**
	 * 修改
	 * @param bRecruitInfo
	 * @return
	 */
	@RequestMapping("/update")
	public Result update(@RequestBody BRecruitInfoEntity bRecruitInfo) {
		return bRecruitInfoService.updateBRecruitInfo(bRecruitInfo);
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@RequestMapping("/remove")
	public Result batchRemove(@RequestBody String[] id) {
		return bRecruitInfoService.batchRemove(id);
	}
	
}
