package cn.cashbang.core.modules.venuesbook.service.impl;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.cashbang.core.common.entity.Page;
import cn.cashbang.core.common.entity.Query;
import cn.cashbang.core.common.entity.Result;
import cn.cashbang.core.common.utils.CommonUtils;
import cn.cashbang.core.modules.venuesbook.entity.BLawInfoEntity;
import cn.cashbang.core.modules.venuesbook.manager.BLawInfoManager;
import cn.cashbang.core.modules.venuesbook.service.BLawInfoService;

/**
 * 法律体检表
 *
 * @author daibangzhu
 * @email xxx@daibangzhu.cn
 * @url www.daibangzhu.cn
 * @date 2021年5月09日 下午3:00:03
 */
@Service("bLawInfoService")
public class BLawInfoServiceImpl implements BLawInfoService {

	@Autowired
	private BLawInfoManager bLawInfoManager;

	@Override
	public Page<BLawInfoEntity> listBLawInfo(Map<String, Object> params) {
		Query query = new Query(params);
		Page<BLawInfoEntity> page = new Page<>(query);
		bLawInfoManager.listBLawInfo(page, query);
		return page;
	}

	@Override
	public Result saveBLawInfo(BLawInfoEntity role) {
		
		BLawInfoEntity ifexist = bLawInfoManager.getBLawInfoByName(role.getLawName());
		if(ifexist != null) {
			return Result.error("该事务所已存在，请换个名称录入");
		}
		role.setLawId(CommonUtils.createUUID());
		role.setCreateTime(new Date());
		role.setUpdateTime(new Date());
		int count = bLawInfoManager.saveBLawInfo(role);
		return CommonUtils.msg(count);
	}

	@Override
	public Result getBLawInfoById(String id) {
		BLawInfoEntity bLawInfo = bLawInfoManager.getBLawInfoById(id);
		return CommonUtils.msg(bLawInfo);
	}

	@Override
	public Result updateBLawInfo(BLawInfoEntity bLawInfo) {
		BLawInfoEntity ifexist = bLawInfoManager.getBLawInfoByName(bLawInfo.getLawName());
		if(ifexist != null && !bLawInfo.getLawId().equalsIgnoreCase(ifexist.getLawId())) {
			return Result.error("该事务所已存在，请换个名称录入");
		}
		bLawInfo.setUpdateTime(new Date());
		int count = bLawInfoManager.updateBLawInfo(bLawInfo);
		return CommonUtils.msg(count);
	}

	@Override
	public Result batchRemove(String[] id) {
		int count = bLawInfoManager.batchRemove(id);
		return CommonUtils.msg(id, count);
	}

}
