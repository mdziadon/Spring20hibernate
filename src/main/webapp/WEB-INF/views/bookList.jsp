<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script>
        function confirmDelete(id, title) {
            if (confirm("Do you want to delete a book '" + title + "'?")) {
                window.location.href = "/books/delete/" + id;
            }
        }
    </script>
</head>
<body>
    <div>
        <a href="/books/add">Dodaj książkę</a>
    </div>

    <table border="1">
        <tr>
            <th>Title</th>
            <th>Rating</th>
            <th>Publisher</th>
            <th>Authors</th>
            <th>Actions</th>
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
                    <a href="/books/update/${book.id}">Edit</a>
                    <a href="#" onclick="confirmDelete(${book.id}, '${book.title}')">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
