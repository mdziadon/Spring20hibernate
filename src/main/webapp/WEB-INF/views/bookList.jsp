<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="<c:url value="/webjars/jquery/3.0.0/jquery.min.js"/>"></script>
    <script src="<c:url value="/webjars/bootstrap/4.3.1/js/bootstrap.min.js"/>"></script>
    <link href="<c:url value="/webjars/bootstrap/4.3.1/css/bootstrap.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/main.css"/>" rel="stylesheet">
    <script>
        function confirmDelete(id, title) {
            if (confirm("Do you want to delete a book '" + title + "'?")) {
                window.location.href = "/books/delete/" + id;
            }
        }
    </script>
</head>
<body>

<%@include file="/WEB-INF/views/header.jspf"%>

<div class="container">

    <header>Books</header>

    <div class="card">
        <div class="card-body">
            <a href="/books/add" class="btn btn-primary">Dodaj książkę</a>
        </div>
    </div>

    <div class="card mt-4">
        <div class="card-body">
            <table class="table table-hover">
                <tr>
                    <th>Title</th>
                    <th>Rating</th>
                    <th>Publisher</th>
                    <th>Authors</th>
                    <th style="width:17%">Actions</th>
                </tr>
                <c:forEach items="${books}" var="book">
                    <tr>
                        <td>${book.title}</td>
                        <td>${book.rating}</td>
                        <td>${book.publisher.name}</td>
                        <td>
                            <c:forEach items="${book.authors}" var="author">
                                ${author.fullName},
                            </c:forEach>
                        </td>
                        <td>
                            <a href="/books/update/${book.id}" class="btn btn-success">Edit</a>
                            <a href="#" onclick="confirmDelete(${book.id}, '${book.title}')" class="btn btn-danger">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>

</div>
</body>
</html>
