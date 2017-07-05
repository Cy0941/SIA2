<%--
  Created by IntelliJ IDEA.
  User: charl
  Date: 2017/6/14
  Time: 23:53
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" isELIgnored="false" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Spittle</title>
</head>
<body>
<div class="spittleView">
    <div class="spittleMsg">
        <c:out value="${spittle.message}"/>
    </div>
    <div class="spittleTime">
        <c:out value="${spittle.time}"/>
    </div>
</div>
</body>
</html>
