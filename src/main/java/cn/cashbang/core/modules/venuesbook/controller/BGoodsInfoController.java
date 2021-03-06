package cn.cashbang.core.modules.venuesbook.controller;

import java.util.Map;

import org.springframework.beans.BeanUtils;
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
import cn.cashbang.core.modules.venuesbook.entity.BGoodsDtoEntity;
import cn.cashbang.core.modules.venuesbook.entity.BGoodsInfoEntity;
import cn.cashbang.core.modules.venuesbook.service.BGoodsInfoService;

/**
 * 
 *
 * @author daibangzhu
 * @email xxx@daibangzhu.cn
 * @url www.daibangzhu.cn
 * @date 2021年3月04日 下午1:11:01
 */
@RestController
@RequestMapping("/venuesbook/goods")
public class BGoodsInfoController extends AbstractController {
	
	@Autowired
	private BGoodsInfoService bGoodsInfoService;
	
	/**
	 * 列表
	 * @param params
	 * @return
	 */
	@RequestMapping("/list")
	public Page<BGoodsInfoEntity> list(@RequestBody Map<String, Object> params) {
		return bGoodsInfoService.listBGoodsInfo(params);
	}
		
	/**
	 * 新增
	 * @param bGoodsInfo
	 * @return
	 */
	@RequestMapping("/save")
	public Result save(MultipartFile imgFile, BGoodsInfoEntity bGoodsInfo) {
		logger.info("新增商品配置开始，bBannerInfo：{}",bGoodsInfo.toString());
		Result resultEntity = new Result();
		if(imgFile == null){
			logger.error("新增商品配置信息，imgFile为空");
			resultEntity = Result.error(100, "商品图片为空");
			return resultEntity;
		}
		return bGoodsInfoService.saveBGoodsInfo(imgFile,bGoodsInfo);
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
		return bGoodsInfoService.getBGoodsInfoById(id);
	}
	
	/**
	 * 修改
	 * @param bGoodsInfo
	 * @return
	 */
	@RequestMapping("/update")
	public Result update(@RequestBody MultipartFile imgFile, BGoodsDtoEntity bGoodsDtoEntity) {
		BGoodsInfoEntity bGoodsInfo = new BGoodsInfoEntity();
		BeanUtils.copyProperties(bGoodsDtoEntity, bGoodsInfo);
		return bGoodsInfoService.updateBGoodsInfo(imgFile,bGoodsInfo);
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@RequestMapping("/remove")
	public Result batchRemove(@RequestBody String[] id) {
		return bGoodsInfoService.batchRemove(id);
	}
	
}
