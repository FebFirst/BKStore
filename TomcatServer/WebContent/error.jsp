<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="model.book"%>
<%@ page import="java.util.*"%>
<%@ page import="java.sql.*"%>
<%@ page import="service.bookService" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome to feb's home</title>
</head>
<body>
	<dev>
	 <%-- <center><h2>
	<%List<book> books = bookService.getAllBooks();
	JSONArray ja = new JSONArray();
		for(book i : books){
			JSONObject jo = new JSONObject();
			jo.put("ISBN",i.getISBN());
			jo.put("bookname", i.getBookName());
			jo.put("author", i.getAuthor());
			jo.put("price", i.getPrice());
			ja.add(jo);
		}%>
	<%=ja.get(0).toString() %>
	</h2></center>  --%>
	 <center><h2><%
    if(request.getSession().getAttribute("message")!=null) {
    %>
    <%=request.getSession().getAttribute("message") %>
    <%
    request.getSession().removeAttribute("message");
    }
   	%></h2></center>
   	</dev>
   	<dev>
   	 <li><a href="<%=request.getSession().getAttribute("index") %>"><center><h2>Back</h2></center></a></li> 
   	</dev>
</body>
</html>