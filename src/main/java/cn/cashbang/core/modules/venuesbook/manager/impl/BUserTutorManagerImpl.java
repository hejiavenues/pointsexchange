package cn.cashbang.core.modules.venuesbook.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.cashbang.core.common.entity.Page;
import cn.cashbang.core.common.entity.Query;
import cn.cashbang.core.modules.venuesbook.dao.BUserTutorMapper;
import cn.cashbang.core.modules.venuesbook.entity.BUserTutorEntity;
import cn.cashbang.core.modules.venuesbook.manager.BUserTutorManager;

/**
 * 志愿者导师信息表
 *
 * @author daibangzhu
 * @email xxx@daibangzhu.cn
 * @url www.daibangzhu.cn
 * @date 2021年6月15日 下午7:23:45
 */
@Component("bUserTutorManager")
public class BUserTutorManagerImpl implements BUserTutorManager {

	@Autowired
	private BUserTutorMapper bUserTutorMapper;
	

	@Override
	public List<BUserTutorEntity> listBUserTutor(Page<BUserTutorEntity> page, Query search) {
		return bUserTutorMapper.listForPage(page, search);
	}

	@Override
	public int saveBUserTutor(BUserTutorEntity bUserTutor) {
		return bUserTutorMapper.save(bUserTutor);
	}

	@Override
	public BUserTutorEntity getBUserTutorById(String id) {
		BUserTutorEntity bUserTutor = bUserTutorMapper.getObjectById(id);
		return bUserTutor;
	}

	@Override
	public int updateBUserTutor(BUserTutorEntity bUserTutor) {
		return bUserTutorMapper.update(bUserTutor);
	}

	@Override
	public int batchRemove(Long[] id) {
		int count = bUserTutorMapper.batchRemove(id);
		return count;
	}

	@Override
	public int passApply(String[] id) {
		int count = bUserTutorMapper.passApply(id);
		return count;
	}

	@Override
	public int refuseApply(String[] id) {
		int count = bUserTutorMapper.refuseApply(id);
		return count;
	}
	
}
