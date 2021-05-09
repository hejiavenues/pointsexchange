/**
 * 编辑-活动评论表js
 */
var vm = new Vue({
	el:'#zsvm',
	data: {
		bActivityReply: {
			replyId: 0
		},
		rules:{//form 规则
		
			    replyId: [ {  required: true, message: '', trigger: 'blur' } ], 
		    activityId: [ {  required: true, message: '活动Id', trigger: 'blur' } ], 
		    uid: [ {  required: true, message: '用户id', trigger: 'blur' } ], 
		    content: [ {  required: true, message: '评论内容', trigger: 'blur' } ], 
		    createTime: [ {  required: true, message: '', trigger: 'blur' } ], 
		    updateTime: [ {  required: true, message: '', trigger: 'blur' } ]
			
		}
			
	},
	methods : {
	   setForm: function() {
			$.SetForm({
				url: '../../venuesbook/info?_' + $.now(),
		    	param: vm.bActivityReply.replyId,
		    	success: function(data) {
		    		vm.bActivityReply = data;
		    	}
			});
		},
		acceptClick: function() {
		
		  this.$refs
		  ["ruleForm"].validate(function(yes,b){
				if(yes){
			 $.ConfirmForm({
				    	url: '../../venuesbook/update?_' + $.now(),
				    	param: vm.bActivityReply,
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
