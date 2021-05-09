/**
 * 编辑-法律体检表js
 */
var vm = new Vue({
	el:'#zsvm',
	data: {
		bLawInfo: {
			lawId: 0
		},
		rules:{//form 规则
		
			    lawId: [ {  required: true, message: '', trigger: 'blur' } ], 
		    lawName: [ {  required: true, message: '律师事务所名字', trigger: 'blur' } ], 
		    address: [ {  required: true, message: '地址', trigger: 'blur' } ], 
		    phone: [ {  required: true, message: '联系方式', trigger: 'blur' } ], 
		    remark: [ {  required: true, message: '服务描述', trigger: 'blur' } ], 
		    createTime: [ {  required: true, message: '', trigger: 'blur' } ], 
		    updateTime: [ {  required: true, message: '', trigger: 'blur' } ]
			
		}
			
	},
	methods : {
	   setForm: function() {
			$.SetForm({
				url: '../../venuesbook/lawinfo/info?_' + $.now(),
		    	param: vm.bLawInfo.lawId,
		    	success: function(data) {
		    		vm.bLawInfo = data;
		    	}
			});
		},
		acceptClick: function() {
		
		  this.$refs
		  ["ruleForm"].validate(function(yes,b){
				if(yes){
			 $.ConfirmForm({
				    	url: '../../venuesbook/lawinfo/update?_' + $.now(),
				    	param: vm.bLawInfo,
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
