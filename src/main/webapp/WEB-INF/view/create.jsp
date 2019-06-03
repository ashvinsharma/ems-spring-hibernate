<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <style>
        .error {
            color: red
        }
    </style>
    <title>EMS || Create an employee record</title>
</head>
<body>
<div>
    <table>
        <form:form method="post" action="${pageContext.request.contextPath}/record/insert" modelAttribute="employee">
            <tr>
                <td>Name</td>
                <td><label>
                    <form:input path="name"/>
                </label></td>
                <td><form:errors path="name" cssClass="error"/></td>
            </tr>
            <tr>
                <td>Email</td>
                <td><label>
                    <form:input path="email"/>
                </label></td>
                <td><form:errors path="email" cssClass="error"/></td>
            </tr>
            <tr>
                <td>Designation</td>
                <td><label>
                    <form:select path="designationId" name="designation">
                        <c:forEach var="desg" items="${requestScope.designations}">
                            <form:option id="${desg.id}" value="${desg}">
                                <c:out value="${desg.name}"/>
                            </form:option>
                        </c:forEach>
                    </form:select>
                </label></td>
                <td></td>
            </tr>
            <tr>
                <td>Contact</td>
                <td><label>
                    <form:input path="contact" maxlength="10"/>
                </label></td>
                <td><form:errors path="contact" cssClass="error"/></td>
            </tr>
            <tr>
                <td>
                    <input type="submit" value="Submit">
                </td>
            </tr>
        </form:form>
    </table>
</div>
</body>
</html>
