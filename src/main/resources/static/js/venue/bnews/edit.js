/**
 * 编辑-文章列表信息js
 */
var vm = new Vue({
	el:'#zsvm',
	data: {
		bNews: {
			nid: 0,
			imgFile:null,
		},
		imageUrl: '',
		rules:{//form 规则
		
		    title: [ {  required: true, message: '文章标题', trigger: 'blur' } ], 
		   /* newsImg: [ {  required: true, message: '文章图片', trigger: 'blur' } ], */
		}
			
	},
	methods : {
	   setForm: function() {
			$.SetForm({
				url: '../../venuesbook/bnews/info?_' + $.now(),
		    	param: vm.bNews.nid,
		    	success: function(data) {
		    		vm.bNews = data;
					vm.imageUrl = data.newsImg;
		    	}
			});
		},
		acceptClick: function() {
		
		  this.$refs
		  ["ruleForm"].validate(function(yes,b){
				if(yes){
			 /*$.ConfirmForm({
				    	url: '../../venuesbook/bnews/update?_' + $.now(),
				    	param: vm.bNews,
				    	success: function(data) {
				    		$.currentIframe().vm.load();
				    	}
				    });*/
					zs_postFormA(vm,{
                        url: '../../venuesbook/bnews/update?_' + $.now(),
                        param: vm.bNews,
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
                vm.bNews.imgFile = file;

            });
            return true;
        },
	}
})
