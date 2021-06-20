package cn.cashbang.core.modules.venuesbook.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.cashbang.core.common.entity.Page;
import cn.cashbang.core.common.entity.Query;
import cn.cashbang.core.common.entity.Result;
import cn.cashbang.core.common.utils.CommonUtils;
import cn.cashbang.core.modules.venuesbook.entity.BRecruitInfoEntity;
import cn.cashbang.core.modules.venuesbook.manager.BRecruitInfoManager;
import cn.cashbang.core.modules.venuesbook.service.BRecruitInfoService;

/**
 * 招聘信息表
 *
 * @author daibangzhu
 * @email xxx@daibangzhu.cn
 * @url www.daibangzhu.cn
 * @date 2021年5月09日 下午2:54:48
 */
@Service("bRecruitInfoService")
public class BRecruitInfoServiceImpl implements BRecruitInfoService {

	@Autowired
	private BRecruitInfoManager bRecruitInfoManager;

	@Override
	public Page<BRecruitInfoEntity> listBRecruitInfo(Map<String, Object> params) {
		Query query = new Query(params);
		Page<BRecruitInfoEntity> page = new Page<>(query);
		bRecruitInfoManager.listBRecruitInfo(page, query);
		return page;
	}

	@Override
	public Result saveBRecruitInfo(BRecruitInfoEntity role) {
		int count = bRecruitInfoManager.saveBRecruitInfo(role);
		return CommonUtils.msg(count);
	}

	@Override
	public Result getBRecruitInfoById(String id) {
		BRecruitInfoEntity bRecruitInfo = bRecruitInfoManager.getBRecruitInfoById(id);
		return CommonUtils.msg(bRecruitInfo);
	}

	@Override
	public Result updateBRecruitInfo(BRecruitInfoEntity bRecruitInfo) {
		int count = bRecruitInfoManager.updateBRecruitInfo(bRecruitInfo);
		return CommonUtils.msg(count);
	}

	@Override
	public Result batchRemove(String[] id) {
		int count = bRecruitInfoManager.batchRemove(id);
		return CommonUtils.msg(id, count);
	}


    @Override
    public String anQuestion(String  recruitId,String question){
	   String answer ="我暂时无法回答您的问题，请联系管理员！";
	   BRecruitInfoEntity bRecruitInfo = bRecruitInfoManager.getBRecruitInfoById(recruitId);

        if(question.contains("你好")|| question.contains("hi")|| question.contains("在吗") ||question.contains("hello")){

            answer = "您好，有什么可以帮您?";
        }

	   if(question.contains("电话")|| question.contains("手机")|| question.contains("联系") ){

           answer = "您好，联系电话是："+  bRecruitInfo.getPhone();
       }

        if(question.contains("地址")|| question.contains("地方")|| question.contains("哪里") ){

            answer = "您好，公司地址是："+  bRecruitInfo.getAddress();
        }

        if(question.contains("薪水")|| question.contains("待遇")|| question.contains("工资") ){

            answer = "您好，该职位的薪资是："+  bRecruitInfo.getSalary()+"每月";
        }

        if(question.contains("名字")|| question.contains("公司叫什么")|| question.contains("哪个公司") ){

            answer = "您好，我们的公司名字是"+  bRecruitInfo.getCompanyName();
        }
        
	   return  answer;
    }

}
