package cn.cashbang.core.modules.venuesbook.controller;

import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import cn.cashbang.core.common.annotation.SysLog;
import cn.cashbang.core.modules.sys.controller.AbstractController;
import cn.cashbang.core.common.entity.Page;
import cn.cashbang.core.common.entity.Result;
import cn.cashbang.core.common.utils.StringUtils;
import cn.cashbang.core.modules.venuesbook.entity.BCommunityActivitiesDTO;
import cn.cashbang.core.modules.venuesbook.entity.BCommunityActivitiesEntity;
import cn.cashbang.core.modules.venuesbook.service.BCommunityActivitiesService;

/**
 * 社区活动信息表
 *
 * @author daibangzhu
 * @email xxx@daibangzhu.cn
 * @url www.daibangzhu.cn
 * @date 2021年2月27日 PM9:46:01
 */
@RestController
@RequestMapping("/venuesbook/comactivity")
public class BCommunityActivitiesController extends AbstractController {
	
	@Autowired
	private BCommunityActivitiesService bCommunityActivitiesService;
	
	/**
	 * 列表
	 * @param params
	 * @return
	 */
	@RequestMapping("/list")
	public Page<BCommunityActivitiesEntity> list(@RequestBody Map<String, Object> params) {
		return bCommunityActivitiesService.listBCommunityActivities(params);
	}
		
	/**
	 * 新增
	 * @param bCommunityActivities
	 * @return
	 */
	@SysLog("新增社区活动信息表")
	@RequestMapping("/save")
	public Result save(MultipartFile imgFile, BCommunityActivitiesEntity bCommunityActivities) {
		logger.info("新增banner配置开始，bBannerInfo：{}",bCommunityActivities.toString());
		Result resultEntity = new Result();
		if(imgFile == null){
			logger.error("新增banner配置信息，imgFile为空");
			resultEntity = Result.error(100, "banner配置信息图片为空");
			return resultEntity;
		}
		if(bCommunityActivities != null) {
			bCommunityActivities.setUid("eba0eae7fe384f469e7b82c57fa2e110");
		}
		return bCommunityActivitiesService.saveBCommunityActivities(imgFile,bCommunityActivities);
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
		return bCommunityActivitiesService.getBCommunityActivitiesById(id);
	}
	
	/**
	 * 修改
	 * @param bCommunityActivities
	 * @return
	 */
	@SysLog("修改社区活动信息表")
	@RequestMapping("/update")
	public Result update(@RequestBody MultipartFile imgFile, BCommunityActivitiesDTO bCommunityActivitiesDTO) {
		BCommunityActivitiesEntity b = new BCommunityActivitiesEntity();
		BeanUtils.copyProperties(bCommunityActivitiesDTO, b);
		return bCommunityActivitiesService.updateBCommunityActivities(imgFile,b);
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@SysLog("删除社区活动信息表")
	@RequestMapping("/remove")
	public Result batchRemove(@RequestBody String[] id) {
		return bCommunityActivitiesService.batchRemove(id);
	}
	
}
