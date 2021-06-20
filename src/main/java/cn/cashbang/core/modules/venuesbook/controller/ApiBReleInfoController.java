package cn.cashbang.core.modules.venuesbook.controller;

import cn.cashbang.core.common.annotation.SysLog;
import cn.cashbang.core.common.entity.Page;
import cn.cashbang.core.common.entity.Result;
import cn.cashbang.core.common.utils.StringUtils;
import cn.cashbang.core.modules.sys.controller.AbstractController;
import cn.cashbang.core.modules.venuesbook.entity.BReleInfoEntity;
import cn.cashbang.core.modules.venuesbook.entity.BVenueInfoEntity;
import cn.cashbang.core.modules.venuesbook.service.BReleInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 企业上下游关系信息表
 *
 * @author daibangzhu
 * @email xxx@daibangzhu.cn
 * @url www.daibangzhu.cn
 * @date 2021年6月18日 下午9:56:11
 */
@RestController
@RequestMapping("/api/releinfo")
public class ApiBReleInfoController extends AbstractController {
	
	@Autowired
	private BReleInfoService bReleInfoService;
	
	/**
	 * 列表
	 * @param page
	 * @return
	 */
	@RequestMapping("/list")
	public Map<String, Object> list(int page) {
		//return bReleInfoService.listBReleInfo(params);

        Map<String, Object> params = new HashMap<>();
        Map<String, Object> result = new HashMap<>();

        params.put("pageNumber",page);
        params.put("pageSize",6);
        params.put("sortOrde","desc");

        Page<BReleInfoEntity> list = bReleInfoService.listBReleInfo(params);
        if(list.getTotal()>0){
            result.put("code",0);
            result.put("rows",list.getRows());
            result.put("page",page);
            result.put("msg","查询成功！");
        }
        else{
            result.put("code",-1);
            result.put("rows",null);
            result.put("msg","没有查询到数据！");
        }
        
        return result;
	}
		
	/**
	 * 新增
	 * @param  title, content, userId
	 * @return
	 */
	@RequestMapping("/save")
	public Result save(String title,String content,String userId) {
        BReleInfoEntity bReleInfo = new BReleInfoEntity();
        bReleInfo.setId(userId);
        bReleInfo.setTitle(title);
        bReleInfo.setContent(content);
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
