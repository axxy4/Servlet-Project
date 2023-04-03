<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update</title>
</head>
<body>
	<form action="updated" method="post">
			<pre>
				Email <input type="text" name="email" value="<%=request.getAttribute("email")%>"/>
				Mobile <input type="text" name="mobile" value="<%=request.getAttribute("mobile")%>"/>
				<input type="submit" value="update"/>
			</pre>
		</form>
</body>
</html>