<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <script>
        function confirmDelete(id, name) {
            if (confirm("Do you want to delete a author '" + name + "'?")) {
                window.location.href = "/authors/delete/" + id;
            }
        }
    </script>
</head>
<body>

<a href="/authors/add">Add author</a>

<br><br>

<table border="1">
    <tr>
        <th>First name</th>
        <th>Last name</th>
        <th>Actions</th>
    </tr>
    <c:forEach items="${authors}" var="author">
        <tr>
            <td>${author.firstName}</td>
            <td>${author.lastName}</td>
            <td>
                <a href="/authors/update/${author.id}">Edit</a>
                <a href="#" onclick="confirmDelete(${author.id}, '${author.fullName}')">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
