/**
 * 编辑-志愿者导师信息表js
 */
var vm = new Vue({
	el:'#zsvm',
	data: {
		bUserTutor: {
			uid: 0
		},
		committees:[],
		rules:{//form 规则
			uid: [ {  required: true, message: '', trigger: 'blur' } ], 
		    uname: [ {  required: true, message: '用户名称', trigger: 'blur' } ], 
		    sex: [ {  required: true, message: '用户性别（1.男 0.女）', trigger: 'blur' } ], 
		    mobile: [ {  required: true, message: '手机号', trigger: 'blur' } ], 
		    skill: [ {  required: true, message: '个人特长', trigger: 'blur' } ], 
		    skillDes: [ {  required: true, message: '特长说明', trigger: 'blur' } ], 
		    iconUrl: [ {  required: true, message: '头像地址', trigger: 'blur' } ], 
		    idcardBackUrl: [ {  required: true, message: '导师宣传图', trigger: 'blur' } ], 
		    committeeId: [ {  required: true, message: '居委会id', trigger: 'blur' } ], 
		    status: [ {  required: true, message: '状态 0.审核中 1.审核通过 2.审核拒绝', trigger: 'blur' } ], 
		    createTime: [ {  required: true, message: '创建时间', trigger: 'blur' } ], 
		    updateTime: [ {  required: true, message: '更新时间', trigger: 'blur' } ]
			
		}
			
	},
	created:function(){
		this.getAllUser();
	},
	methods : {
	   setForm: function() {
			$.SetForm({
				url: '../../venuesbook/usertutor/info?_' + $.now(),
		    	param: vm.bUserTutor.uid,
		    	success: function(data) {
		    		vm.bUserTutor = data;
					if(data.sex == 0){
                        vm.bUserTutor.sex = '女';
                    }else if(data.status == 1){
                        vm.bUserTutor.sex = '男';
                    };
		    	}
			});
		},
		acceptClick: function() {
		
		  this.$refs
		  ["ruleForm"].validate(function(yes,b){
				if(vm.bUserTutor.sex == '女'){
                        vm.bUserTutor.sex = 0;
                    }else if(vm.bUserTutor.sex == '男'){
                        vm.bUserTutor.sex = 1;
                    };
				if(yes){
			 /*$.ConfirmForm({
				    	url: '../../venuesbook/usertutor/update?_' + $.now(),
				    	param: vm.bUserTutor,
				    	success: function(data) {
				    		$.currentIframe().vm.load();
				    	}
				    });*/
				zs_postFormA(vm,{
                        url: '../../venuesbook/usertutor/update?_' + $.now(),
                        param: vm.bUserTutor,
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
		getAllUser:function(){
			var th=this;
		    zs_post({
		    	url:'../../venuesbook/committee/list?_' + $.now(),
		    	success:function(r){
		    		th.committees=r.rows;
		    	}
		    })
		},
	}
})
