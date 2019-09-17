<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form:form method="post" modelAttribute="person">
        Login: <form:input path="login"/>
        Password: <form:password path="password"/>
        Email: <form:input path="email"/>
        <input type="submit" value="Save">
    </form:form>
</body>
</html>
