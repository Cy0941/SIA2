<%--
  Created by IntelliJ IDEA.
  User: charl
  Date: 2017/6/14
  Time: 23:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Register</title>
    <link rel="stylesheet" type="text/css" href="/static/style.css"/>
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
    <%--cxy 防止跨站请求伪造 csrf --%>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <input type="submit" value="Register">
</form>

<%--
    采用 Spring 标签库实现表单提交
    cxy commandName/modelAttribute - 到达此页面前model/modelAndView中需要有对应名称的model；提交表单时会包装为此名称的model；发生错误返回时，同样使用此名称的model进行回填
--%>
<sf:form method="post" modelAttribute="spitter">
    <%-- 二、cxy 将所有的错误信息集中显示【原错误输入域不发生变化】--%>
    <sf:errors path="*" element="div" cssClass="error"/>

    <%-- 一、根据对应的属性单独设置详细的错误信息【原错误输入域不发生变化】--%>
    FirstName:<sf:input path="firstName"/><sf:errors path="firstName" cssClass="error"/><br/>

    <%-- 三、cxy 配合全局错误显示，加入错误输入域提示【cssErrorClass】--%>
    LastName:<sf:input path="lastName" cssErrorClass="error"/><br/>

    <%--此label标签的path属性没有完成太多功能，其 cssErrorClass 属性在该输入域返回错误时将进行标识--%>
    <sf:label path="userName" cssErrorClass="error">UserName:</sf:label><sf:input path="userName"/><br/>
    Password:<sf:password path="password"/><br/>
    <input type="submit" value="Register"/>
</sf:form>
</body>
</html>
