<%--
  Created by IntelliJ IDEA.
  User: apple
  Date: 16/6/5
  Time: 上午10:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ page import="model.User" %>--%>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.5">
    <link href="myCss/logIn.css" rel="stylesheet">
    <title>Poetry of Time</title>
</head>
<body>
<div class="wrapper">
    <div class="navbar-left">
        <a><h1>Poetry of Time</h1></a>
    </div>
    <div class="navbar-right">
            <button><a href="signUp.html">sign up</a></button>
    </div>
    <div class="container">
        <h1>Welcome</h1>
        <form action="logIn" method="post" class="form">
            <input type="text" id="username" name="username" placeholder="username">
            <input type="password" id="password" name="password" placeholder="password">
            <button type="submit" id="login-button">log in</button>
            <h4>New user? Press the button on the right to sign up</h4>
        </form>
    </div>
    <ul class="bg-bubbles">
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
    </ul>
</div>
<script type="text/javascript" src="jQuery/jquery-2.2.4.min.js"></script>

</body>
</html>
