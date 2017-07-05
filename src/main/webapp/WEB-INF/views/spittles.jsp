<%--
  Created by IntelliJ IDEA.
  User: charl
  Date: 2017/6/14
  Time: 0:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" isELIgnored="false" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Spittles</title>
</head>
<body>
<h2>Recent Spittles</h2>
<c:forEach items="${spittleList}" var="spittle">
    <li id="spittle_<c:out value="spittle.id"/>">
        <div class="dpittleMessage">
            <c:out value="${spittle.message}"/>
        </div>
        <div>
            <span class="spittleTime"><c:out value="${spittle.time}"/></span>
            <span class="spittleLocation">
                    (<c:out value="${spittle.latitude}"/>,
                    <c:out value="${spittle.longitude}"/>)
                </span>
        </div>
    </li>
</c:forEach>
</body>
</html>
