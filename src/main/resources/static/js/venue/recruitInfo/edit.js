/**
 * 编辑-招聘信息表js
 */
var vm = new Vue({
	el:'#zsvm',
	data: {
		bRecruitInfo: {
			recruitId: 0
		},
		rules:{//form 规则
		
			    recruitId: [ {  required: true, message: '', trigger: 'blur' } ], 
		    userId: [ {  required: true, message: '所属企业用户Id', trigger: 'blur' } ], 
		    hrName: [ {  required: true, message: '招聘人称呼', trigger: 'blur' } ], 
		    phone: [ {  required: true, message: '招聘人联系方式', trigger: 'blur' } ], 
		    jobName: [ {  required: true, message: '岗位名称', trigger: 'blur' } ], 
		    salary: [ {  required: true, message: '薪资待遇', trigger: 'blur' } ], 
		    remark: [ {  required: true, message: '岗位描述描述', trigger: 'blur' } ], 
		    recruitNumber: [ {  required: true, message: '招聘人数', trigger: 'blur' } ], 
		    createTime: [ {  required: true, message: '', trigger: 'blur' } ], 
		    updateTime: [ {  required: true, message: '', trigger: 'blur' } ]
			
		}
			
	},
	methods : {
	   setForm: function() {
			$.SetForm({
				url: '../../venuesbook/recruitInfo/info?_' + $.now(),
		    	param: vm.bRecruitInfo.recruitId,
		    	success: function(data) {
		    		vm.bRecruitInfo = data;
		    	}
			});
		},
		acceptClick: function() {
		
		  this.$refs
		  ["ruleForm"].validate(function(yes,b){
				if(yes){
			 $.ConfirmForm({
				    	url: '../../venuesbook/recruitInfo/update?_' + $.now(),
				    	param: vm.bRecruitInfo,
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
