<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form:form method="post" modelAttribute="book">

        <form:hidden path="id" value="${book.id}"/>
        <div>
            <label>Title:
                <form:input path="title"/>
            </label>
        </div>
        <div>
            <label>Rating:
                <form:select path="rating">
                    <c:forEach begin="1" end="10" var="number">
                        <form:option value="${number}"/>
                    </c:forEach>
                </form:select>
            </label>
        </div>
        <div>
            <label>Description:
                <form:textarea path="description" rows="3" cols="60"/>
            </label>
        </div>
        <div>
            <label>Publisher:
                <form:select path="publisher.id" items="${publishers}" itemLabel="name" itemValue="id"/>
            </label>
        </div>
        <input type="submit" value="Save">
    </form:form>
</body>
</html>
