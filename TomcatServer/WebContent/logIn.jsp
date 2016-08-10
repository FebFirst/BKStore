<!-- 
	Author:Xiong Guo (febfirst)
	Designer:
	Todo:Log in page
	Known bugs:
-->

<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">


<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta charset="UTF-8">
		<link href="scripts/bootstrap-3.3.5-dist/css/bootstrap.min.css" rel="stylesheet">
		<title>Welcome to feb's home</title>
		<script type="text/javascript">
			function buttonCancel()
			{
				window.location.href="home.jsp";
			}
		</script>
	</head>
<body>
<div id="navbar" class="navbar navbar-default navbar-fixed-top" role="navigation" style="">
    <div class="container-fuild">
        <div class="navbar-header">
            <a id="navbar-brand" class="navbar-brand" hrep="/">
                Welcome to feb's home
            </a>
        </div>
        <!--navbar right-->
        <div id="nav-content" class="navbar-collapse collapse" style="">
            <ul class="nav navbar-nav navbar-right" style="padding-right:10px">
                
                <li><a href="signUp.jsp">Sign up</a></li>
                
            </ul>
        </div>
    </div>
</div>
            
<div class="container-fuild" style="margin-top:50px;">
     <div class="row">
        <div class="col-sm-5 col-md-offset-4 col-md-4">
            <div class="page-header">
                <h1>
                    Log in
                </h1>
            </div>
<form action="logInServlet" method="post" class="form" role="form">
  <!-- <div style="display:none;"><input id="csrf_token" name="csrf_token" type="hidden" value="1459092251##45ebf4de4f2d523b8c222db5bc89c43604ce08a6"></div> -->

<div class="form-group  required"><label class="control-label" for="logname">user name</label>
        <input class="form-control" id="logname" name="logname" required type="text" value="">
        </div>

<div class="form-group  required"><label class="control-label" for="password">password</label>
        <input class="form-control" id="password" name="password" required type="password" value="">
        </div>
  
 <input class="btn btn-default" id="submit" name="submit" type="submit" value="Log in">
 <input class="btn btn-default" id="submit" name="submit" type="submit" value="Cancel" onclick="buttonCancel()">
 
 
 <p><i>New user? Press the buttom on the right to sign up!</i></p>

 </form>
</div>
</div>
</div> 

</body>
</html>