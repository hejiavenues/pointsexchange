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
import cn.cashbang.core.modules.venuesbook.entity.BBannerInfoEntity;
import cn.cashbang.core.modules.venuesbook.entity.BNewsEntity;
import cn.cashbang.core.modules.venuesbook.entity.BNewsEntityDto;
import cn.cashbang.core.modules.venuesbook.manager.BNewsManager;
import cn.cashbang.core.modules.venuesbook.service.BNewsService;

/**
 * 文章列表信息
 *
 * @author daibangzhu
 * @email xxx@daibangzhu.cn
 * @url www.daibangzhu.cn
 * @date 2021年7月12日 下午7:56:51
 */
@Service("bNewsService")
public class BNewsServiceImpl implements BNewsService {

	@Autowired
	private BNewsManager bNewsManager;

	@Override
	public Page<BNewsEntity> listBNews(Map<String, Object> params) {
		Query query = new Query(params);
		Page<BNewsEntity> page = new Page<>(query);
		bNewsManager.listBNews(page, query);
		return page;
	}

	@Override
	public Result saveBNews(MultipartFile file,BNewsEntity role) {
		if(role == null) {
			return Result.error("对象为空");
		}
		String uuid = CommonUtils.createUUID();
		role.setNid(uuid);
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
		role.setNewsImg("/picture/"+fileName);
		int count = bNewsManager.saveBNews(role);
		return CommonUtils.msg(count);
	}

	@Override
	public Result getBNewsById(String id) {
		BNewsEntity bNews = bNewsManager.getBNewsById(id);
		return CommonUtils.msg(bNews);
	}

	@Override
	public Result updateBNews(MultipartFile file, BNewsEntityDto bNews) {
		String uuid = bNews.getNid();
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
            bNews.setNewsImg("/picture/"+fileName);
        }
		BNewsEntity b = new BNewsEntity();
		BeanUtils.copyProperties(bNews, b);
		b.setUpdateTime(new Date());
		int count = bNewsManager.updateBNews(b);
		return CommonUtils.msg(count);
	}

	@Override
	public Result batchRemove(String[] id) {
		int count = bNewsManager.batchRemove(id);
		return CommonUtils.msg(id, count);
	}

}
