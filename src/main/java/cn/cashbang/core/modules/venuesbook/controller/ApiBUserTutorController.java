package cn.cashbang.core.modules.venuesbook.controller;

import cn.cashbang.core.common.annotation.SysLog;
import cn.cashbang.core.common.entity.Page;
import cn.cashbang.core.common.entity.Result;
import cn.cashbang.core.modules.sys.controller.AbstractController;
import cn.cashbang.core.modules.venuesbook.entity.BUserTutorDTO;
import cn.cashbang.core.modules.venuesbook.entity.BUserTutorEntity;
import cn.cashbang.core.modules.venuesbook.service.BUserTutorService;
import com.alibaba.druid.util.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.Map;

/**
 * 志愿者导师信息表
 *
 * @author daibangzhu
 * @email xxx@daibangzhu.cn
 * @url www.daibangzhu.cn
 * @date 2021年6月15日 下午7:23:45
 */
@RestController
@RequestMapping("/api/usertutor")
public class ApiBUserTutorController extends AbstractController {
	
	@Autowired
	private BUserTutorService bUserTutorService;
	
	/**
	 * 列表
	 * @param params
	 * @return
	 */
	@RequestMapping("/list")
	public Page<BUserTutorEntity> list(@RequestBody Map<String, Object> params) {
		return bUserTutorService.listBUserTutor(params);
	}
		
	/**
	 * 新增
	 * @param bUserTutor
	 * @return
	 */
	@SysLog("新增志愿者导师信息表")
	@RequestMapping("/save")
	public Result save(String uid,String uname,Integer sex,String mobile,String skill,
                       String skillDes, String iconUrl,String idcardBackUrl,String committeeId) {

        BUserTutorEntity bUserTutor = new  BUserTutorEntity();
        bUserTutor.setUid(uid);
        bUserTutor.setUname(uname);
                bUserTutor.setSex(sex);
        bUserTutor.setMobile(mobile);
                bUserTutor.setSkill(skill);
        bUserTutor.setSkillDes(skillDes);
                bUserTutor.setIconUrl(iconUrl);
        bUserTutor.setIdcardBackUrl("/picture/"+idcardBackUrl);
                bUserTutor.setCommitteeId(committeeId);
        bUserTutor.setCreateTime(new Date());

	    return bUserTutorService.saveBUserTutor(bUserTutor);
	}
	
	/**
	 * 根据id查询详情
	 * @param userId
	 * @return
	 */
	@RequestMapping("/getusertutor")
	public Result getById(String userId) {
		if(!StringUtils.isEmpty(userId)) {
            userId = userId.replace("\"", "");
		}
		return bUserTutorService.getBUserTutorById(userId);
	}
	
	/**
	 * 修改
	 * @param bUserTutor
	 * @return
	 */
	@RequestMapping("/update")
	public Result update(@RequestBody MultipartFile imgFile, BUserTutorDTO bUserTutor) {
		BUserTutorEntity b = new BUserTutorEntity();
		BeanUtils.copyProperties(bUserTutor, b);
		return bUserTutorService.updateBUserTutor(imgFile,b);
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@SysLog("删除志愿者导师信息表")
	@RequestMapping("/remove")
	public Result batchRemove(@RequestBody Long[] id) {
		return bUserTutorService.batchRemove(id);
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@RequestMapping("/passApply")
	public Result passApply(@RequestBody String[] id) {
		return bUserTutorService.passApply(id);
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@RequestMapping("/refuseApply")
	public Result refuseApply(@RequestBody String[] id) {
		return bUserTutorService.refuseApply(id);
	}
}
