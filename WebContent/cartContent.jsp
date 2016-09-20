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
</head>
<body>
	<%!Connection connection; %>
	<%!Statement statement; %>
	<%!ResultSet resultSet; %>
	<% String cartId=request.getParameter("cartId");
	try{
		Class.forName("com.mysql.jdbc.Driver");
		connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinesale","root","password");
		statement=connection.createStatement();
		
		resultSet=statement.executeQuery(
				"SELECT product.id, product.name, category.name as 'category', manufacturer.name as 'manufacturer', price, imgurl, orderMapping.quantity " +
				"FROM onlinesale.product LEFT JOIN (onlinesale.category, onlinesale.manufacturer, onlinesale.orderMapping) " +
                "ON (category.id=product.category_id AND manufacturer.id=product.manufacturer_id AND orderMapping.product_id=product.id) where orderMapping.cart_id=(SELECT MAX(id) FROM onlinesale.cart);");

	}catch(Exception e){ e.printStackTrace(); }
	%>
	<h1>Cart Content</h1>
	<a href="index.jsp">Back</a>
	<div id="dt_table">
		<table border='4' cellpadding='6' cellspacing='3' width="700px">
			<trbgcolor="66FF00">
				<th></th>
				<th>Name</th>
				<th>Category</th>
				<th>Manufacturer</th>
				<th>Price</th>
				<th>Number</th>
				<th></th>
			</tr>
			<% while(resultSet.next()){ %>
			<tr>
				<td><img src="<%=resultSet.getString(6)%>" alt="<%=resultSet.getString(2)%>" style="width:100px;height:100px;"></td>
				<td><%=resultSet.getString(2)%></td>
				<td><%=resultSet.getString(3)%></td>
				<td><%=resultSet.getString(4)%></td>
				<td>$ <%=resultSet.getDouble(5)%></td>
				<td><%=resultSet.getString(7)%></td>
				<td><a href="productdetails.jsp?productId=<%=resultSet.getString(1)%>">Details</a></td>
			</tr>
			<% } 
			try{
			}catch(Exception e){ e.printStackTrace(); }
			%>
		</table>
	</div>
	<div id="ajaxResponse"></div>
</body>
</html>
