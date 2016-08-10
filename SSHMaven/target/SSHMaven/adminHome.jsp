<!-- 
	Author:Xiong Guo (febfirst)
	Designer:
	Todo:Home page of this webside
	Known bugs:
-->
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
 <%@ page import="model.User" %>
<% if(!((User)session.getAttribute("username")).getUsername().equals("feb")) {
	out.println("<script>window.location.href='home.jsp'</script>");
}
%>
<html lang="en" dir="ltr">

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
    			if(session.getAttribute("username")!=null) {
    			%>
    			<%=((User)session.getAttribute("username")).getUsername() %>
    			<%
    			}
   				 %>
            	</a></li>
            	<li><a href="order.jsp">Order</a></li>
            	<li><a href="user.jsp">User</a></li>
            	<li><a href="profile.jsp">Profile</a></li>
                <li><a href="home.jsp">Log Out</a></li>
                
            </ul>
        </div>
    </div>
</div>
	<div class="container-fluid" style="margin-top:70px">
	<div> 
		<a id="navbar-brand" class="navbar-brand" hrep="/">
                Here are books available! Enjoy!
        </a>
	</div>
	<table data-toggle="table"  
	 style="width:100%;height:350px"
			data-url="/SSHMaven/listBook.action"
			data-row-style="rowStyle"
			data-classes="table table-hover table-condensed"
       		data-striped="true"
       		data-search="true"
       		data-show-columns="true">
			
		<thead>
			<tr >
			 	<th data-formatter="runningFormatter">Index</th>
				<th data-field="ISBN" data-visible="false">ISBN</th>
				<th data-field="author"  data-search="true">Author</th>
				<th data-field="bookName" data-switchable="false" data-search="true">Name</th>
				<th data-field="catename" data-search="true">Category</th>
				<th data-field="price" data-search="true">Price</th>
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
		<form action="deleteBook" method="post" class="form" role="form">
		<div class="form-group  required"><label class="control-label" for="ISBN">ISBN</label>
        <input class="form-control" id="ISBN" name="ISBN" required type="text" value="">
        </div>
 		<input class="btn btn-default" id="submit" name="submit" type="submit" value="Comfirm">
	 	<input class="btn btn-default" id="submit" name="submit" type="submit" value="Cancel" onclick="buttonCancel()">
 
		</form>
	</div>
	<div id="add" class="collapse">
		<form action="addBook" method="post" class="form" role="form">
		<div class="form-group  required"><label class="control-label" for="ISBN">ISBN</label>
        <input class="form-control" id="ISBN" name="ISBN" required type="text" value="">
        </div>
         <div class="form-group  required"><label class="control-label" for="bookName">Book Name</label>
        <input class="form-control" id="bookName" name="bookName" required type="text" value="">
        </div>
         <div class="form-group  required"><label class="control-label" for="author">Author</label>
        <input class="form-control" id="author" name="author" required type="text" value="">
        </div>
         <div class="form-group  required"><label class="control-label" for="cateID">Category</label>
        <input class="form-control" id="cateID" name="cateID" required type="text" value="">
        </div>
         <div class="form-group  required"><label class="control-label" for="price">Price</label>
        <input class="form-control" id="price" name="price" required type="number" value="">
        </div>
 		<input class="btn btn-default" id="submit" name="submit" type="submit" value="Comfirm">
	 	<input class="btn btn-default" id="submit" name="submit" type="submit" value="Cancel" onclick="buttonCancel()">
 
		</form>
	</div>
	<div id="update" class="collapse">
		<form action="updateBook" method="post" class="form" role="form">

		<div class="form-group  required"><label class="control-label" for="ISBN">ISBN</label>
        <input class="form-control" id="ISBN" name="ISBN" required type="text" value="">
        </div>
         <div class="form-group  required"><label class="control-label" for="bookName">Book Name</label>
        <input class="form-control" id="bookName" name="bookName" required type="text" value="">
        </div>
         <div class="form-group  required"><label class="control-label" for="author">Author</label>
        <input class="form-control" id="author" name="author" required type="text" value="">
        </div>
         <div class="form-group  required"><label class="control-label" for="cateID">Category</label>
        <input class="form-control" id="cateID" name="cateID" required type="text" value="">
        </div>
         <div class="form-group  required"><label class="control-label" for="price">Price</label>
        <input class="form-control" id="price" name="price" required type="number" value="">
        </div>
 		<input class="btn btn-default" id="submit" name="submit" type="submit" value="Comfirm">
	 	<input class="btn btn-default" id="submit" name="submit" type="submit" value="Cancel" onclick="buttonCancel()">
 
		</form>
	</div>
</body>
</html>