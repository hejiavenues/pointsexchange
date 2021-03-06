/**
 * 新增-积分增减记录表js
 */
var vm = new Vue({
	el:'#zsvm',
	data: {
		bPointsRecord: {
			pid: 0
		},
		rules:{//form 规则
		
			    pid: [ {  required: true, message: '', trigger: 'blur' } ], 
		    uid: [ {  required: true, message: '用户id', trigger: 'blur' } ], 
		    points: [ {  required: true, message: '获得的积分数量', trigger: 'blur' } ], 
		    accessType: [ {  required: true, message: '获取或消耗方式（1、参加活动 2、发布随拍 3、兑换商品）', trigger: 'blur' } ], 
		    createTime: [ {  required: true, message: '创建时间', trigger: 'blur' } ], 
		    updateTime: [ {  required: true, message: '修改时间', trigger: 'blur' } ]
			
		}
	},
	methods : {
		acceptClick: function() {
		  this.$refs
		  ["ruleForm"].validate(function(yes,b){
				if(yes){
					 $.SaveForm({
				    	url: '../../venuesbook/pointsrecord/save?_' + $.now(),
				    	param: vm.bPointsRecord,
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
