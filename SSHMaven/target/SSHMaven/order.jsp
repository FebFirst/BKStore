
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="model.User" %>
<% if(!((User)session.getAttribute("username")).getUsername().equals("feb")) {
	out.println("<script>window.location.href='home.jsp'</script>");
}
%>
<html>
<head>
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
    	<script src="jQuery/bootstrap-paginator.min.js" ></script>
		<script type="text/javascript">
		  function initData(pageSize,page){
			  debugger;
			  var data = null;
			  if(businessName)
				  data = {rows:pageSize,page:page,businessName:businessName};
			  else
				  data = {rows:pageSize,page:page};
			  $.ajax({
				  url:'listOrder.action',
				  dataType:'json',
				  type:'POST',
				  data:data,
				  success:function(data){
					  var total = data.total;
					  debugger;
					  if(total == 0)
						  $('#dg_buslist').bootstrapTable('load',$.parseJSON("[]"));
					  else
						  $('#dg_buslist').bootstrapTable('load',$.parseJSON(JSON.stringify(data.rows)));
					  pages = total%pageSize == 0?total/pageSize:parseInt(total/pageSize) + 1;
					  if(pages ==0)
						  pages = 1;
					  var options={
							  bootstrapMajorVersion: 3,
							  currentPage: 1,
							  totalPages:pages,
							  itemTexts:function(type,page,current){
								  switch(type){
								  case "first":
									  return "first";
								  case "prev":
									  return "prev";
								  case "next":
									  return "next";
								  case "last":
									  return "last";
								  case "page":
									  return "page";
								  }
							  },
							  onPageClicked:function(event,originalEvent,type,page){
								  debugger;
								  var data = null;
								  if(businessName)
									  data = {rows:pageSize,page:page,businessName:businessName};
								  else
									  data = {rows:pageSize,page:page};
								  $.ajax({
									  url:'listOrder.action',
									  dataType:'json',
									  type:'POST',
									  data:data,
									  success:function(data,textStatus){
										  var total = data.total;
										  if(total == 0)
											  $('#dg_buslist').bootstrapTable('load',$.parseJSON("[]"));
										  else
											  $('#dg_buslist').bootstrapTable('load',$.parseJSON(JSON.stringify(data.rows)));
									  },error:function(XMLHttpRequest,textStatus,errorThrown){}
								  });  
							  }
					  };
					  $('#fenye').bootstrapPaginator(options);
				  }
			  })
		  }
		  function buttonCancel()
			{
				window.location.href="listOrderBy.jsp";
			}
		  
		function rowStyle(row, index) {
		    var classes = ['active', 'active', 'active', 'active', 'active'];
		    
		    if (index % 2 === 0 && index / 2 < classes.length) {
		        return {
		            classes: classes[index / 2]
		        };
		    }
		    return {};
		}
		function runningFormatter(value, row, index) {
		    return index;
		}
		$.post("/SSHMaven/listOrder.action", function(result){
			$("#xg").text(JSON.stringify(result));
		});
		</script>
	</head>
</head>
<body>

<div id="navbar" class="navbar navbar-default navbar-fixed-top" role="navigation" style="">
    <div class="container-fuild">
        <div class="navbar-header">
           <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#nav-content" aria-expanded="false" aria-controls="navbar">
           
          </button>
            <a id="navbar-brand" class="navbar-brand" hrep="/">
                Poetry of Time
            </a>
        </div>
        <!--navbar right-->
        <div id="nav-content" class="navbar-collapse collapse" style="">
            <ul class="nav navbar-nav navbar-right" style="padding-right:10px">
                 <li><a id="navbar-brand" class="navbar-brand" hrep="/">
                <%
    			if(session.getAttribute("username")!=null) {
    			%>
    			<%=((User)session.getAttribute("username")).getUsername() %>
    			<%
    			}
   				 %>
            	</a></li>
                <li><a href="home.jsp">Log Out</a></li>
                
            </ul>
        </div>
    </div>
</div>
	<div class="container-fluid" style="margin-top:70px">
	<table data-toggle="table"  
	 style="width:100%;height:350px"
			data-url="/SSHMaven/listOrder.action"
			data-row-style="rowStyle"
			data-classes="table table-hover table-condensed"
       		data-striped="true"
       		data-search="true"
       		data-show-columns="true">
			
		<thead>
			<tr >
			 	<th data-formatter="runningFormatter">Index</th>
				<th data-field="ISBN" data-visible="ture">ISBN</th>
				<th data-field="userName" >User</th>
				<th data-field="number" >Number</th>
				<th data-field="cate" >Category</th>
				<th data-field="date" >Date</th>
				<th data-field="price" >Price</th>
				
			</tr>
		</thead>
	</table>
	
	</div>
	<!-- <ul id="fenye" class="pagination-md"></ul> -->
	<div class="but-group" style="padding-right:100px" >
	<button 
		type="button" class="btn btn-default" data-toggle="collapse" data-target="#date">Select By date
   	</button>
   	<button 
		type="button" class="btn btn-default" data-toggle="collapse" data-target="#name">Select By User
   	</button>
	</div>
	
	<div id="date" class="collapse">
		<form action="listOrderBy" method="post" class="form" role="form">
		<div class="form-group  required"><label class="control-label" for="date">Date</label>
        <input class="form-control" id="date" name="date" required type="text" value="">
        </div>
 		<input class="btn btn-default" id="submit" name="submit" type="submit" value="Comfirm" onclick="buttonCancel()">
		</form>
	</div>
	<div id="name" class="collapse" >
		<form action="listOrderBy" method="post" class="form" role="form">
		<div class="form-group  required"><label class="control-label" for="username">User Name</label>
        <input class="form-control" id="username" name="username" required type="text" value="">
        </div>
 		<input class="btn btn-default" id="submit" name="submit" type="submit" value="Comfirm" onclick="buttonCancel()">
		</form>
	</div>
	<div id ="xg"></div>
</body>
</html>