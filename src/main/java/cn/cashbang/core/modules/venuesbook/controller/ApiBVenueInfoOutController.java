package cn.cashbang.core.modules.venuesbook.controller;

import cn.cashbang.core.common.annotation.SysLog;
import cn.cashbang.core.common.entity.Page;
import cn.cashbang.core.common.entity.Result;
import cn.cashbang.core.common.utils.CommonUtils;
import cn.cashbang.core.modules.sys.controller.AbstractController;
import cn.cashbang.core.modules.venuesbook.entity.BActivityReplyEntity;
import cn.cashbang.core.modules.venuesbook.entity.BVenueInfoOutEntity;
import cn.cashbang.core.modules.venuesbook.service.BVenueInfoOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Date;

/**
 * 外部场馆信息表
 *
 * @author daibangzhu
 * @email xxx@daibangzhu.cn
 * @url www.daibangzhu.cn
 * @date 2021年5月09日 下午3:01:01
 */
@RestController
@RequestMapping("/api/outvenueinfo")
public class ApiBVenueInfoOutController extends AbstractController {
	
	@Autowired
	private BVenueInfoOutService bVenueInfoOutService;
	
	/**
	 * 列表
	 * @param pName
	 * @return
	 */
	@RequestMapping("/list")
	public Map<String, Object> list(int page,String pName) {
        Map<String, Object> params = new HashMap<>();
        Map<String, Object> result = new HashMap<>();

        params.put("pageNumber",page);
        params.put("pageSize",5);
        params.put("sortOrde","asc");
        params.put("pName",pName);

        Page<BVenueInfoOutEntity> list = bVenueInfoOutService.listBVenueInfoOut(params);
        if(list.getTotal()>0){
            result.put("code",0);
            result.put("rows",list.getRows());
            result.put("page",page);
            result.put("msg","查询成功！");
        }
        else{
            result.put("code",-1);
            result.put("rows",null);
            result.put("msg","没有查到资料！");
        }
        return result;
	}
		
	/**
	 * 新增
	 * @param venueName
	 * @return
	 */
	@SysLog("新增外部场馆信息表")
	@RequestMapping("/save")
	public Result save(String venueName,int maxPeople,String address,String supportActiveType,
    String openTime,String activityRemark,String userId) {
        BVenueInfoOutEntity bVenueInfoOut = new BVenueInfoOutEntity();
        String uuid = CommonUtils.createUUID();
        bVenueInfoOut.setVenueId(uuid);
        bVenueInfoOut.setVenueName(venueName);
        bVenueInfoOut.setUserId(userId);
        bVenueInfoOut.setActivityRemark(activityRemark);
        bVenueInfoOut.setAddress(address);
        bVenueInfoOut.setMaxPeople(maxPeople);
        bVenueInfoOut.setOpenTime(openTime);
        bVenueInfoOut.setSupportActiveType(supportActiveType);
        bVenueInfoOut.setCreateTime(new Date());
        bVenueInfoOut.setStatus(0);
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
