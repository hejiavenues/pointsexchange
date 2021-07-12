package cn.cashbang.core.modules.venuesbook.service.impl;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import cn.cashbang.core.common.entity.Page;
import cn.cashbang.core.common.entity.Query;
import cn.cashbang.core.common.entity.Result;
import cn.cashbang.core.common.utils.CommonUtils;
import cn.cashbang.core.common.utils.SpringContextUtils;
import cn.cashbang.core.modules.venuesbook.entity.BCoopCompanyEntity;
import cn.cashbang.core.modules.venuesbook.entity.BCoopCompanyEntityDto;
import cn.cashbang.core.modules.venuesbook.entity.BNewsEntity;
import cn.cashbang.core.modules.venuesbook.manager.BCoopCompanyManager;
import cn.cashbang.core.modules.venuesbook.service.BCoopCompanyService;

/**
 * 合作企业列表信息
 *
 * @author daibangzhu
 * @email xxx@daibangzhu.cn
 * @url www.daibangzhu.cn
 * @date 2021年7月12日 下午7:57:27
 */
@Service("bCoopCompanyService")
public class BCoopCompanyServiceImpl implements BCoopCompanyService {

	@Autowired
	private BCoopCompanyManager bCoopCompanyManager;

	@Override
	public Page<BCoopCompanyEntity> listBCoopCompany(Map<String, Object> params) {
		Query query = new Query(params);
		Page<BCoopCompanyEntity> page = new Page<>(query);
		bCoopCompanyManager.listBCoopCompany(page, query);
		return page;
	}

	@Override
	public Result saveBCoopCompany(MultipartFile file,BCoopCompanyEntity role) {
		if(role == null) {
			return Result.error("对象为空");
		}
		String uuid = CommonUtils.createUUID();
		role.setCid(uuid);
		String fileName = "";
		if(file != null){
            //取得当前上传文件的文件名称  
            String myFileName = file.getOriginalFilename();
            System.out.println("----"+file.getName());
            String suffix = myFileName.substring(myFileName.lastIndexOf(".") + 1);
            String middle = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss_SSS").format(new Date());
            //如果名称不为“”,说明该文件存在，否则说明该文件不存在  
            String uploadUrl = SpringContextUtils.getApplicationProperties().getUploadInfo().get("imageurl");
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
        }
		role.setCreateTime(new Date());
		role.setUpdateTime(new Date());
		role.setCompanyLogo("/picture/"+fileName);
		int count = bCoopCompanyManager.saveBCoopCompany(role);
		return CommonUtils.msg(count);
	}

	@Override
	public Result getBCoopCompanyById(String id) {
		BCoopCompanyEntity bCoopCompany = bCoopCompanyManager.getBCoopCompanyById(id);
		return CommonUtils.msg(bCoopCompany);
	}

	@Override
	public Result updateBCoopCompany(MultipartFile file,BCoopCompanyEntityDto bCoopCompany) {
		String uuid = bCoopCompany.getCid();
		String fileName = "";
		if(file != null){
            //取得当前上传文件的文件名称  
            String myFileName = file.getOriginalFilename();
            System.out.println("----"+file.getName());
            String suffix = myFileName.substring(myFileName.lastIndexOf(".") + 1);
            String middle = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss_SSS").format(new Date());
            //如果名称不为“”,说明该文件存在，否则说明该文件不存在  
            String uploadUrl = SpringContextUtils.getApplicationProperties().getUploadInfo().get("imageurl");
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
            bCoopCompany.setCompanyLogo("/picture/"+fileName);
        }
		BCoopCompanyEntity b = new BCoopCompanyEntity();
		BeanUtils.copyProperties(bCoopCompany, b);
		b.setUpdateTime(new Date());
		int count = bCoopCompanyManager.updateBCoopCompany(b);
		return CommonUtils.msg(count);
	}

	@Override
	public Result batchRemove(String[] id) {
		int count = bCoopCompanyManager.batchRemove(id);
		return CommonUtils.msg(id, count);
	}

}
