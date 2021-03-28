package cn.cashbang.core.modules.venuesbook.controller;

import cn.cashbang.core.common.annotation.SysLog;
import cn.cashbang.core.common.entity.Page;
import cn.cashbang.core.common.entity.Result;
import cn.cashbang.core.modules.sys.controller.AbstractController;
import cn.cashbang.core.modules.venuesbook.entity.*;
import cn.cashbang.core.modules.venuesbook.service.BExchangeRecordService;
import cn.cashbang.core.modules.venuesbook.service.BGoodsInfoService;
import cn.cashbang.core.modules.venuesbook.service.BPointsRecordService;
import com.alibaba.druid.util.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 *
 * @author daibangzhu
 * @email xxx@daibangzhu.cn
 * @url www.daibangzhu.cn
 * @date 2021年3月04日 下午1:11:01
 */
@RestController
@RequestMapping("/api/goods")
public class ApiBGoodsInfoController extends AbstractController {
	
	@Autowired
	private BGoodsInfoService bGoodsInfoService;

    @Autowired
    private BExchangeRecordService bExchangeRecordService;

    @Autowired
    private BPointsRecordService bPointsRecordService;

    /**
     * 用户积分记录列表
     * @param uid
     * @return
     */
    @RequestMapping("/getPointsList")
    public Map<String, Object> list(int page,String uid) {

        Map<String, Object> params = new HashMap<>();
        Map<String, Object> result = new HashMap<>();

        params.put("pageNumber",page);
        params.put("pageSize",10);
        params.put("sortOrde","asc");
        //params.put("gdname",queryGName);
        params.put("uid",uid);

        Page<BPointsRecordEntity> list =  bPointsRecordService.listBPointsRecord(params);
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
     * 查询客户兑换商品列表
     * @param queryGName
     * @return
     */
    @RequestMapping("/listExRecords")
    public Map<String, Object> list(int page,String queryGName,String uid) {
        //return bExchangeRecordService.listBExchangeRecord(params);

        Map<String, Object> params = new HashMap<>();
        Map<String, Object> result = new HashMap<>();

        params.put("pageNumber",page);
        params.put("pageSize",10);
        params.put("sortOrde","asc");
        params.put("gdname",queryGName);
        params.put("userId",uid);

        Page<BExchangeRecordEntity> list =  bExchangeRecordService.listBExchangeRecord(params);
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
	 * @param queryGName
	 * @return
	 */
	@RequestMapping("/getGoodsList")
	public Map<String, Object> getGoodsList(int page,String queryGName) {

        Map<String, Object> params = new HashMap<>();
        Map<String, Object> result = new HashMap<>();

        params.put("pageNumber",page);
        params.put("pageSize",10);
        params.put("sortOrde","asc");
        params.put("goodsName",queryGName);
        params.put("goodsStatus",1);  // 1，上架 2 下架

        Page<BGoodsInfoEntity> list =  bGoodsInfoService.listBGoodsInfo(params);
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
     * 新增
     * @param point
     * @return
     */
    @SysLog("新增积分兑换记录表")
    @RequestMapping("/saveExRecord")
    public Result save(String gid,String uid,String point) {
        BExchangeRecordEntity bExchangeRecord = new BExchangeRecordEntity();
        bExchangeRecord.setGid(gid);
        bExchangeRecord.setUid(uid);
        bExchangeRecord.setPoints(point);
        bExchangeRecord.setExStatus(1);
        return bExchangeRecordService.saveBExchangeRecord(bExchangeRecord);
    }

    /**
     * 新增
     * @param exId
     * @return
     */
    @RequestMapping("/updateExRecordStatus")
    public Result updateExRecordStatus(String exId) {

        BExchangeRecordEntity bExchangeRecord = new BExchangeRecordEntity();
        bExchangeRecord.setId(exId);
        bExchangeRecord.setExStatus(2);
        return bExchangeRecordService.updateBExchangeRecord(bExchangeRecord);
    }
}
