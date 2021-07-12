package cn.cashbang.core.modules.venuesbook.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.druid.util.StringUtils;

import cn.cashbang.core.common.annotation.SysLog;
import cn.cashbang.core.modules.sys.controller.AbstractController;
import cn.cashbang.core.common.entity.Page;
import cn.cashbang.core.common.entity.Result;
import cn.cashbang.core.modules.venuesbook.entity.BCoopCompanyEntity;
import cn.cashbang.core.modules.venuesbook.entity.BCoopCompanyEntityDto;
import cn.cashbang.core.modules.venuesbook.service.BCoopCompanyService;

/**
 * 合作企业列表信息
 *
 * @author daibangzhu
 * @email xxx@daibangzhu.cn
 * @url www.daibangzhu.cn
 * @date 2021年7月12日 下午7:57:27
 */
@RestController
@RequestMapping("/venuesbook/coopcompany")
public class BCoopCompanyController extends AbstractController {
	
	@Autowired
	private BCoopCompanyService bCoopCompanyService;
	
	/**
	 * 列表
	 * @param params
	 * @return
	 */
	@RequestMapping("/list")
	public Page<BCoopCompanyEntity> list(@RequestBody Map<String, Object> params) {
		return bCoopCompanyService.listBCoopCompany(params);
	}
		
	/**
	 * 新增
	 * @param bCoopCompany
	 * @return
	 */
	@RequestMapping("/save")
	public Result save(MultipartFile imgFile, BCoopCompanyEntity bCoopCompany) {
		Result resultEntity = new Result();
		if(imgFile == null){
			logger.error("新增banner配置信息，imgFile为空");
			resultEntity = Result.error(100, "banner配置信息图片为空");
			return resultEntity;
		}
		return bCoopCompanyService.saveBCoopCompany(imgFile,bCoopCompany);
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
		return bCoopCompanyService.getBCoopCompanyById(id);
	}
	
	/**
	 * 修改
	 * @param bCoopCompany
	 * @return
	 */
	@RequestMapping("/update")
	public Result update(@RequestBody MultipartFile imgFile, BCoopCompanyEntityDto bCoopCompany) {
		return bCoopCompanyService.updateBCoopCompany(imgFile,bCoopCompany);
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@SysLog("删除合作企业列表信息")
	@RequestMapping("/remove")
	public Result batchRemove(@RequestBody String[] id) {
		return bCoopCompanyService.batchRemove(id);
	}
	
}
