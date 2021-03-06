/**
 * 用户信息表js
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
					{field : "uname", title : "用户名称", width : "110px"}, 
					/*{field : "sexStr", title : "用户性别", width : ""}, 
					{field : "birthday", title : "出生日期", width : "110px"}, */
					{field : "mobile", title : "手机号", width : "110px"}, 
					{field : "committeeName", title : "居委会", width : "150px"},
					{field : "userRoleStr", title : "用户性质", width : "100px"},
					/*（1.正常 2.禁用 3.删除） */
					{field : "statusStr", title : "用户状态", width : ""}, 
					{field : "points", title : "用户积分", width : ""}, 
					{field : "companyName", title : "所属公司", width : ""}, 
					{field : "address", title : "公司地址", width : ""}, 
					/*{field : "iconUrl", title : "头像地址", width : ""}, */
					{field : "createTime", title : "注册时间", width : "150px"}, 
					/*{field : "updateTime", title : "更新时间", width : ""}, 
					{field : "openid", title : "微信唯一标识", width : ""}*/
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
		 orgTree: function(row) {
			console.log(row.uid);
			var ck =[row];
			dialogOpen({
				id: 'layerOrgTree',
				title: '积分记录列表',
		        url: 'venue/pointsrecord/list.html?_' + $.now(),
		        scroll : true,
		        width: "1000px",
		        height: "550px",
				success: function(iframeId){
					console.log("2222222222222222"+row.tid);
					top.frames[iframeId].vm.param.uid = ck[0].uid;
					top.frames[iframeId].vm.load();
				},
		        yes : function(iframeId) {
		        	top.frames[iframeId].vm.acceptClick();
				}
		    })
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
				url: '../../venuesbook/user/list?_' + $.now(),
				param:th.param,
				success:function(r){
					console.log(r);
					for(var i=0;i<r.rows.length;i++){
						if(r.rows[i].status == 1){
                        r.rows[i].statusStr = '正常';
						}
                    	else if(r.rows[i].status == 2){
                        r.rows[i].statusStr = '禁用';
                    	}
					}
					th.table.data=r.rows;
					th.table.total=r.total;
				}
			})
		},
		save: function() {
			dialogOpen({
				title: '新增用户信息表',
				url: 'venue/user/add.html?_' + $.now(),
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
					title: '编辑用户信息表',
					url: 'venue/user/edit.html?_' + $.now(),
					width: '40%',
					height: '80%',
					success: function(iframeId){
						top.frames[iframeId].vm.bUser.uid = ck[0].uid;
						top.frames[iframeId].vm.setForm();
					},
					yes: function(iframeId){
						top.frames[iframeId].vm.acceptClick();
					}
				});
			}
		},
		updateStatus: function(row) {
			var ck =[row];
			 this.$confirm('您确定审核通过此用户吗？', '提示', {
            		confirmButtonText: '确定',
            		cancelButtonText: '取消',
            		type: 'warning'
          	}).then(() => {
           		 //点击确定的操作(调用接口)
				var ck =[row];
				if(row.status == 0){
                	ck[0].status=1
            	}
				zs_post({
				url: '../../venuesbook/user/update',
				param:ck[0],
				success:function(r){
					console.log(r);
					vm.load();
					}
				})
          	}).catch(() => {
            	//几点取消的提示
				//alert("123123123");
          	});
        },
	    updateStatus1: function(row) {
			 this.$confirm('您确定审核拒绝此用户吗？', '提示', {
            		confirmButtonText: '确定',
            		cancelButtonText: '取消',
            		type: 'warning'
          	}).then(() => {
           		 //点击确定的操作(调用接口)
				var ck =[row];
				if(row.status == 0){
                	ck[0].status=4;
            	}
				zs_post({
				url: '../../venuesbook/user/update',
				param:ck[0],
				success:function(r){
					console.log(r);
					vm.load();
					}
				})
          	}).catch(() => {
            	//几点取消的提示
				//alert("123123123");
          	});
        },
		remove: function(row) {
			var ck = [row], ids = [];	
			if(checkedArray(ck)){
				$.each(ck, function(idx, item){
					ids[idx] = item.uid;
				});
				$.RemoveForm({
					url: '../../venuesbook/user/remove?_' + $.now(),
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