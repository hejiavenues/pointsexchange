/**
 * 活动评论表js
 */

var vm = new Vue({
    el:'#zsvm',
	data: {
	    activeNames:["1"],//模板固定参数
		param:{//搜索参数
			channel:parent.vm.user.channel,//saas必要参数channel
		    pageNumber:1,//第几页
			pageSize:10,//查询条数
			keyword: null,
			activityId: '',
		},
		activityId:'',
		table:{//表格数据
			  "col":[
					{field : "activityName", title : "活动名称", width : "120px"}, 
					{field : "uName", title : "评论人", width : "80px"}, 
					{field : "content", title : "评论内容", width : ""}, 
					{field : "createTime", title : "评论时间", width : "150px"}, 
					/*{field : "updateTime", title : "", width : ""}*/
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
			console.log("-------"+th.param.activityId);
			console.log("-------"+th.activityId);
			if(page!=undefined&&page!=0){
				this.param.pageNumber=page;
			}
			if(size!=undefined&&size!=0){
				this.param.pageSize=size;
			}
			zs_post({
				url: '../../venuesbook/activityreply/list?_' + $.now(),
				param:th.param,
				success:function(r){
					console.log(r);
					
					/*for(var i=0;i<r.rows.length;i++){
						if(r.rows[i].ispresent == 0){
                        r.rows[i].ispresent = '未到场';
						}
                    	else if(r.rows[i].ispresent == 1){
                        r.rows[i].ispresent = '已到场';
                    	}
						if(r.rows[i].status == 1){
                        r.rows[i].status = '已报名';
						}
                    	else if(r.rows[i].status == 2){
                        r.rows[i].status = '已取消';
                    	}
					}*/
					
					th.table.data=r.rows;
					th.table.total=r.total;
				}
			})
		},
		save: function() {
			dialogOpen({
				title: '新增活动评论表',
				url: 'venue/activity_reply/add.html?_' + $.now(),
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
					title: '编辑活动评论表',
					url: 'venue/activity_reply/edit.html?_' + $.now(),
					width: '40%',
					height: '80%',
					success: function(iframeId){
						top.frames[iframeId].vm.bActivityReply.replyId = ck[0].replyId;
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
					ids[idx] = item.replyId;
				});
				$.RemoveForm({
					url: '../../venuesbook/remove?_' + $.now(),
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