/**
 * 编辑-外部场馆信息表js
 */
var vm = new Vue({
	el:'#zsvm',
	data: {
		bVenueInfoOut: {
			venueId: 0
		},
		rules:{//form 规则
		
			    venueId: [ {  required: true, message: '主键', trigger: 'blur' } ], 
		    venueName: [ {  required: true, message: '场馆名称', trigger: 'blur' } ], 
		    maxPeople: [ {  required: true, message: '最大容纳人数', trigger: 'blur' } ], 
		    address: [ {  required: true, message: '场馆地址', trigger: 'blur' } ], 
		    userId: [ {  required: true, message: '所属企业用户Id', trigger: 'blur' } ], 
		    supportActiveType: [ {  required: true, message: '支持的活动类型，字符串', trigger: 'blur' } ], 
		    iconUrl: [ {  required: true, message: '图片地址', trigger: 'blur' } ], 
		    status: [ {  required: true, message: '0可用1隐藏', trigger: 'blur' } ], 
		    openTime: [ {  required: true, message: '开放时间', trigger: 'blur' } ], 
		    activityRemark: [ {  required: true, message: '支持活动内容', trigger: 'blur' } ], 
		    createTime: [ {  required: true, message: '创建时间', trigger: 'blur' } ], 
		    updateTime: [ {  required: true, message: '修改时间', trigger: 'blur' } ]
			
		}
			
	},
	methods : {
	   setForm: function() {
			$.SetForm({
				url: '../../venuesbook/outvenueinfo/info?_' + $.now(),
		    	param: vm.bVenueInfoOut.venueId,
		    	success: function(data) {
		    		vm.bVenueInfoOut = data;
		    	}
			});
		},
		acceptClick: function() {
		
		  this.$refs
		  ["ruleForm"].validate(function(yes,b){
				if(yes){
			 $.ConfirmForm({
				    	url: '../../venuesbook/outvenueinfo/update?_' + $.now(),
				    	param: vm.bVenueInfoOut,
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
