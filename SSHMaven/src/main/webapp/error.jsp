<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<%-- <%@ page import="service.bookService" %> --%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Poetry of Time</title>
<link href="myCss/style.css" rel="stylesheet">
    	<link href="bootstrap-3.3.5-dist/css/bootstrap.min.css" rel="stylesheet">
   	 	<link href="bootstrap-table-master/dist/bootstrap-table.min.css" rel="stylesheet">
    	<link href="bootstrap-table-master/src/bootstrap-table.css" rel="stylesheet">
   		 <script type="text/javascript" src="jQuery/jquery-2.2.4.min.js"></script>
   		 <script src="bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
    	<script src="bootstrap-table-master/dist/bootstrap-table.min.js" ></script>
    	<script src="bootstrap-table-master/dist/bootstrap-table-locale-all.min.js" ></script>
   		
    	<script src="bootstrap-table-master/src/extensions/editable/bootstrap-table-editable.js" ></script>

		<script type="text/javascript">
		/* $(function(){
			var oTable = new TableInit();
			oTable.Init();
		});
		var TableInit = function(){
			var oTableInit = new Object();
			
			oTableInit.Init = function(){
				$('#book').bootstrapTable({
					url:"/SSHMaven/listBook.action",
					method:'post',
					toolbar:'#toolbar',
					striped:true,
					cache:false,
					
					pagination:true,
					sortable:false,
					sortOrder:"asc",
					queryParams:oTableInit.queryParams,
					sidePagination:"client",
					pageNumber:1,
					pageSize:10,
					pageList:[5,10],
					search:true,
					
					strictSearch:true,
					clickToSelect:true,
					uniqueId:"id",
					cardView:false,
					detailView:false,
					onEditableSave:function(field,row,oldValue,$el){
						$.ajax({
							type:"post",
							url:"/SSHMaven/listBook.action",
							data:{strJson:JSON.stringify(row)},
							success:function(data,status){
								if(status == "success"){
									alert("success!");
								}
							},
							error:function(){
								alert("error");
							},
							complete:function(){
								
							}
						});
					},
					columns:[{
						field:'id',
						title:'index'
					},{
						field:'ISBN',
						title:'ISBN'
					},{
						field:'bookName',
						title:'book name',
						editable:true
					},{
						field:'author',
						title:'author',
						editable:true
					},{
						field:'price',
						title:'price',
						editable:true
					},]
				});
			};
			
			oTableInit.queryParams = function(params){
				var temp = {
						limit:params.limit,
						offset:params.offset,
						sdate:$("#stratTime").val(),
						edate: $("#endTime").val(),
				        sellerid: $("#sellerid").val(),
				        orderid: $("#orderid").val(),
				        CardNumber: $("#CardNumber").val(),
				        maxrows: params.limit,
				        pageindex:params.pageNumber,
				        portid: $("#portid").val(),
				        CardNumber: $("#CardNumber").val(),
				        tradetype:$('input:radio[name="tradetype"]:checked').val(),
				        success:$('input:radio[name="success"]:checked').val(),
				};
				return temp;
			};
			return oTableInit;
		}; */
		$(function(){
			$('#book').bootstrapTable({
				/* url:"/SSHMaven/listBook.action", */
				/* method:'post', */
				columns:[{
					field:'id',
					title:'index'
				},{
					field:'ISBN',
					title:'ISBN'
				},{
					field:'bookName',
					title:'book name',
					editable:true
				},{
					field:'author',
					title:'author',
					editable:true
				},{
					field:'price',
					title:'price',
					editable:true
				},]})
		});
	$.post("/SSHMaven/listBook.action", function(result){
		$("#xg").text(JSON.stringify(result));
	}); 
		</script>
</head>
<body>
<table id="book" data-toggle="table"  
	 style="width:100%;height:350px"
			data-url="/SSHMaven/listBook.action"
			data-row-style="rowStyle"
			data-classes="table table-hover table-condensed"
       		data-striped="true"
       		data-show-columns="true">
	</table>
<div id="xg"></div>
</body>
</html>