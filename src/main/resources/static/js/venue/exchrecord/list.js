/**
 * 积分兑换记录表js
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
					{field : "uname", title : "兑换人", width : ""}, 
					{field : "userRole", title : "用户性质", width : ""}, 
					{field : "umobile", title : "手机号", width : ""}, 
					{field : "companyName", title : "企业名称", width : ""}, 
					{field : "gname", title : "商品名称", width : ""}, 
					{field : "gpoints", title : "消耗的积分", width : ""}, 
					/*{field : "exStatus", title : "兑换状态（1、成功 2、取消），备用字段", width : ""}, */
					{field : "createTime", title : "兑换时间", width : ""}, 
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
				url: '../../venuesbook/exchrecord/list?_' + $.now(),
				param:th.param,
				success:function(r){
					console.log(r);
					for(var i=0;i<r.rows.length;i++){
						if(r.rows[i].userRole == 1){
                        r.rows[i].userRole = '普通用户';
						}
                    	else if(r.rows[i].userRole == 2){
                        r.rows[i].userRole = '企业用户';
                    	}
					}
					th.table.data=r.rows;
					th.table.total=r.total;
				}
			})
		},
		save: function() {
			dialogOpen({
				title: '新增积分兑换记录表',
				url: 'venue/exchrecord/add.html?_' + $.now(),
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
					title: '编辑积分兑换记录表',
					url: 'venue/exchrecord/edit.html?_' + $.now(),
					width: '40%',
					height: '80%',
					success: function(iframeId){
						top.frames[iframeId].vm.bExchangeRecord.id = ck[0].id;
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
					ids[idx] = item.id;
				});
				$.RemoveForm({
					url: '../../venuesbook/exchrecord/remove?_' + $.now(),
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