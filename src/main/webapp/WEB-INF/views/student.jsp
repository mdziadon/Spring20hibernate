<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="post" modelAttribute="student">
    <div>
        <label for="firstNameId">First name:</label>
        <form:input type="text" path="firstName" id="firstNameId"/>
    </div>

    <div>
        <label for="lastNameId">Last name:</label>
        <form:input type="text" path="lastName" id="lastNameId"/>
    </div>

    <div>
        <label for="maleId">Male:</label>
        <form:radiobutton path="gender" value="M" id="maleId"/>
        <label for="femaleId">Female:</label>
        <form:radiobutton path="gender" value="F" id="femaleId"/>
    </div>

    <div>
        <label>Country:
            <form:select path="country" items="${countries}"/>
        </label>
    </div>

    <div>
        <label for="notesId">Notes:</label>
        <form:textarea path="notes" rows="3" cols="20" id="notesId"/>
    </div>

    <div>
        <label for="mailingListId">Mailing list:</label>
        <form:checkbox path="mailingList" id="mailingListId"/>
    </div>

    <div>
        <label for="skillId">Skills:</label>
        <form:select path="programmingSkills" items="${skills}" id="skillId"/>
    </div>

    <div>
        <label for="hobbiesId">Hobbies:</label>
        <form:checkboxes items="${hobbies}" path="hobbies" id="hobbiesId"/>
    </div>

    <input type="submit" value="Save">
</form:form>
</body>
</html>
