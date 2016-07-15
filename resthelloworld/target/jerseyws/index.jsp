<%@ page import="resthelloworld.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	<h3>Student Details:</h3>
	<div>
		<form action="services/hello/lastname" method="POST">
			ID:<input type="text" id="id" name="id"><br /> 
			Last Name:<input type="text" name="lastname" /><br> 
			First Name:<input type="text" name="firstname" /><br>
			 Date Of Birth:<input type="text" name="dateofbirth" /><br> 
			 Program:<input type="text" name="program" /><br> 
			 Admit:<input type="text" name="admit" /><br> 
			 <input type="submit" value="Create" /> 
			 <input type="submit" value="Read"  /> 
			 <input	type="submit" value="Update"  /> 
			 <input	type="submit" value="Delete"  />




		</form>
	</div>

</body>
</html>
