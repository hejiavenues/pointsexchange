/**
 * 编辑-合作企业列表信息js
 */
var vm = new Vue({
	el:'#zsvm',
	data: {
		bCoopCompany: {
			cid: 0
		},
		rules:{//form 规则
		
			    cid: [ {  required: true, message: '主键', trigger: 'blur' } ], 
		    companyLogo: [ {  required: true, message: '公司图标', trigger: 'blur' } ], 
		    companyName: [ {  required: true, message: '公司名字', trigger: 'blur' } ], 
		    isuse: [ {  required: true, message: '是否可用（1.可用 0.不可用）', trigger: 'blur' } ], 
		    createTime: [ {  required: true, message: '', trigger: 'blur' } ], 
		    updateTime: [ {  required: true, message: '', trigger: 'blur' } ]
			
		}
			
	},
	methods : {
	   setForm: function() {
			$.SetForm({
				url: '../../venuesbook/coopcompany/info?_' + $.now(),
		    	param: vm.bCoopCompany.cid,
		    	success: function(data) {
		    		vm.bCoopCompany = data;
		    	}
			});
		},
		acceptClick: function() {
		
		  this.$refs
		  ["ruleForm"].validate(function(yes,b){
				if(yes){
			 $.ConfirmForm({
				    	url: '../../venuesbook/coopcompany/update?_' + $.now(),
				    	param: vm.bCoopCompany,
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
