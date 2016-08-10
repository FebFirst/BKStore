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
		 

		$.post("/SSHMaven/listUser.action", function(result){
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
            <li> <img src="/SSHMaven/getPhoto.action"
   	class="img-circle img-responsive" height="50" width="50"></li>
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
			data-url="/SSHMaven/listUser.action"
			data-row-style="rowStyle"
			data-classes="table table-hover table-condensed"
       		data-striped="true"
       		data-search="true"
       		data-pagination=“true”
       		data-show-columns="true">
			
		<thead>
			<tr >
		
				<th data-field="userName" >User</th>
				<th data-field="passWord" >Number</th>
				<th data-field="phone" >Phone number</th>
				<th data-field="email" >email</th>
				
			</tr>
		</thead>
	</table>
	
	</div>
	<!-- <ul id="fenye" class="pagination-md"></ul> -->
	<div class="but-group" style="padding-right:100px" >
	<button 
		type="button" class="btn btn-default" data-toggle="collapse" data-target="#date">Delete
   	</button>
   	<button 
		type="button" class="btn btn-default" data-toggle="collapse" data-target="#name">Add
   	</button>
   	<button 
		type="button" class="btn btn-default" data-toggle="collapse" data-target="#update">update
   	</button>
	</div>
	
	<div id="date" class="collapse">
		<form action="deleteUser" method="post" class="form" role="form">
		<div class="form-group  required"><label class="control-label" for="date">username</label>
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
	<div id="update" class="collapse">
		<form action="changeprofile" method="post" class="form" role="form">
		<div class="form-group  required"><label class="control-label" for="username">username</label>
        <input class="form-control" placeholder="input to modify" id="username" name="username" required type="text" value="">
        </div>
		<div class="form-group  required"><label class="control-label" for="password">password</label>
        <input class="form-control" placeholder="input to modify" id="password" name="password" required type="text" value="">
        </div>
        <div class="form-group  required"><label class="control-label" for="phone">phone</label>
        <input class="form-control" placeholder="input to modify" id="phone" name="phone" required type="text" value="">
        </div>
        <div class="form-group  required"><label class="control-label" for="email">email</label>
        <input class="form-control" placeholder="input to modify" id="email" name="email" required type="text" value="">
        </div>
 		<input class="btn btn-default" id="submit" name="submit" type="submit" value="Comfirm">
	 	<input class="btn btn-default" id="submit" name="submit" type="submit" value="Cancel" onclick="buttonCancel()">
 
		</form>
	</div>
	<!-- <div id ="xg"></div> -->
</body>
</html>