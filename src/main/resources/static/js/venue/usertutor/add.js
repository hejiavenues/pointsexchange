/**
 * 新增-志愿者导师信息表js
 */
var vm = new Vue({
	el:'#zsvm',
	data: {
		bUserTutor: {
			uid: 0
		},
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
	methods : {
		acceptClick: function() {
		  this.$refs
		  ["ruleForm"].validate(function(yes,b){
				if(yes){
					 $.SaveForm({
				    	url: '../../venuesbook/usertutor/save?_' + $.now(),
				    	param: vm.bUserTutor,
				    	success: function(data) {
				    		$.currentIframe().vm.load();
				    	}
				    });
				}else{
					 return false;
				}
				 
			 });
		}
	}
})
