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
import cn.cashbang.core.modules.venuesbook.entity.BNewsEntity;
import cn.cashbang.core.modules.venuesbook.entity.BNewsEntityDto;
import cn.cashbang.core.modules.venuesbook.service.BNewsService;

/**
 * 文章列表信息
 *
 * @author daibangzhu
 * @email xxx@daibangzhu.cn
 * @url www.daibangzhu.cn
 * @date 2021年7月12日 下午7:56:51
 */
@RestController
@RequestMapping("/venuesbook/bnews")
public class BNewsController extends AbstractController {
	
	@Autowired
	private BNewsService bNewsService;
	
	/**
	 * 列表
	 * @param params
	 * @return
	 */
	@RequestMapping("/list")
	public Page<BNewsEntity> list(@RequestBody Map<String, Object> params) {
		return bNewsService.listBNews(params);
	}
		
	/**
	 * 新增
	 * @param bNews
	 * @return
	 */
	@RequestMapping("/save")
	public Result save(MultipartFile imgFile, BNewsEntity bNews) {
		Result resultEntity = new Result();
		if(imgFile == null){
			logger.error("新增banner配置信息，imgFile为空");
			resultEntity = Result.error(100, "banner配置信息图片为空");
			return resultEntity;
		}
		return bNewsService.saveBNews(imgFile,bNews);
		
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
		return bNewsService.getBNewsById(id);
	}
	
	/**
	 * 修改
	 * @param bNews
	 * @return
	 */
	@RequestMapping("/update")
	public Result update(@RequestBody MultipartFile imgFile, BNewsEntityDto bNews) {
		return bNewsService.updateBNews(imgFile,bNews);
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@RequestMapping("/remove")
	public Result batchRemove(@RequestBody String[] id) {
		return bNewsService.batchRemove(id);
	}
	
}
