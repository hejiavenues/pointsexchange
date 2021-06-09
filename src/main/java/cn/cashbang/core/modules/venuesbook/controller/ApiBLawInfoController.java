package cn.cashbang.core.modules.venuesbook.controller;

import cn.cashbang.core.common.annotation.SysLog;
import cn.cashbang.core.common.entity.Page;
import cn.cashbang.core.common.entity.Result;
import cn.cashbang.core.modules.sys.controller.AbstractController;
import cn.cashbang.core.modules.venuesbook.entity.BActivityReplyEntity;
import cn.cashbang.core.modules.venuesbook.entity.BLawInfoEntity;
import cn.cashbang.core.modules.venuesbook.service.BLawInfoService;
import com.alibaba.druid.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 法律体检表
 *
 * @author daibangzhu
 * @email xxx@daibangzhu.cn
 * @url www.daibangzhu.cn
 * @date 2021年5月09日 下午3:00:03
 */
@RestController
@RequestMapping("/api/lawinfo")
public class ApiBLawInfoController extends AbstractController {
	
	@Autowired
	private BLawInfoService bLawInfoService;
	
	/**
	 * 列表
	 * @param page
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

        Page<BLawInfoEntity> list = bLawInfoService.listBLawInfo(params);
        if(list.getTotal()>0){
            result.put("code",0);
            result.put("rows",list.getRows());
            result.put("page",page);
            result.put("msg","查询成功！");
        }
        else{
            result.put("code",-1);
            result.put("rows",null);
            result.put("msg","没有查询到资料！");
        }
        return result;
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
