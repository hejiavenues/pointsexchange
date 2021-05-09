/**
 * 法律体检表js
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
					/*{field : "lawId", title : "", width : ""}, */
					{field : "lawName", title : "律师事务所名字", width : "150px"}, 
					{field : "address", title : "地址", width : "350px"}, 
					{field : "phone", title : "联系方式", width : "120px"}, 
					{field : "remark", title : "服务描述", width : "350px"}, 
					{field : "createTime", title : "创建时间", width : "150px"}, 
					{field : "updateTime", title : "更新时间", width : "150px"}
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
				url: '../../venuesbook/lawinfo/list?_' + $.now(),
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
				title: '新增法律体检表',
				url: 'venue/lawinfo/add.html?_' + $.now(),
				width: '40%',
				height: '54%',
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
					title: '编辑法律体检表',
					url: 'venue/lawinfo/edit.html?_' + $.now(),
					width: '40%',
					height: '54%',
					success: function(iframeId){
						top.frames[iframeId].vm.bLawInfo.lawId = ck[0].lawId;
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
					ids[idx] = item.lawId;
				});
				$.RemoveForm({
					url: '../../venuesbook/lawinfo/remove?_' + $.now(),
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