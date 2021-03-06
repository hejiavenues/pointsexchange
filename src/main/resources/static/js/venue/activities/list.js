/**
 * 活动信息表js
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
					{field : "activityIdName", title : "活动名称", width : ""}, 
					{field : "venueName", title : "场馆名称", width : ""}, 
					{field : "userName", title : "预约人", width : ""}, 
					{field : "activityCount", title : "活动人数", width : ""}, 
					{field : "activityType", title : "活动类型", width : ""}, 
					{field : "activityContent", title : "活动内容", width : ""}, 
					/*{field : "activityIconUrl", title : "活动图片url", width : ""}, 
					{field : "status", title : "活动状态", width : ""}, 
					{field : "activityTime", title : "活动时段", width : ""}, 
					{field : "createTime", title : "创建时间", width : ""}, 
					{field : "updateTime", title : "更新时间", width : ""}*/
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
		orgTree: function(row) {
			console.log(row.activityId);
			var ck =[row];
			dialogOpen({
				id: 'layerOrgTree',
				title: '报名人列表',
		        url: 'venue/activityentry/list.html?activityId=' + row.activityId,
		        scroll : true,
		        width: "1000px",
		        height: "550px",
				success: function(iframeId){
					console.log("2222222222222222"+row.activityId);
					top.frames[iframeId].vm.param.activityId = ck[0].activityId;
					top.frames[iframeId].vm.load();
					},
		        yes : function(iframeId) {
					console.log("2222222222222222"+row.activityId);
					top.frames[iframeId].vm.param.activityId = ck[0].activityId;
					top.frames[iframeId].vm.load();
		        	//top.frames[iframeId].vm.acceptClick();
				}
		    })
		},
		orgTree1: function(row) {
			console.log(row.activityId);
			var ck =[row];
			dialogOpen({
				id: 'layerOrgTree',
				title: '评论列表',
		        url: 'venue/activityreply/list.html?activityId=' + row.activityId,
		        scroll : true,
		        width: "1000px",
		        height: "550px",
				success: function(iframeId){
					console.log("2222222222222222"+row.activityId);
					top.frames[iframeId].vm.param.activityId = ck[0].activityId;
					top.frames[iframeId].vm.load();
					},
		        yes : function(iframeId) {
					console.log("2222222222222222"+row.activityId);
					top.frames[iframeId].vm.param.activityId = ck[0].activityId;
					top.frames[iframeId].vm.load();
		        	//top.frames[iframeId].vm.acceptClick();
				}
		    })
		},
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
				url: '../../venuesbook/activities/list?_' + $.now(),
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
				title: '新增活动信息表',
				url: 'venue/activities/add.html?_' + $.now(),
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
					title: '编辑活动信息表',
					url: 'venue/activities/edit.html?_' + $.now(),
					width: '40%',
					height: '80%',
					success: function(iframeId){
						top.frames[iframeId].vm.bActivities.activityId = ck[0].activityId;
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
					ids[idx] = item.activityId;
				});
				$.RemoveForm({
					url: '../../venuesbook/activities/remove?_' + $.now(),
			    	param: ids,
			    	success: function(data) {
			    		vm.load();
			    	}
				});
			}
		},
	
	 },
	 mounted:function(){
	 	this.load();
	 }
})