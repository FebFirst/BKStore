<!-- 
	Author:Xiong Guo (febfirst)
	Designer:
	Todo:Home page of this webside
	Known bugs:
-->
<!DOCTYPE html>
<%@ page language="java"  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
		 $(function()
			        {
			            $("#button").click(function()
			            {
			                var html = $("<input type='file' name='file'>");
			                var button = $("<input type='button' name='button' value='删除'><br>");
			                
			                $("#body div").append(html).append(button);
			                
			                button.click(function()
			                {
			                    html.remove();
			                    button.remove();
			                })
			            })
			        })
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
             <li> <img src="/SSHMaven/getPhoto.action"
   	class="img-circle img-responsive" height="50" width="50"></li>
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
            	<li><a href="<%if(((User)session.getAttribute("username")).getUsername().equals("feb")) { %>
        			<%="adminHome.jsp" %><%} else{%>
        			<%="userHome.jsp" %><%}%>">Home</a></li>
                <li><a href="home.jsp">Log Out</a></li>
                
            </ul>
        </div>
    </div>
</div>
<div class="container-fuild" style="margin-top:50px;">
     <div class="row">
        <div class="col-sm-5 col-md-offset-4 col-md-4">
            <div class="page-header">
                <h1>
                    My Profile
                </h1>
            </div>
	<div>
	<div><img src="/SSHMaven/getPhoto.action"
   	class="img-circle" name="My icon">
	</div>
	<form class="form" role="form">
		<div class="form-group  required"><label class="control-label" for="username">username</label>
        <input class="btn btn-default" id="username" name="username" required type="text" value="
        <%=((User)session.getAttribute("username")).getUsername()%>">
        </div>
        <div class="form-group  required"><label class="control-label" for="password">password</label>
        <input class="btn btn-default" id="password" name="password" required type="text" value="
        <%=((User)session.getAttribute("username")).getPassword()%>">
        </div>
        <div class="form-group  required"><label class="control-label" for="phone">phone number</label>
        <input class="btn btn-default" id="phone" name="phone" required type="text" value="
        <%=((User)session.getAttribute("username")).getPhone()%>">
        </div>
        <div class="form-group  required"><label class="control-label" for="number">Email</label>
        <input class="btn btn-default" id="email" name="email" required type="text" value="
        <%=((User)session.getAttribute("username")).getEmail()%>">
        </div>
		</form></div>
	<div class="but-group" style="padding-right:100px" >
	<button 
		type="button" class="btn btn-default" data-toggle="collapse" data-target="#change">Modify
   	</button>
   	<button 
		type="button" class="btn btn-default" data-toggle="collapse" data-target="#photo">upload photo
   	</button>
   	</div>
   	<div id="photo" class="collapse">
	<form action="uploadPhoto" method="post" class="form" role="form" enctype="multipart/form-data">
		<div class="collapse">
        <input id="username" name="username" required type="text" value="
       		 <%=((User)session.getAttribute("username")).getUsername()%>">
        </div>
        <div class="form-group  required"><label class="control-label" for="photo">photo</label>
        <input class="form-control" placeholder="upload your photo" id="photo" name="photo" required type="file" value="">
        </div>
        <input class="btn btn-default" id="submit" name="submit" type="submit" value="Comfirm">
	 	<input class="btn btn-default" id="submit" name="submit" type="submit" value="Cancel" onclick="buttonCancel()">
 
        </form>
	</div>
	<div id="change" class="collapse">
		<form action="changeprofile" method="post" class="form" role="form">
		<div class="form-group  required"><label class="control-label" for="password">password</label>
        <input class="form-control" placeholder="input to modify" id="password" name="password" required type="text" value="">
        </div>
        <div class="form-group  required"><label class="control-label" for="phone">phone</label>
        <input class="form-control" placeholder="input to modify" id="phone" name="phone" required type="text" value="">
        </div>
        <div class="form-group  required"><label class="control-label" for="email">email</label>
        <input class="form-control" placeholder="input to modify" id="email" name="email" required type="text" value="">
        </div>
        <div class="collapse">
        <input id="username" name="username" required type="text" value="
       		 <%=((User)session.getAttribute("username")).getUsername()%>">
        </div>
 		<input class="btn btn-default" id="submit" name="submit" type="submit" value="Comfirm">
	 	<input class="btn btn-default" id="submit" name="submit" type="submit" value="Cancel" onclick="buttonCancel()">
 
		</form>
	</div>
	
	</div>
	</div>
	</div>
	<!-- <div id = "xg"></div> -->
</body>

</html>