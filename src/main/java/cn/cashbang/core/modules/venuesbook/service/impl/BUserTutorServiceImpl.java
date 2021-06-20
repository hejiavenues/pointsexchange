package cn.cashbang.core.modules.venuesbook.service.impl;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import cn.cashbang.core.common.entity.Page;
import cn.cashbang.core.common.entity.Query;
import cn.cashbang.core.common.entity.Result;
import cn.cashbang.core.common.utils.CommonUtils;
import cn.cashbang.core.common.utils.SpringContextUtils;
import cn.cashbang.core.modules.venuesbook.entity.BUserTutorEntity;
import cn.cashbang.core.modules.venuesbook.manager.BUserTutorManager;
import cn.cashbang.core.modules.venuesbook.service.BUserTutorService;

/**
 * 志愿者导师信息表
 *
 * @author daibangzhu
 * @email xxx@daibangzhu.cn
 * @url www.daibangzhu.cn
 * @date 2021年6月15日 下午7:23:45
 */
@Service("bUserTutorService")
public class BUserTutorServiceImpl implements BUserTutorService {

	@Autowired
	private BUserTutorManager bUserTutorManager;

	@Override
	public Page<BUserTutorEntity> listBUserTutor(Map<String, Object> params) {
		Query query = new Query(params);
		Page<BUserTutorEntity> page = new Page<>(query);
		bUserTutorManager.listBUserTutor(page, query);
		return page;
	}

	@Override
	public Result saveBUserTutor(BUserTutorEntity role) {
		int count = bUserTutorManager.saveBUserTutor(role);
		return CommonUtils.msg(count);
	}

	@Override
	public Result getBUserTutorById(String id) {
		BUserTutorEntity bUserTutor = bUserTutorManager.getBUserTutorById(id);
		if(bUserTutor==null){
            return CommonUtils.msg("");
        }
		return CommonUtils.msg(bUserTutor);
	}

	@Override
	public Result updateBUserTutor(MultipartFile file,BUserTutorEntity bUserTutor) {
		/*String uuid = bUserTutor.getUid().substring(0, bUserTutor.getUid().length() - 2);
		String fileName = "";
		if(file != null){
            //取得当前上传文件的文件名称  
            String myFileName = file.getOriginalFilename();
            System.out.println("----"+file.getName());
            String suffix = myFileName.substring(myFileName.lastIndexOf(".") + 1);
            String middle = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss_SSS").format(new Date());
            //如果名称不为“”,说明该文件存在，否则说明该文件不存在  
            String uploadUrl = SpringContextUtils.getApplicationProperties().getUploadInfo().get("venuesimageurl");
            if(myFileName.trim() !=""){  
                //重命名上传后的文件名  
                fileName = uuid+"-"+middle+"."+suffix;
                File dirPath = new File(uploadUrl);
                if(!dirPath.exists()){
                	dirPath.mkdirs();
                }
        		
                //定义上传路径  
                String path = dirPath + File.separator + fileName;
                File localFile = new File(path);
                try {
					file.transferTo(localFile);
                } catch (IllegalStateException|IOException e) {
					e.printStackTrace();
					return Result.error("导入图片失败");
				}  
            }
            bUserTutor.setIconUrl("/picture/"+fileName);
        }*/
		bUserTutor.setUpdateTime(new Date());
		int count = bUserTutorManager.updateBUserTutor(bUserTutor);
		return CommonUtils.msg(count);
	}

	@Override
	public Result batchRemove(Long[] id) {
		int count = bUserTutorManager.batchRemove(id);
		return CommonUtils.msg(id, count);
	}

	@Override
	public Result passApply(String[] id) {
		int count = bUserTutorManager.passApply(id);
		return CommonUtils.msg(id, count);
	}

	@Override
	public Result refuseApply(String[] id) {
		int count = bUserTutorManager.refuseApply(id);
		return CommonUtils.msg(id, count);
	}

}
