/**
 * 积分增减记录表js
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
					{field : "uname", title : "姓名", width : "80px"}, 
					{field : "points", title : "获得的积分数量", width : "80px"}, 
					{field : "accessType", title : "获取或消耗方式", width : "120px"}, 
					{field : "remark", title : "描述/备注", width : ""}, 
					{field : "createTime", title : "记录时间", width : "150px"}, 
					/*{field : "updateTime", title : "修改时间", width : ""}*/
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
				url: '../../venuesbook/pointsrecord/list?_' + $.now(),
				param:th.param,
				success:function(r){
					console.log(r);
					//（1、参加活动 2、发布随拍 3、兑换商品）
					for(var i=0;i<r.rows.length;i++){
						if(r.rows[i].accessType == 1){
                        r.rows[i].accessType = '参加活动';
						}
                    	else if(r.rows[i].accessType == 2){
                        r.rows[i].accessType = '发布随拍';
                    	}
						else if(r.rows[i].accessType == 3){
                        r.rows[i].accessType = '兑换商品';
                    	}
						else if(r.rows[i].accessType == 4){
                        r.rows[i].accessType = '管理员奖励';
                    	}
					}
					th.table.data=r.rows;
					th.table.total=r.total;
				}
			})
		},
		save: function() {
			dialogOpen({
				title: '给用户发放积分',
				url: 'venue/pointsrecord/add.html?_' + $.now(),
				width: '30%',
				height: '50%',
				success: function(iframeId){
					//alert("vm.param.uid"+vm.param.uid);
					top.frames[iframeId].vm.bPointsRecord.uid = vm.param.uid;
				},
				yes : function(iframeId) {
					top.frames[iframeId].vm.acceptClick();
					setTimeout(function(){
						location.reload();
					},1200)
					
				},
			});
		},
		edit: function(row) {
			var ck =[row];
			if(checkedRow(ck)){
				dialogOpen({
					title: '编辑积分增减记录表',
					url: 'venue/pointsrecord/edit.html?_' + $.now(),
					width: '40%',
					height: '80%',
					success: function(iframeId){
						top.frames[iframeId].vm.bPointsRecord.pid = ck[0].pid;
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
					ids[idx] = item.pid;
				});
				$.RemoveForm({
					url: '../../venuesbook/pointsrecord/remove?_' + $.now(),
			    	param: ids,
			    	success: function(data) {
			    		vm.load();
			    	}
				});
			}
		},
	
	 },
	 mounted:function(){
	 	//this.load();
	 }
})