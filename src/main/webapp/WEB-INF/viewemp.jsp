   <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Employees List</h1>
<table border="2" width="70%" cellpadding="2">
<tr><th>Id</th><th>Name</th><th>Salary</th><th>Designation</th><th>Edit</th><th>Delete</th></tr>
   <c:forEach var="emp" items="${list}">
   <tr>
   <td>${emp.empid}</td>
   <td>${emp.empname}</td>
   <td>${emp.age}</td>
   <td>${emp.gender}</td>
   <td><a href="editemp/${emp.empid}">Edit</a></td>
   <td><a href="deleteemp/${emp.empid}">Delete</a></td>
   </tr>
   </c:forEach>
   </table>
   <br/>
   <a href="empform">Add New Employee</a>