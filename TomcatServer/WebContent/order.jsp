<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% if(!request.getSession().getAttribute("logname").equals("feb")) {
	out.print("<script>window.location.href='home.jsp'</script>");
}
%>
<html>
<head>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Welcome to feb's home</title>
		<link href="scripts/bootstrap-3.3.5-dist/css/bootstrap.min.css" rel="stylesheet">
		<link href="scripts/bootstrap-table-master/dist/bootstrap-table.min.css" rel="stylesheet">
		<link href="scripts/bootstrap-table-master/src/bootstrap-table.css" rel="stylesheet">
		<script type="text/javascript" src="scripts/jquery-2.2.2.min.js"></script>
		<script src="scripts/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
		<script src="scripts/bootstrap-table-master/dist/bootstrap-table.min.js" ></script>
		<script src="scripts/bootstrap-table-master/dist/bootstrap-table-locale-all.min.js" ></script>
		<script type="text/javascript">
		/* function initData(pageSize,page){
			debugger;
			var data = null;
			if(ISBN)
				
			$.ajax({
				url:'listBooksServlet',
				type:'POST',
				dataType:'json',
				timeout:1000,
				cache:false,
				//beforeSend:loadFunction,
				success:
					$('#bk').bootstrapeTable('load',)
			})
				
		} 
		  */
		  
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
                Welcome to feb's home
            </a>
        </div>
        <!--navbar right-->
        <div id="nav-content" class="navbar-collapse collapse" style="">
            <ul class="nav navbar-nav navbar-right" style="padding-right:10px">
                 <li><a id="navbar-brand" class="navbar-brand" hrep="/">
                <%
    			if(request.getSession().getAttribute("logname")!=null) {
    			%>
    			<%=request.getSession().getAttribute("logname") %>
    			<%
    			}
   				 %>
            	</a></li>
                <li><a href="home.jsp">Log Out</a></li>
                
            </ul>
        </div>
    </div>
</div>
<!-- Show books -->
	<!-- <div class="container-fluid" style="margin:auto;width:70%"> -->
	<!-- <div class="columns columns-right btn-group pull-right">
		<div class="keep-open btn-group" title="Columns">
			<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
				<i class="glyphicon glyphicon-th icon-th"></i>
				<span class="caret"></span>
			</button>
			<ul class="dropdown-menu" role="menu">
				<li><label><input type="checkbox" data-field="ISBN" value="1" checked="checked"> ISBN</label></li>
				<li><label><input type="checkbox" data-field="Name" value="2" checked="checked"> Name</label></li>
				<li><label><input type="checkbox" data-field="Author" value="3"> Author</label></li>
			</ul>
		</div>
	</div> -->
	<div class="container-fluid" style="margin-top:70px">
	<table data-toggle="table"  
	 style="width:100%;height:350px"
			data-url="/TomcatServer/listOrdersServlet"
			data-row-style="rowStyle"
			data-classes="table table-hover table-condensed"
       		data-striped="true"
       		data-show-columns="true">
			
		<thead>
			<tr >
			 	<th data-formatter="runningFormatter">Index</th>
				<th data-field="ISBN" data-visible="false">ISBN</th>
				<th data-field="bookname" data-switchable="false">Book Name</th>
				<th data-field="user" >User</th>
				<th data-field="number" >Number</th>
				<th data-field="date" >Date</th>
				<th data-field="price" >Price</th>
			</tr>
		</thead>
	</table>
	
	</div>
	<div class="but-group" style="padding-right:100px" >
	<button 
		type="button" class="btn btn-default" data-toggle="collapse" data-target="#date">Select By date
   	</button>
   	<button 
		type="button" class="btn btn-default" data-toggle="collapse" data-target="#name">Select By User
   	</button>
	</div>
	
	<div id="date" class="collapse">
		<form action="listOrdersHelperServlet" method="post" class="form" role="form">
		<div class="form-group  required"><label class="control-label" for="getBydate">Date</label>
        <input class="form-control" id="getBydate" name="getBydate" required type="text" value="">
        </div>
 		<input class="btn btn-default" id="submit" name="submit" type="submit" value="Comfirm" onclick="buttonCancel()">
		</form>
	</div>
	<div id="name" class="collapse" >
		<form action="listOrdersHelperServlet" method="post" class="form" role="form">
		<div class="form-group  required"><label class="control-label" for="getByname">User Name</label>
        <input class="form-control" id="getByname" name="getByname" required type="text" value="">
        </div>
 		<input class="btn btn-default" id="submit" name="submit" type="submit" value="Comfirm" onclick="buttonCancel()">
		</form>
	</div>
</body>
</html>