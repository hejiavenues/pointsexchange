/**
 * 编辑-js
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
		    goodsName: [ {  required: true, message: '商品名称', trigger: 'blur' } ], 
		    points: [ {  required: true, message: '所需时长（小时）', trigger: 'blur' } ],
		    price: [ {  required: true, message: '市场价（元）', trigger: 'blur' } ],
            goodsCount: [ {  required: true, message: '库存总数', trigger: 'blur' } ],
            remark: [ {  required: true, message: '描述', trigger: 'blur' } ],
		    goodsStatus: [ {  required: true, message: '上架状态', trigger: 'blur' } ]
		}
			
	},
	methods : {
	   setForm: function() {
			$.SetForm({
				url: '../../venuesbook/goods/info?_' + $.now(),
		    	param: vm.bGoodsInfo.gid,
		    	success: function(data) {
		    		vm.bGoodsInfo = data;
					vm.imageUrl = data.goodsPicurl;
					if(data.goodsStatus == 1){
                        vm.bGoodsInfo.goodsStatus = '上架';
                    }else if(data.goodsStatus == 2){
                        vm.bGoodsInfo.goodsStatus = '下架';
                    };
		    	}
			});
		},
		acceptClick: function() {
		
		  this.$refs
		  ["ruleForm"].validate(function(yes,b){
				if(yes){
			 /*$.ConfirmForm({
				    	url: '../../venuesbook/goods/update?_' + $.now(),
				    	param: vm.bGoodsInfo,
				    	success: function(data) {
				    		$.currentIframe().vm.load();
				    	}
				    });*/
				if(vm.bGoodsInfo.goodsStatus == '上架'){
                        vm.bGoodsInfo.goodsStatus = 1;
                    }else if(vm.bGoodsInfo.goodsStatus == '下架'){
                        vm.bGoodsInfo.goodsStatus = 2;
                    }
				zs_postFormA(vm,{
                        url: '../../venuesbook/goods/update?_' + $.now(),
                        param: vm.bGoodsInfo,
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
                vm.bGoodsInfo.imgFile = file;

            });
            return true;
        },
	}
})
