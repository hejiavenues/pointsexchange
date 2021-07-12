/**
 * 新增-文章列表信息js
 */
var vm = new Vue({
	el:'#zsvm',
	data: {
		bNews: {
			nid: 0
		},
		rules:{//form 规则
		
			    nid: [ {  required: true, message: '主键', trigger: 'blur' } ], 
		    title: [ {  required: true, message: '文章标题', trigger: 'blur' } ], 
		    newsImg: [ {  required: true, message: '文章图片', trigger: 'blur' } ], 
		    newsContent: [ {  required: true, message: '文章内容', trigger: 'blur' } ], 
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
				    	url: '../../venuesbook/bnews/save?_' + $.now(),
				    	param: vm.bNews,
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
