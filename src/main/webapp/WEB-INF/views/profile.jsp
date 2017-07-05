<%--
  Created by IntelliJ IDEA.
  User: charl
  Date: 2017/6/15
  Time: 0:15
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" pageEncoding="UTF-8" session="false" %>
<html>
<head>
    <title>Profile</title>
</head>
<body>
<h1>Your Profile</h1>
<c:out value="${spitter.username}"/>
<c:out value="${spitter.firstName}"/>
<c:out value="${spitter.lastName}"/>
</body>
</html>
