<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form:form method="post" modelAttribute="author">
    <div>
        <label for="firstNameId">First name:</label>
        <form:input type="text" path="firstName" id="firstNameId"/>
    </div>

    <div>
        <label for="lastNameId">Last name:</label>
        <form:input type="text" path="lastName" id="lastNameId"/>
    </div>

    <input type="submit" value="Save">
</form:form>
</body>
</html>
