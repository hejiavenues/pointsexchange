/**
 * 新增-积分兑换记录表js
 */
var vm = new Vue({
	el:'#zsvm',
	data: {
		bExchangeRecord: {
			id: 0
		},
		rules:{//form 规则
		
			    id: [ {  required: true, message: '主键', trigger: 'blur' } ], 
		    uid: [ {  required: true, message: '用户id', trigger: 'blur' } ], 
		    gid: [ {  required: true, message: '商品id', trigger: 'blur' } ], 
		    points: [ {  required: true, message: '消耗的积分', trigger: 'blur' } ], 
		    exStatus: [ {  required: true, message: '兑换状态（1、成功 2、取消），备用字段', trigger: 'blur' } ], 
		    createTime: [ {  required: true, message: '兑换时间', trigger: 'blur' } ], 
		    updateTime: [ {  required: true, message: '修改时间', trigger: 'blur' } ]
			
		}
	},
	methods : {
		acceptClick: function() {
		  this.$refs
		  ["ruleForm"].validate(function(yes,b){
				if(yes){
					 $.SaveForm({
				    	url: '../../venuesbook/exchrecord/save?_' + $.now(),
				    	param: vm.bExchangeRecord,
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
