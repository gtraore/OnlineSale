<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="javax.servlet.*" %>
<%@page import="javax.servlet.http.*" %>
<%@page import="java.util.*,java.sql.*,java.io.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Online sale</title>
<script src="http://code.jquery.com/jquery-1.10.2.js" type="text/javascript"></script>
<script src="js/onlinesale-ajax.js" type="text/javascript"></script>
</head>
<body>
	<%!Connection connection; %>
	<%!Statement statement; %>
	<%!ResultSet resultSet; %>
	<% String productId=request.getParameter("productId");
	try{
		Class.forName("com.mysql.jdbc.Driver");
		connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinesale","root","password");
		statement=connection.createStatement();
		resultSet=statement.executeQuery(
				"SELECT product.id, product.name, category.name as 'category', manufacturer.name as 'manufacturer', price, imgurl, description, product.category_id " +
				"FROM onlinesale.product LEFT JOIN (onlinesale.category, onlinesale.manufacturer) " +
                "ON (category.id=product.category_id AND manufacturer.id=product.manufacturer_id) where product.id="+productId+";");

	}catch(Exception e){ e.printStackTrace(); }
	if(resultSet.next()){ %>
	<h1><%=resultSet.getString(2)%></h1>
	<div id="dt_table">
		<table>
			<tr>
				<td><img src="<%=resultSet.getString(6)%>" alt="<%=resultSet.getString(2)%>" style="width:100px;height:100px;"></td>
			</tr>
			<tr>
				<td>
					Category : <%=resultSet.getString(3)%>
					<br>
					Manufacturer : <%=resultSet.getString(4)%>
					<br>
					Price : $ <%=resultSet.getDouble(5)%>
					<br>
					Description : <%=resultSet.getString(7)%>
					<br>
					<button type="button" onclick='addToCard(<%=resultSet.getString(1)%>)'>Add to cart</button>
					<br>
					<a href="index.jsp">Back</a>
				</td>
			</tr>
		</table>
	</div>
	<div id="ajaxResponse"></div>
	<% } 
	else{
	%>
	<h1>Product not Found</h1>
	<% } 
	try{
	}catch(Exception e){ e.printStackTrace(); }
	%>
</body>
</html>
