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
import cn.cashbang.core.modules.venuesbook.entity.BGoodsInfoEntity;
import cn.cashbang.core.modules.venuesbook.entity.BVenueInfoEntity;
import cn.cashbang.core.modules.venuesbook.manager.BGoodsInfoManager;
import cn.cashbang.core.modules.venuesbook.service.BGoodsInfoService;

/**
 * 
 *
 * @author daibangzhu
 * @email xxx@daibangzhu.cn
 * @url www.daibangzhu.cn
 * @date 2021年3月04日 下午1:11:01
 */
@Service("bGoodsInfoService")
public class BGoodsInfoServiceImpl implements BGoodsInfoService {

	@Autowired
	private BGoodsInfoManager bGoodsInfoManager;

	@Override
	public Page<BGoodsInfoEntity> listBGoodsInfo(Map<String, Object> params) {
		Query query = new Query(params);
		Page<BGoodsInfoEntity> page = new Page<>(query);
		bGoodsInfoManager.listBGoodsInfo(page, query);
		return page;
	}

	@Override
	public Result saveBGoodsInfo(MultipartFile file,BGoodsInfoEntity role) {
		if(role == null) {
			return Result.error("对象为空");
		}
		//先检查场馆名称是已经存在
		BGoodsInfoEntity old = bGoodsInfoManager.getBGoogsInfoByName(role.getGoodsName());
		if(old != null) {
			return Result.error("该商品已存在，请重新命名新产品");
		}
		String uuid = CommonUtils.createUUID();
		role.setGid(uuid);
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
                fileName = uuid.substring(0, 8)+"-"+middle+"."+suffix;
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
		role.setGoodsPicurl("/picture/"+fileName);
		int count = bGoodsInfoManager.saveBGoodsInfo(role);
		return CommonUtils.msg(count);
	}

	@Override
	public Result getBGoodsInfoById(String id) {
		BGoodsInfoEntity bGoodsInfo = bGoodsInfoManager.getBGoodsInfoById(id);
		return CommonUtils.msg(bGoodsInfo);
	}

	@Override
	public Result updateBGoodsInfo(MultipartFile file,BGoodsInfoEntity bGoodsInfo) {
		String uuid = bGoodsInfo.getGid();
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
            bGoodsInfo.setGoodsPicurl("/picture/"+fileName);
        }
		int count = bGoodsInfoManager.updateBGoodsInfo(bGoodsInfo);
		return CommonUtils.msg(count);
	}

	@Override
	public Result batchRemove(String[] id) {
		int count = bGoodsInfoManager.batchRemove(id);
		return CommonUtils.msg(id, count);
	}

}
