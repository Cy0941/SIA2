<%--
  Created by IntelliJ IDEA.
  User: charl
  Date: 2017/6/14
  Time: 23:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
<h1>Register</h1>
<%--
    cxy 此时没有设置 action 属性，表示表单提交时，它会提交到与展现时相同的URL路径上
--%>
<form method="post">
    FirstName:<input type="text" name="firstName"><br/>
    LastName:<input type="text" name="lastName"><br/>
    Username:<input type="text" name="userName"><br/>
    Password:<input type="password" name="password"><br/>
    <input type="submit" value="Register">
</form>
</body>
</html>
