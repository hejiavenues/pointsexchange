/**
 * 新增-js
 */
var vm = new Vue({
	el:'#zsvm',
	data: {
		bGoodsInfo: {
			gid: 0,
			imgFile: null,
		},
		imageUrl: '',
		rules:{//form 规则
		
			    gid: [ {  required: true, message: '主键ID', trigger: 'blur' } ], 
		    goodsName: [ {  required: true, message: '商品名称', trigger: 'blur' } ], 
		    points: [ {  required: true, message: '请输入整数数字', trigger: 'blur' } ], 
		    price: [ {  required: true, message: '请输入最多两位小数的数字', trigger: 'blur' } ], 
		    goodsStatus: [ {  required: true, message: '请选择是否上架', trigger: 'blur' } ], 
		    createTime: [ {  required: true, message: '上架时间（创建时间）', trigger: 'blur' } ], 
		    updateTime: [ {  required: true, message: '更新时间', trigger: 'blur' } ]
			
		}
	},
	methods : {
		acceptClick: function() {
		  this.$refs
		  ["ruleForm"].validate(function(yes,b){
				if(yes){
					 /*$.SaveForm({
				    	url: '../../venuesbook/goods/save?_' + $.now(),
				    	param: vm.bGoodsInfo,
				    	success: function(data) {
				    		$.currentIframe().vm.load();
				    	}
				    });*/
					zs_postFormA(vm,{
                        url: '../../venuesbook/goods/save?_' + $.now(),
                        param: vm.bGoodsInfo,
                        success: function(data) {
                            vm.$message.success('添加成功');
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
                vm.bGoodsInfo.imgFile = file;

            });
            return true;
        },
	}
})
