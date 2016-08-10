<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% if(session.getAttribute("username") == null) {
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
    			if(session.getAttribute("logname")!=null) {
    			if(session.getAttribute("logname").equals("Catherine")) { %>
    			<%="Elegant VIP: " %><%} %>
    			<%=session.getAttribute("logname") %>
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
			data-url="/SSHMaven/listOrderByUD.action"
			data-row-style="rowStyle"
			data-classes="table table-hover table-condensed"
       		data-striped="true"
       		data-show-columns="true">
			
		<thead>
			<tr>
			 	<th data-formatter="runningFormatter">Index</th>
				<th data-field="ISBN" data-visible="false">ISBN</th>
				<th data-field="bookName" data-switchable="false">Book Name</th>
				<th data-field="user" >User</th>
				<th data-field="number" >Number</th>
				<th data-field="date" >Date</th>
				<th data-field="price" >Price</th>
			</tr>
		</thead>
	</table>
	<div><p>Book sold number: <%=session.getAttribute("number") %></p></div>
	<div><p>Money earned: <%=session.getAttribute("earn") %></p></div>
</body>
</html>