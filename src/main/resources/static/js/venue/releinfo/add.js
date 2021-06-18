/**
 * 新增-企业上下游关系信息表js
 */
var vm = new Vue({
	el:'#zsvm',
	data: {
		bReleInfo: {
			id: 0
		},
		rules:{//form 规则
		
			    id: [ {  required: true, message: '', trigger: 'blur' } ], 
		    title: [ {  required: true, message: '标题', trigger: 'blur' } ], 
		    content: [ {  required: true, message: '信息内容', trigger: 'blur' } ], 
		    iconUrl: [ {  required: true, message: '图片地址', trigger: 'blur' } ], 
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
				    	url: '../../venuesbook/releinfo/save?_' + $.now(),
				    	param: vm.bReleInfo,
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
