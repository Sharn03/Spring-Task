<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>
	INDEX PAGE
</h1>
<form action="createEmployee" method="post">
	<p>Employee_id<p> <input type="text" name="id" placeholder= "ID" >
	<br>
	<p>Employee_name<p> <input type="text" name = "name" placeholder="Name" >
	<br>
	<p>Employee_email<p> <input type="text" name="email" placeholder = "Email" >
	<br>
	<p>Employee_location<p> <input type="text" name="location" placeholder = "Location" >
	<br>
	

</form>
		<button type="submit">Submit
	</button>
</body>
</html>