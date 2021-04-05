/**
 * js
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
					{field : "goodsName", title : "商品名称", width : ""}, 
					{field : "points", title : "所需时长（小时）", width : ""},
					{field : "price", title : "市场价（元）", width : ""},
                  {field : "goodsCount", title : "库存总量", width : ""},
                  {field : "remark", title : "描述", width : ""},
                  {field : "goodsStatusStr", title : "上架状态", width : ""},
					{field : "createTime", title : "商品创建时间", width : "150px"}, 
					/*{field : "updateTime", title : "更新时间", width : "150px"}*/
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
		 updateStatus: function(row) {
            var ck =[row];
            var msg = '';
            if(row.goodsStatus == 1){
                msg = '您确定要下架该商品吗？';
                ck[0].goodsStatus=2;
            }else{
                msg = '您确定要上架该商品吗？';
                ck[0].goodsStatus=1;
            }
            if(checkedRow(ck)){
                /*$.ConfirmForm({
                    msg:msg,
                    url: '../../venuesbook/goods/update?_' + $.now(),
                    param: ck[0],
                    success: function(data) {
                        $.currentIframe().vm.load();
                    }
                });*/
					zs_postFormA(vm,{
                        url: '../../venuesbook/goods/update?_' + $.now(),
                        param: ck[0],
                        success: function(data) {
                            vm.$message.success('修改成功');
                            $.currentIframe().vm.load();
                            setTimeout(function() {
                                dialogClose();
                            }, 1000);
                        }
                    });
            }
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
				url: '../../venuesbook/goods/list?_' + $.now(),
				param:th.param,
				success:function(r){
					console.log(r);
					/*for(var i=0;i<r.rows.length;i++){
						if(r.rows[i].goodsStatus == 1){
                        r.rows[i].goodsStatus = '上架';
						}
                    	else if(r.rows[i].goodsStatus == 2){
                        r.rows[i].goodsStatus = '下架';
                    	}
					}*/
					th.table.data=r.rows;
					th.table.total=r.total;
				}
			})
		},
		save: function() {
			dialogOpen({
				title: '新增商品',
				url: 'venue/goods/add.html?_' + $.now(),
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
					title: '编辑商品',
					url: 'venue/goods/edit.html?_' + $.now(),
					width: '40%',
					height: '80%',
					success: function(iframeId){
						top.frames[iframeId].vm.bGoodsInfo.gid = ck[0].gid;
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
					ids[idx] = item.gid;
				});
				$.RemoveForm({
					url: '../../venuesbook/goods/remove?_' + $.now(),
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