<!-- 
	Author:Xiong Guo (febfirst)
	Designer:
	Todo:Home page of this webside
	Known bugs:
-->
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<% if(!request.getSession().getAttribute("logname").equals("feb")) {
	out.print("<script>window.location.href='home.jsp'</script>");
}
%>
<html lang="en" dir="ltr">

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
		{}
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
            	<li><a href="order.jsp">Order</a></li>
                <li><a href="home.jsp">Log Out</a></li>
                
            </ul>
        </div>
    </div>
</div>
<!-- Show books -->
	<!-- <div class="container-fluid" style="margin:auto;width:70%"> -->
<!-- 	<div class="columns columns-right btn-group pull-right">
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
	<div> 
		<a id="navbar-brand" class="navbar-brand" hrep="/">
                Here are books available! Enjoy!
        </a>
	</div>
	<table data-toggle="table"  
	 style="width:100%;height:350px"
			data-url="/TomcatServer/listBooksServlet"
			data-row-style="rowStyle"
			data-classes="table table-hover table-condensed"
       		data-striped="true"
       		data-show-columns="true">
			
		<thead>
			<tr >
			 	<th data-formatter="runningFormatter">Index</th>
				<th data-field="ISBN" data-visible="true">ISBN</th>
				<th data-field="bookname" data-switchable="false">Name</th>
				<th data-field="author" >Author</th>
				<th data-field="price" >Price</th>
			</tr>
		</thead>
	</table>
	
	</div>
	<div class="but-group" style="padding-right:100px" >
	<button 
		type="button" class="btn btn-default" data-toggle="collapse" data-target="#remove">Remove Book
   	</button>
   	<button 
		type="button" class="btn btn-default" data-toggle="collapse" data-target="#add">Add Book
   	</button>
   	<button 
		type="button" class="btn btn-default" data-toggle="collapse" data-target="#update">Update Book
   	</button>
	</div>
	<div id="remove" class="collapse">
		<form action="deleteBookServlet" method="post" class="form" role="form">
		<div class="form-group  required"><label class="control-label" for="ISBN">ISBN</label>
        <input class="form-control" id="ISBN" name="ISBN" required type="text" value="">
        </div>
 		<input class="btn btn-default" id="submit" name="submit" type="submit" value="Comfirm">
	 	<input class="btn btn-default" id="submit" name="submit" type="submit" value="Cancel" onclick="buttonCancel()">
 
		</form>
	</div>
	<div id="add" class="collapse">
		<form action="addBookServlet" method="post" class="form" role="form">
		<div class="form-group  required"><label class="control-label" for="ISBN">ISBN</label>
        <input class="form-control" id="ISBN" name="ISBN" required type="text" value="">
        </div>
         <div class="form-group  required"><label class="control-label" for="bookname">Book Name</label>
        <input class="form-control" id="bookname" name="bookname" required type="text" value="">
        </div>
         <div class="form-group  required"><label class="control-label" for="author">Author</label>
        <input class="form-control" id="author" name="author" required type="text" value="">
        </div>
         <div class="form-group  required"><label class="control-label" for="price">Price</label>
        <input class="form-control" id="price" name="price" required type="text" value="">
        </div>
 		<input class="btn btn-default" id="submit" name="submit" type="submit" value="Comfirm">
	 	<input class="btn btn-default" id="submit" name="submit" type="submit" value="Cancel" onclick="buttonCancel()">
 
		</form>
	</div>
	<div id="update" class="collapse">
		<form action="updateBookServlet" method="post" class="form" role="form">

		<div class="form-group  required"><label class="control-label" for="ISBN">ISBN</label>
        <input class="form-control" id="ISBN" name="ISBN" required type="text" value="">
        </div>
        <div class="form-group  required"><label class="control-label" for="bookname">Book Name</label>
        <input class="form-control" id="bookname" name="bookname" required type="text" value="">
        </div>
 		<input class="btn btn-default" id="submit" name="submit" type="submit" value="Comfirm">
	 	<input class="btn btn-default" id="submit" name="submit" type="submit" value="Cancel" onclick="buttonCancel()">
 
		</form>
	</div>
</body>
</html>