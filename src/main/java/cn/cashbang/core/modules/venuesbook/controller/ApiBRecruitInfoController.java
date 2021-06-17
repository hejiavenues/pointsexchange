package cn.cashbang.core.modules.venuesbook.controller;

import cn.cashbang.core.common.entity.Page;
import cn.cashbang.core.common.entity.Result;
import cn.cashbang.core.common.utils.CommonUtils;
import cn.cashbang.core.modules.sys.controller.AbstractController;
import cn.cashbang.core.modules.venuesbook.entity.BActivityReplyEntity;
import cn.cashbang.core.modules.venuesbook.entity.BRecruitInfoEntity;
import cn.cashbang.core.modules.venuesbook.service.BRecruitInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 招聘信息表
 *
 * @author daibangzhu
 * @email xxx@daibangzhu.cn
 * @url www.daibangzhu.cn
 * @date 2021年5月09日 下午2:54:48
 */
@RestController
@RequestMapping("/api/recruitInfo")
public class ApiBRecruitInfoController extends AbstractController {
	
	@Autowired
	private BRecruitInfoService bRecruitInfoService;
	
	/**
	 * 列表
	 * @param page
	 * @return
	 */
	@RequestMapping("/list")
	public Map<String, Object> list(int page,String pJobName) {
        Map<String, Object> params = new HashMap<>();
        Map<String, Object> result = new HashMap<>();

        params.put("pageNumber",page);
        params.put("pageSize",5);
        params.put("sortOrde","asc");
        params.put("activityId",pJobName);

        Page<BRecruitInfoEntity> list = bRecruitInfoService.listBRecruitInfo(params);
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
     * 列表
     * @param recruitId
     * @return
     */
    @RequestMapping("/anQuestion")
    public Map<String, Object> anQuestion(String  recruitId,String question) {
        Map<String, Object> params = new HashMap<>();
        Map<String, Object> result = new HashMap<>();

//        params.put("pageNumber",page);
//        params.put("pageSize",5);
//        params.put("sortOrde","asc");
//        params.put("activityId",pJobName);


            result.put("code",0);
            result.put("data","我暂时无法回答您的问题，请联系管理员！");
            result.put("msg","查询成功！");

        return result;
    }
		
	/**
	 * 新增
	 * @param userId
	 * @return
	 */
	@RequestMapping("/save")
	public Result save(String userId,String hrName,String phone,
                       String jobName,String salary,String remark,String recruitNumber) {

        BRecruitInfoEntity bRecruitInfo = new BRecruitInfoEntity();
        bRecruitInfo.setUserId(userId);
        bRecruitInfo.setHrName(hrName);
        bRecruitInfo.setPhone(phone);
        bRecruitInfo.setJobName(jobName);
        bRecruitInfo.setSalary(salary);
        String uuid = CommonUtils.createUUID();         
        bRecruitInfo.setRecruitId(uuid);
        bRecruitInfo.setRecruitNumber(recruitNumber);
        bRecruitInfo.setRemark(remark);
        bRecruitInfo.setCreateTime(new Date());

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
