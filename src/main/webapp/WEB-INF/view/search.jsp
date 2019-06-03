<%--
  Created by IntelliJ IDEA.
  User: ashvinsharma
  Date: 27/5/19
  Time: 3:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>EMS || Look for employee details</title>
    <script>
        function resetFields() {
            const deleteButton = document.getElementById("delete_button");
            const resetButton = document.getElementById("reset_button");
            if (resetButton.style.display === "block") resetButton.style.display = "none";
            if (deleteButton.style.display === "none") deleteButton.style.display = "block";
            const form = document.getElementById('employee_details_form');
            form.reset();
        }

        function editField(e) {
            const deleteButton = document.getElementById("delete_button");
            const resetButton = document.getElementById("reset_button");
            if (resetButton.style.display !== "block") resetButton.style.display = "block";
            if (deleteButton.style.display !== "none") deleteButton.style.display = "none";
            if (e.target.name !== 'id') e.target.removeAttribute("readonly");
        }
    </script>
</head>
<body>
<div>
    <form:form method="post" modelAttribute="email" action="${pageContext.request.contextPath}/record/read">
        <label>
            <input placeholder="Enter the email to initiate the search" name="email"/>
        </label>
        <input type="submit" value="Search!"/>
    </form:form>
    <c:if test="${not empty employeeDetails}">
        <c:set var="employeeMap" value="${employeeDetails.toLinkedHashMap()}"/>
        <table>
            <tr>
                <c:forEach var="mapItems" items="${employeeMap}">
                    <th><c:out value="${fn:toUpperCase(mapItems.key)}"/></th>
                </c:forEach>
            </tr>
            <form:form id="employee_details_form" method="post" modelAttribute="employeeDetails">
                <tr>
                    <c:forEach var="mapItems" items="${employeeMap}">
                        <td>
                            <label>
                                <c:choose>
                                    <c:when test="${mapItems.key eq 'designation'}">
                                        <form:select path="designationId" name="designation" onclick="editField(event)">
                                            <form:options items="${designations}"/>
                                            <%--                                                    <c:forEach var="desg" items="${requestScope.designations}">--%>
                                            <%--                                                        <form:option id="${desg.id}" value="${desg}" sele"${desg.id eq mapItems.value.id? 'selected':''}">--%>
                                            <%--                                                        <c:out value="${desg.name}"/>--%>
                                            <%--                                                    </form:option>--%>
                                            <%--                    </c:forEach>--%>
                                        </form:select>
                                    </c:when>
                                    <c:otherwise>
                                        <input readonly
                                               name="${mapItems.key}"
                                               id="${mapItems.key}"
                                               value="<c:out value="${mapItems.value}"/>"
                                               onclick="editField(event)"
                                        />
                                    </c:otherwise>
                                </c:choose>
                            </label>
                        </td>
                    </c:forEach>
                    <td>
                        <button id="update_button"
                                formaction="${pageContext.request.contextPath}/record/update">Update
                        </button>
                    </td>
                    <td>
                        <button id="delete_button" formmethod="post"
                                formaction="${pageContext.request.contextPath}/record/delete">Delete
                        </button>
                        <button id="reset_button" type="button" style="display: none" onclick="resetFields()">Reset
                        </button>
                    </td>
                </tr>
            </form:form>
        </table>
    </c:if>
</div>
</body>
</html>