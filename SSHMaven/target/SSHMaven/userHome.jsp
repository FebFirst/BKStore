<!-- 
	Author:Xiong Guo (febfirst)
	Designer:
	Todo:Home page of this webside
	Known bugs:
-->
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.User" %>
<% if(session.getAttribute("username") == null) {
	out.println("<script>window.location.href='home.jsp'</script>");
}
%>
<html lang="en" dir="ltr">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Welcome to feb's home</title>
		
		<link href="myCss/style.css" rel="stylesheet">
    	<link href="bootstrap-3.3.5-dist/css/bootstrap.min.css" rel="stylesheet">
   	 	<link href="bootstrap-table-master/dist/bootstrap-table.min.css" rel="stylesheet">
    	<link href="bootstrap-table-master/src/bootstrap-table.css" rel="stylesheet">
   		 <script type="text/javascript" src="jQuery/jquery-2.2.4.min.js"></script>
   		 <script src="bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
    	<script src="bootstrap-table-master/dist/bootstrap-table.min.js" ></script>
    	<script src="bootstrap-table-master/dist/bootstrap-table-locale-all.min.js" ></script>
		<script type="text/javascript">
		
		function buttonCancel()
		{
			
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
		$(document).ready(function(){
			  $("#btnajax").click(function(){
			    $('#test').load('/example/jquery/demo_test.txt');
			  })
			})
		$.post("/SSHMaven/userCart.action", function(result){
			$("#xg").text(JSON.stringify(result));
		});
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
    			if(((User)session.getAttribute("username"))!=null) {
    				if(((User)session.getAttribute("username")).getUsername().equals("Catherine")) { %>
        			<%="Elegant VIP: " %><%}
    			%>
    			<%=((User)session.getAttribute("username")).getUsername() %>
    			<%
    			}
   				 %>
            	</a></li>
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
			
		<thead id="msn">
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
	<button 
		type="button" class="btn btn-default" data-toggle="collapse" data-target="#buy">buy
   	</button>
   	<button 
		type="button" class="btn btn-default" data-toggle="collapse" data-target="#order">My Cart
   	</button>
   	<button 
		type="button" class="btn btn-default" data-toggle="collapse" data-target="#history">History
   	</button>
	<div id="buy" class="collapse">
		<form action="buyBook" method="post" class="form" role="form">
		<div class="form-group  required"><label class="control-label" for="ISBN">ISBN</label>
        <input class="form-control" id="ISBN" name="ISBN" required type="text" value="">
        </div>
        <div class="form-group  required"><label class="control-label" for="number">Number</label>
        <input class="form-control" id="number" name="number" required type="text" value="">
        </div>
        <div class="collapse">
        <input id="username" name="username" required type="text" value="
       		 <%=((User)session.getAttribute("username")).getUsername() %>">
        </div>
 		<input class="btn btn-default" id="submit" name="submit" type="submit" value="Comfirm">
	 	<input class="btn btn-default" id="submit" name="submit" type="submit" value="Cancel" onclick="buttonCancel()">
 
		</form>
	</div>
	
	<div id="order" class="collapse">
		<div>
			<table data-toggle="table"  
	 			style="width:100%;height:350px"
				data-url="/SSHMaven/userCart.action"
				data-row-style="rowStyle"
				data-classes="table table-hover table-condensed"
       			data-striped="true"
       			data-show-columns="true">
			
			<thead>
				<tr >
					 <th data-formatter="runningFormatter">Index</th>
					<th data-field="ISBN" data-visible="false">ISBN</th>
					<th data-field="ID" data-visible="true">Cart ID</th>
					<th data-field="bookName" data-switchable="false">Book Name</th>
					<th data-field="author" >Author</th>
					<th data-field="number" >Number</th>
					<th data-field="date" >Date</th>
					<th data-field="price" >Price</th>
				</tr>
			</thead>
			</table>
		</div>
		<div>
		<form action="payOrders.action" method="post" class="form" role="form">
		<div class="form-group  required"><label class="control-label" for="id">ID</label>
        <input class="form-control" id="id" name="id" required type="text" value="">
        </div>
        <div class="collapse">
         <input id="username" name="username" required type="text" value="
       		 <%=((User)session.getAttribute("username")).getUsername() %>">
        </div>
		<input class="btn btn-default" id="submit" name="submit" type="submit" value="Pay">
	 	<input class="btn btn-default" id="submit" name="submit" type="submit" value="Cancel">
		</form>
		</div>
	</div>
	<div id="history" class="collapse">
		<div>
			<table data-toggle="table"  
	 			style="width:100%;height:350px"
				data-url="/SSHMaven/userOrder.action"
				data-row-style="rowStyle"
				data-classes="table table-hover table-condensed"
       			data-striped="true"
       			data-show-columns="true">
			
			<thead>
				<tr >
					 <th data-formatter="runningFormatter">Index</th>
					<th data-field="ISBN" data-visible="false">ISBN</th>
					<th data-field="ID" data-visible="true">Order ID</th>
					<th data-field="bookName" data-switchable="false">Book Name</th>
					<th data-field="author" >Author</th>
					<th data-field="number" >Number</th>
					<th data-field="date" >Date</th>
					<th data-field="price" >Price</th>
				</tr>
			</thead>
			</table>
		</div>
	</div>
	<!-- <div id = "xg"></div> -->
</body>
</html>