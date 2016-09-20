<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Online sale</title>
<script src="http://code.jquery.com/jquery-1.10.2.js" type="text/javascript"></script>
<script src="js/onlinesale-ajax.js" type="text/javascript"></script>
</head>
<body onload="getCartId()">
	<h1>Please select a category to start</h1>
	<form>
		<select id="categoryId" onchange="getProductsList(this.value)" >
			<option value="">Category Selection</option>
			<option value="1">Ordinateurs</option>
			<option value="2">Tablettes</option>
			<option value="3">Téléphones</option>
		</select>
	</form>
	<br />
	<a href="cartContent.jsp">View Card Content</a>
	<div id="showProducts"></div>
</body>
</html>
