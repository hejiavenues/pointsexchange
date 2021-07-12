/**
 * 新增-合作企业列表信息js
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
		acceptClick: function() {
		  this.$refs
		  ["ruleForm"].validate(function(yes,b){
				if(yes){
					 $.SaveForm({
				    	url: '../../venuesbook/coopcompany/save?_' + $.now(),
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
