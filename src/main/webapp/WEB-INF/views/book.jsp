<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="<c:url value="/webjars/jquery/3.0.0/jquery.min.js"/>"></script>
    <script src="<c:url value="/webjars/bootstrap/4.3.1/js/bootstrap.min.js"/>"></script>
    <link href="<c:url value="/webjars/bootstrap/4.3.1/css/bootstrap.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/main.css"/>" rel="stylesheet">
</head>
<body>

<%@include file="/WEB-INF/views/header.jspf"%>

<div class="container">

    <header>${empty book.id ? 'Add Book' : 'Edit Book'}</header>

    <div class="card">
        <div class="card-body">
            <a href="/books/list" class="btn btn-primary">Back</a>
        </div>
    </div>

    <div class="card mt-4">
        <div class="card-body">

            <form:form method="post" modelAttribute="book">

                <form:hidden path="id" value="${book.id}"/>

                <div class="row">
                    <div class="form-group col-md-6">
                        <label for="titleId">Title:</label>
                        <form:input path="title" class="form-control" id="titleId"/>
                        <form:errors path="title" element="div" cssClass="error"/>
                    </div>
                    <div class="form-group col-md-3">
                        <label for="ratingId">Rating:</label>
                        <form:select path="rating" class="form-control" id="ratingId">
                            <c:forEach begin="1" end="10" var="number">
                                <form:option value="${number}"/>
                            </c:forEach>
                        </form:select>
                        <form:errors path="rating" element="div" cssClass="error"/>
                    </div>
                    <div class="form-group col-md-3">
                        <label for="pagesId">Pages:</label>
                        <form:input path="pages" type="number" class="form-control" id="pagesId"/>
                        <form:errors path="pages" element="div" cssClass="error"/>
                    </div>

                </div>

                <div class="row">
                    <div class="form-group col-md-6">
                        <label for="publisherId">Publisher:</label>
                        <form:select path="publisher.id" items="${publishers}" itemLabel="name" itemValue="id" class="form-control" id="publisherId"/>
                        <form:errors path="publisher" element="div" cssClass="error"/>
                    </div>

                    <div class="form-group col-md-6">
                        <label for="authorsId">Authors:</label>
                        <form:select path="authors" items="${authors}" itemLabel="fullName" itemValue="id" class="form-control" id="authorsId"/>
                        <form:errors path="authors" element="div" cssClass="error"/>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-md-12">
                        <label for="descriptionId">Description:</label>
                        <form:textarea path="description" rows="3" cols="60" class="form-control" id="descriptionId"/>
                        <form:errors path="description" element="div" cssClass="error"/>
                    </div>
                </div>

                <input type="submit" value="Save" class="btn btn-primary">
            </form:form>
        </div>
    </div>

</div>
</body>
</html>
