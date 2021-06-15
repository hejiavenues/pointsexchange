/**
 * 志愿者导师信息表js
 */

var vm = new Vue({
    el:'#zsvm',
	data: {
	    activeNames:["1"],//模板固定参数
		param:{//搜索参数
			channel:parent.vm.user.channel,//saas必要参数channel
		    pageNumber:1,//第几页
			pageSize:10,//查询条数
			keyword: null
		},
		table:{//表格数据
			  "col":[
					{field : "uname", title : "用户名称", width : "80px"}, 
					{field : "sexStr", title : "性别", width : "50px"}, 
					{field : "mobile", title : "手机号", width : "100px"}, 
					{field : "skill", title : "个人特长", width : "100px"}, 
					{field : "skillDes", title : "特长说明", width : "200px"}, 
			  ],
			  "pagesizes":[1,10, 20, 30, 100],//size选择器
			  "pagesize ":10,
			  "sync":1,//当前页数
			  "total":0,
	          "data":[],
	  		   selects:[],//表格选中行
		  },
	},
	methods : {
	    selectCases:function(selects){
			this.table.selects=selects;
	    },
	     handleCurrentChange:function(val) {//table 查询
	       // console.log(`当前页: ${val}`);
			 this.load(val,0);
	     },
	     handleSizeChange:function(val) {//table 查询
	         // console.log(`每页 ${val} 条`);
	    	 this.load(0,val);
	     },
		 load:function(page,size){//查询
			var th = this;
			if(page!=undefined&&page!=0){
				this.param.pageNumber=page;
			}
			if(size!=undefined&&size!=0){
				this.param.pageSize=size;
			}
			zs_post({
				url: '../../venuesbook/usertutor/list?_' + $.now(),
				param:th.param,
				success:function(r){
					console.log(r);
					th.table.data=r.rows;
					th.table.total=r.total;
				}
			})
		},
		save: function() {
			dialogOpen({
				title: '新增志愿者导师信息表',
				url: 'venue/usertutor/add.html?_' + $.now(),
				width: '40%',
				height: '80%',
				success: function(iframeId){
				},
				yes : function(iframeId) {
					top.frames[iframeId].vm.acceptClick();
				},
			});
		},
		edit: function(row) {
			var ck =[row];
			if(checkedRow(ck)){
				dialogOpen({
					title: '编辑志愿者导师信息',
					url: 'venue/usertutor/edit.html?_' + $.now(),
					width: '40%',
					height: '80%',
					success: function(iframeId){
						top.frames[iframeId].vm.bUserTutor.uid = ck[0].uid;
						top.frames[iframeId].vm.setForm();
					},
					yes: function(iframeId){
						top.frames[iframeId].vm.acceptClick();
					}
				});
			}
		},
		remove: function(row) {
			var ck = [row], ids = [];	
			if(checkedArray(ck)){
				$.each(ck, function(idx, item){
					ids[idx] = item.uid;
				});
				$.RemoveForm({
					url: '../../venuesbook/usertutor/remove?_' + $.now(),
			    	param: ids,
			    	success: function(data) {
			    		vm.load();
			    	}
				});
			}
		},
		passApply: function(row) {
			var ck = [row], ids = [];	
			if(checkedArray(ck)){
				$.each(ck, function(idx, item){
					ids[idx] = item.uid;
				});
				/*$.RemoveForm({
					url: '../../venuesbook/photoinfo/passApply?_' + $.now(),
			    	param: ids,
			    	success: function(data) {
			    		vm.load();
			    	}
				});*/
				zs_post({
				url: '../../venuesbook/usertutor/passApply?_' + $.now(),
				param:ids,
				success:function(r){
					vm.load();
				}
			})
			}
		},
		refuseApply: function(row) {
			var ck = [row], ids = [];	
			if(checkedArray(ck)){
				$.each(ck, function(idx, item){
					ids[idx] = item.uid;
				});
				/*$.RemoveForm({
					url: '../../venuesbook/photoinfo/passApply?_' + $.now(),
			    	param: ids,
			    	success: function(data) {
			    		vm.load();
			    	}
				});*/
				zs_post({
				url: '../../venuesbook/usertutor/refuseApply?_' + $.now(),
				param:ids,
				success:function(r){
					vm.load();
				}
			})
			}
		},
	 },
	 mounted:function(){
	 	this.load();
	 }
})