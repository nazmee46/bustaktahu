
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c"  
   uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="Staff.css" rel="stylesheet" type="text/css">
<title>List Staff</title>
</head>
<style>
.button {
  background-color: #E3BC9A; /* Green */
  border: none;
  color: black;
  padding: 10px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
}
</style>
<body>
<div class="backBut">
		<button type="button" onclick="goBack()">&laquo;</button>
		<script>
	    function goBack() 
			{
				 window.history.back();
	        }
	    </script>	
	</div>
<br>
<a href="AddStaff.jsp" class="button">Add Staff</a>
<h1>Staff List</h1><br>
	
	<table style="width:100%;text-align:left; border:1px solid black;">
		<tr>
			<th>Staff ID</th>
			<th>Staff Name</th>
			<th>Staff Email</th>
			<th>Staff Password</th>
			<th>Staff Address</th>
			<th>Staff Phone Number</th>
			<th>Staff IC Num</th>
			<th> Action </th>
		</tr>
		<c:forEach items="${staffs}" var="staff">
			<tr>
				<th><c:out value="${staff.staff_id}" /></th>
				<th><c:out value="${staff.staff_name}" /></th>
				<th><c:out value="${staff.staff_email}" /></th>
				<td><c:out value="${staff.staff_password}" /></td>
				<td><c:out value="${staff.staff_address}" /></td>
				<td><c:out value="${staff.staff_phoneno}" /></td>
				<td><c:out value="${staff.staff_icno}" /></td>
				<td><a href="StaffController?action=delete&staff_id=<c:out value="${staff.staff_id}"/>" class="button" onclick="confirmation(this.id)">Delete</a>
			</tr>
		</c:forEach>
	</table>
	<script>
      function confirmation(id){					  		 
   		console.log(id);
   		var r = confirm("Are you sure you want to delete?");
   		if (r == true) {				 		  
			location.href = 'StaffController?staff_id=' + staff_id;
			alert("Staff successfully deleted");			
  		} else {				  
  			return false;	
   			}
     }
</script>
	

</body>
</html>