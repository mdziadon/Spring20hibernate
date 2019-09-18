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
            <form:errors path="title" element="div"/>
        </div>
        <div>
            <label>Rating:
                <form:select path="rating">
                    <c:forEach begin="1" end="10" var="number">
                        <form:option value="${number}"/>
                    </c:forEach>
                </form:select>
            </label>
            <form:errors path="rating" element="div"/>
        </div>
        <div>
            <label>Pages:
                <form:input path="pages" type="number"/>
            </label>
            <form:errors path="pages" element="div"/>
        </div>

        <div>
            <label>Description:
                <form:textarea path="description" rows="3" cols="60"/>
            </label>
            <form:errors path="description" element="div"/>
        </div>
        <div>
            <label>Publisher:
                <form:select path="publisher.id" items="${publishers}" itemLabel="name" itemValue="id"/>
            </label>
            <form:errors path="publisher" element="div"/>
        </div>

        <div>
            <label>Authors:
                <form:select path="authors" items="${authors}" itemLabel="fullName" itemValue="id"/>
            </label>
            <form:errors path="authors" element="div"/>
        </div>

        <input type="submit" value="Save">
    </form:form>
</body>
</html>
