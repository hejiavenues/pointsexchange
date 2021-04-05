package cn.cashbang.core.modules.venuesbook.service.impl;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import cn.cashbang.core.common.utils.QRCodeUtils;
import cn.cashbang.core.common.utils.StringUtils;
import cn.cashbang.core.modules.venuesbook.entity.BVenueBookEntity;
import cn.cashbang.core.modules.venuesbook.manager.BVenueBookManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import cn.cashbang.core.common.entity.Page;
import cn.cashbang.core.common.entity.Query;
import cn.cashbang.core.common.entity.Result;
import cn.cashbang.core.common.utils.CommonUtils;
import cn.cashbang.core.common.utils.SpringContextUtils;
import cn.cashbang.core.modules.venuesbook.entity.BCommunityActivitiesEntity;
import cn.cashbang.core.modules.venuesbook.manager.BCommunityActivitiesManager;
import cn.cashbang.core.modules.venuesbook.service.BCommunityActivitiesService;

/**
 * 社区活动信息表
 *
 * @author daibangzhu
 * @email xxx@daibangzhu.cn
 * @url www.daibangzhu.cn
 * @date 2021年2月27日 PM9:46:01
 */
@Service("bCommunityActivitiesService")
public class BCommunityActivitiesServiceImpl implements BCommunityActivitiesService {

	@Autowired
	private BCommunityActivitiesManager bCommunityActivitiesManager;

    @Autowired
    private BVenueBookManager bVenueBookManager;

	@Override
	public Page<BCommunityActivitiesEntity> listBCommunityActivities(Map<String, Object> params) {
		Query query = new Query(params);
		Page<BCommunityActivitiesEntity> page = new Page<>(query);
		bCommunityActivitiesManager.listBCommunityActivities(page, query);
		return page;
	}

	@Override
	public Result saveBCommunityActivities(MultipartFile file,BCommunityActivitiesEntity role) {
		if(role == null) {
			return Result.error("对象为空");
		}
		String uuid = CommonUtils.createUUID();
		role.setComActivityId(uuid);
		String fileName = "";
        String uploadUrl = SpringContextUtils.getApplicationProperties().getUploadInfo().get("imageurl");
		if(file != null){
            //取得当前上传文件的文件名称  
            String myFileName = file.getOriginalFilename();
            System.out.println("----"+file.getName());
            String suffix = myFileName.substring(myFileName.lastIndexOf(".") + 1);
            String middle = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss_SSS").format(new Date());
            //如果名称不为“”,说明该文件存在，否则说明该文件不存在  

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
        else {
            fileName = role.getPicUrl();
        }
		role.setCreateTime(new Date());
		role.setUpdateTime(new Date());
		role.setPicUrl("/picture/"+fileName);
		role.setActivityTime(role.getBookDate()+" "+role.getBookTime());

       if(StringUtils.isNotBlank(role.getVenueId())) {

           // 生成一条预约记录
           BVenueBookEntity bVenueBook = new BVenueBookEntity();
           bVenueBook.setBookStatus(2); // 已预约
           bVenueBook.setBookTime(role.getBookTime());
           bVenueBook.setBookDate(role.getBookDate());
           bVenueBook.setUserId(role.getUid());
           bVenueBook.setVenueId(role.getVenueId());
           bVenueBook.setActivityId(role.getComActivityId());
           bVenueBook.setActivityContent(role.getActivityContent());
           String uuid2 = CommonUtils.createUUID();
           bVenueBook.setId(uuid2);
           bVenueBook.setCreateTime(new Date());
           int r1= bVenueBookManager.saveBVenueBook(bVenueBook);
       }

        try {
            // 生成活动二维码
            String text = "activityId="+role.getComActivityId();  //这里设置自定义网站url或文字
           // String logoPath = uploadUrl +"1.jpg"; //二维码图片
            String destPath = uploadUrl;		//保存地址
            //调用工具类
           String name = QRCodeUtils.encode(text, null, destPath, true,role.getComActivityId());
            System.out.println("二维码图片名称："+name);
            role.setQrcode("/picture/"+name);
        } catch (Exception e) {
            e.printStackTrace();
        }

        int count = bCommunityActivitiesManager.saveBCommunityActivities(role);
		return CommonUtils.msg(count);
	}

	@Override
	public Result getBCommunityActivitiesById(String id) {
		BCommunityActivitiesEntity bCommunityActivities = bCommunityActivitiesManager.getBCommunityActivitiesById(id);
		return CommonUtils.msg(bCommunityActivities);
	}

	@Override
	public Result updateBCommunityActivities(MultipartFile file,BCommunityActivitiesEntity bCommunityActivities) {
		String uuid = bCommunityActivities.getComActivityId();
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
            bCommunityActivities.setPicUrl("/picture/"+fileName);
        }
		int count = bCommunityActivitiesManager.updateBCommunityActivities(bCommunityActivities);
		return CommonUtils.msg(count);
	}

	@Override
	public Result batchRemove(String[] id) {
		int count = bCommunityActivitiesManager.batchRemove(id);
		return CommonUtils.msg(id, count);
	}

    @Override
    public Result listActByUserId(String uid){
        List<BCommunityActivitiesEntity> list = bCommunityActivitiesManager.listActByUserId(uid);
        return  Result.ok().put("raws", list);
    }
    
    @Override
    public Result listByCreateUser(String uid){
        List<BCommunityActivitiesEntity> list = bCommunityActivitiesManager.listByCreateUser(uid);
        return  Result.ok().put("raws", list);
    }
}
