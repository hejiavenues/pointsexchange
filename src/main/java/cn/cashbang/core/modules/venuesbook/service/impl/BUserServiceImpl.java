package cn.cashbang.core.modules.venuesbook.service.impl;

import cn.cashbang.core.common.entity.Page;
import cn.cashbang.core.common.entity.Query;
import cn.cashbang.core.common.entity.Result;
import cn.cashbang.core.common.utils.CommonUtils;
import cn.cashbang.core.common.utils.HttpClientUtils;
import cn.cashbang.core.common.utils.StringUtils;
import cn.cashbang.core.common.utils.WebUtils;
import cn.cashbang.core.modules.venuesbook.entity.*;
import cn.cashbang.core.modules.venuesbook.manager.*;
import cn.cashbang.core.modules.venuesbook.service.BUserService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 用户信息表
 *
 * @author daibangzhu
 * @email xxx@daibangzhu.cn
 * @url www.daibangzhu.cn
 * @date 2020年12月22日 下午1:13:02
 */
@Service("bUserService")
public class BUserServiceImpl implements BUserService {

	@Autowired
	private BUserManager bUserManager;

	@Autowired
	private BConvenerInfoManager bConvenerInfoManager;

    @Autowired
    private BAccessTokenManager bAccessTokenManager;

    @Autowired
    private BCommunityActivitiesManager bCommunityActivitiesManager;

    @Autowired
    private BExchangeRecordManager bExchangeRecordManager;

	@Override
	public Page<BUserEntity> listBUser(Map<String, Object> params) {
		Query query = new Query(params);
		Page<BUserEntity> page = new Page<>(query);
		bUserManager.listBUser(page, query);
		return page;
	}

	@Override
	public Result saveBUser(BUserEntity role) {
	    
        int count = 0;
        BAccessTokenEntity token = bAccessTokenManager.getBAccessTokenById(1L);
        String content = role.getUname();
        String code = WebUtils.msgCheck(token.getAccessToken(),content);
        System.out.println("content"+content);
        if("40001".equals(code)||"42001".equals(code)){
            String tokenString = WebUtils.getAccessToken();
            if(StringUtils.isNotBlank(tokenString)){

                BAccessTokenEntity bAccessToken = new BAccessTokenEntity();
                bAccessToken.setId(1);
                bAccessToken.setAccessToken(tokenString);
                bAccessTokenManager.updateBAccessToken(bAccessToken);
            }
            code = WebUtils.msgCheck(tokenString,content);
        }
        if("0".equals(code)){

            count = bUserManager.saveBUser(role);
        }
        else {
            return Result.error("上传的信息中含有敏感内容，请修改后再上传。");
        }
		//int count = bUserManager.saveBUser(role);
		return CommonUtils.msg(count);
	}

	@Override
	public Result getBUserById(String id) {
		BUserEntity bUser = bUserManager.getBUserById(id);
		BConvenerInfoEntity con = bConvenerInfoManager.getBConvenerInfoById(id);
		if(con!=null) {
			if(con.getStatus()==0){
				bUser.setUserRole(0);  // 召集人审核中状态
			}
		}
		return CommonUtils.msg(bUser);
	}

	@Override
	public Result updateBUser(BUserEntity bUser) {
		int count = bUserManager.updateBUser(bUser);
		return CommonUtils.msg(count);
	}

	@Override
	public Result batchRemove(String[] id) {
		int count = bUserManager.batchRemove(id);
		return CommonUtils.msg(id, count);
	}

	@Override
	public Result loginUser(String code){

//		// 静波的小程序
//		String appId="wx3a6796d91e05c5bf";
//		String appSecret="dbf8c4107af70b407c9230705a4b126f";

		// 金顶街的小程序
		String appId="wxddad91318561f741";
		String appSecret="ab18ee8a424ec47c88e2f31f6ec478d6";

		String requestUrl = "https://api.weixin.qq.com/sns/jscode2session?grant_type=authorization_code&appid="
				+ appId + "&secret=" + appSecret + "&js_code=" + code;
		//HttpClientUtils.HttpPostParams httpPostParams = HttpClientUtils.createHttpPostParams(requestUrl);
		String res = HttpClientUtils.doGet1(requestUrl);

		JSONObject jsonObject = JSONObject.parseObject(res);
		Object resO = jsonObject.get("openid") == null ? jsonObject.get("openId") : jsonObject.get("openid");
		String openId = "";
		if(resO!=null){
			openId = resO.toString();

			// 根据openId查询用户是否存在
			BUserEntity bUser = bUserManager.getUserByOpenId(openId);

			if(bUser==null) {

				bUser = new  BUserEntity();
				bUser.setOpenId(openId);
			}

			BConvenerInfoEntity con = bConvenerInfoManager.getBConvenerInfoById(bUser.getUid());
			if(con!=null) {
				if(con.getStatus()==0){
					bUser.setUserRole(0);  // 召集人审核中状态
				}
			}

//			bUserManager.updateBUser(bUser);

			return Result.ok().put("raws", bUser);
		}
		else {
			return Result.error("登录失败");
		}
	}

    @Override
    public Result getUserCount(String userId){

        BUserEntity bUser = bUserManager.getBUserById(userId);

        List<BCommunityActivitiesEntity> actList = bCommunityActivitiesManager.listActByUserId(userId);

        Map<String, Object> params = new HashMap<>();
        params.put("pageNumber",1);
        params.put("pageSize",1000);
        params.put("sortOrde","asc");
        params.put("userId",userId);
        Query query = new Query(params);
        Page<BExchangeRecordEntity> page = new Page<>(query);
        List<BExchangeRecordEntity>  exList = bExchangeRecordManager.listBExchangeRecord(page, query);

        Map<String, Object> counts = new HashMap<>();
        counts.put("points",bUser.getPoints().toString());
        counts.put("actCount",actList.size());
        counts.put("exCount",exList.size());

        return Result.ok().put("raws", counts);
    }
}
