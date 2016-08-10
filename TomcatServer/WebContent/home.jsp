<!-- 
	Author:Xiong Guo (febfirst)
	Designer:
	Todo:Home page of this webside
	Known bugs:
-->
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% if(request.getSession().getAttribute("logname") != null) {
	request.getSession().removeAttribute("logname");
}
%>
<html lang="en" dir="ltr">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Welcome to feb's home</title>
		<script type="text/javascript" src="scripts/jquery-2.2.2.min.js"></script>
		<link href="scripts/bootstrap-3.3.5-dist/css/bootstrap.min.css" rel="stylesheet">
		<link href="scripts/bootstrap-table-master/dist/bootstrap-table.min.css" rel="stylesheet">
		<link href="scripts/bootstrap-table-master/src/bootstrap-table.css" rel="stylesheet">
		<script src="scripts/bootstrap-table-master/dist/bootstrap-table.min.js" ></script>
		<script src="scripts/bootstrap-table-master/dist/bootstrap-table-locale-all.min.js" ></script>
		<script type="text/javascript">
		
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
        <!--navbar right-->
        <div id="nav-content" class="navbar-collapse collapse" style="">
            <ul class="nav navbar-nav navbar-right" style="padding-right:10px">
                 <li><a id="navbar-brand" class="navbar-brand" hrep="/">
                 <li><a href="logIn.jsp">Log In</a></li>
                
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
			data-url="/TomcatServer/listBook"
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
	
</body>
</html>