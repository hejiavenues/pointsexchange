/**
 * 编辑-社区活动信息表js
 */
var vm = new Vue({
	el:'#zsvm',
	data: {
		bCommunityActivities: {
			comActivityId: 0,
			imgFile: null,
		},
		imageUrl: '',
        avaTimes:[],
        venueinfos: [],
		rules:{//form 规则

		    activityName: [ {  required: true, message: '活动名称', trigger: 'blur' } ], 
		    activityCount: [ {  required: true, message: '活动人数', trigger: 'blur' } ], 
		    activityType: [ {  required: true, message: '活动类型', trigger: 'blur' } ], 
		    activityContent: [ {  required: true, message: '活动内容', trigger: 'blur' } ], 
		    activityTime: [ {  required: true, message: '活动时段', trigger: 'blur' } ]
			
		},
        pickerOptions1: {
            disabledDate (time) {
                return time.getTime() < (Date.now()-8.64e7);
            }
        }
			
	},
    created:function(){
        this.getAllTimes();
        this.getVenueinfo();
    },
	methods : {
	   setForm: function() {
			$.SetForm({
				url: '../../venuesbook/comactivity/info?_' + $.now(),
		    	param: vm.bCommunityActivities.comActivityId,
		    	success: function(data) {
		    		vm.bCommunityActivities = data;
					vm.imageUrl = data.picUrl;
		    	}
			});
		},
        getAllTimes:function(){
            var th=this;
            zs_post({
                url:'../../venuesbook/dic/getDicsByCode?typeCode=avaTime',
                success:function(r){
                    th.avaTimes=r.bDics;
                }
            })
        },
        getVenueinfo:function(){
            var th=this;
            zs_post({
                url:'../../venuesbook/venueinfo/list?_' + $.now(),
                success:function(r){
                    th.venueinfos=r.rows;
                }
            })
        },
		acceptClick: function() {
		
		  this.$refs
		  ["ruleForm"].validate(function(yes,b){
				if(yes){
			 /*$.ConfirmForm({
				    	url: '../../venuesbook/update?_' + $.now(),
				    	param: vm.bCommunityActivities,
				    	success: function(data) {
				    		$.currentIframe().vm.load();
				    	}
				    });*/
				zs_postFormA(vm,{
                        url: '../../venuesbook/comactivity/update?_' + $.now(),
                        param: vm.bCommunityActivities,
                        success: function(data) {
                            vm.$message.success('修改成功');
                            $.currentIframe().vm.load();
                            setTimeout(function() {
                                dialogClose();
                            }, 1000);
                        }
                    });
				}else{
					 return false;
				}
				 
			 });
		},
		handleAvatarSuccess(res, file) {
            this.imageUrl = URL.createObjectURL(file.raw);
        },
        beforeAvatarUpload(file) {
            //var isJPG = file.type === 'image/jpeg';
            var allowTypes = ['image/jpg','image/jpeg','image/png'];
            var isLt2M = file.size / 1024 / 1024 < 2;

            if (allowTypes.indexOf(file.type) === -1) {
                this.$message.error('上传图片仅支持jpg、png格式!');
            }
            if (!isLt2M) {
                this.$message.error('上传图片大小不能超过 2MB!');
            }

            // 压缩图片
            getSmallerFile(file,0.5,2048,function (base64Code,file) {
                vm.bCommunityActivities.imgFile = file;

            });
            return true;
        },
	}
})
