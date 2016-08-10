<%--
  Created by IntelliJ IDEA.
  User: apple
  Date: 16/6/7
  Time: 下午7:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% if(session.getAttribute("username") != null) {
	session.removeAttribute("username");
}
%>
<html>
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
		function rowStyle(row, index) 
		{
		    var classes = ['active', 'active', 'active', 'active', 'active'];
		    if (index % 2 === 0 && index / 2 < classes.length) {
		        return {
		            classes: classes[index / 2]
		        };
		    }
		    return {};
		}
		function runningFormatter(value, row, index) 
		{
		    return index;
		}
		$.post("/SSHMaven/listBook.action", function(result){
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
        <!--navbar right-->
        <div id="nav-content" class="navbar-collapse collapse" style="">
            <ul class="nav navbar-nav navbar-right" style="padding-right:10px">
                 <li><a id="navbar-brand" class="navbar-brand" hrep="/">
                 <li><a href="logIn.jsp">Log In</a></li>
                 <li><a href="signUp.html">Sign Up</a></li>
                
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
				<th data-field="ISBN" data-visible="true">ISBN</th>
				<th data-field="author"  >Author</th>
				<th data-field="bookName" data-switchable="false">Name</th>
				<th data-field="catename" >Category</th>
				<th data-field="price" >Price</th>
			</tr>
		</thead>
	</table>
	
	</div>
 <!--  <div id="xg"></div> -->
	
</body>
</html>