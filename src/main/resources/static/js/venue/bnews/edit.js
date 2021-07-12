/**
 * 编辑-文章列表信息js
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
	   setForm: function() {
			$.SetForm({
				url: '../../venuesbook/bnews/info?_' + $.now(),
		    	param: vm.bNews.nid,
		    	success: function(data) {
		    		vm.bNews = data;
		    	}
			});
		},
		acceptClick: function() {
		
		  this.$refs
		  ["ruleForm"].validate(function(yes,b){
				if(yes){
			 $.ConfirmForm({
				    	url: '../../venuesbook/bnews/update?_' + $.now(),
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
