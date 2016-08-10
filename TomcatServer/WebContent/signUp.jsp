<!-- 
	Author:Xiong Guo (febfirst)
	Designer:
	Todo:Sign up page of the webside
	Known bugs:
-->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta charset="UTF-8">
		<link href="scripts/bootstrap-3.3.5-dist/css/bootstrap.min.css" rel="stylesheet">
		<link href="scripts/jquery-easyui-1.4.3/themes/bootstrap/easyui.css" rel="stylesheet">
		<title>Welcome to feb's home</title>
		<script type="text/javascript">
			function buttonCancel()
			{
				window.location.href="logIn.jsp";
			}
		</script>
</head>
<body>
<div id="navbar" class="navbar navbar-default navbar-fixed-top" role="navigation" style="">
    <div class="container-fuild">
        <div class="navbar-header">
            <a id="navbar-brand" class="navbar-brand" hrep="/">
                Welcome to Feb Book Store
            </a>
        </div>
        <!--navbar right-->
        <div id="nav-content" class="navbar-collapse collapse" style="">
            <ul class="nav navbar-nav navbar-right" style="padding-right:10px">
                
                <li><a href="home.jsp">Home</a></li>
                
            </ul>
        </div>
    </div>
</div>
            
<div class="container-fuild" style="margin-top:50px;">
     <div class="row">
        <div class="col-sm-5 col-md-offset-4 col-md-4">
            <div class="page-header">
                <h1>
                    Sign up
                </h1>
            </div>
<form action="signUpServlet" method="post" class="form" role="form">
  <!-- <div style="display:none;"><input id="csrf_token" name="csrf_token" type="hidden" value="1459092251##45ebf4de4f2d523b8c222db5bc89c43604ce08a6"></div> -->

		<div class="form-group  required"><label class="control-label" for="username">user name</label>
        <input class="form-control" id="username" name="username" required type="text" value="">
        </div>

		<div class="form-group  required"><label class="control-label" for="password">password</label>
        <input class="form-control" id="password" name="password" required type="password" value="">
        </div>
 
		<div class="form-group  required"><label class="control-label" for="password">password confirmation</label>
        <input class="form-control" id="passwdchk" name="passwdchk" required type="password" value="">
    	</div>
 		<input class="btn btn-default" id="submit" name="submit" type="submit" value="Sign up">
	 	<input class="btn btn-default" id="submit" name="submit" type="submit" value="Cancel" onclick="buttonCancel()">
 
 </form>
</div>
</div>
</div> 

</body>
</html>