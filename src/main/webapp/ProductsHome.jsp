<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.nagarro.training.AdvancedJavaAssignment3.*"%>
<%@ page import="com.nagarro.training.AdvancedJavaAssignment3.models.*"%>
<%@ page import="com.nagarro.training.AdvancedJavaAssignment3.utility.*"%>

<%@ page import="java.util.List, java.util.ArrayList"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
	crossorigin="anonymous">
<title>Product Home</title>
</head>

<body>

	<%
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	%>
	<%
		String name = (String) session.getAttribute("username");
		Users currUser = new Users();
		currUser.setUname(name);
	%>

	<header>
		<nav class="navbar navbar-inverse">
			<div class="container-fluid">
				<div class="navbar-header" style="margin-left: 30%;">
					<h2>Product Management Tool</h2>
				</div>
				<ul class="nav navbar-nav navbar-right">
					<li>
						<form action="logout">
							<label>Hi <%
								out.print(currUser.getUname());
							%>&nbsp&nbsp&nbsp
							</label> <input type="submit" value="logout">
						</form>
					</li>
				</ul>
			</div>
		</nav>
	</header>
	<div class="container">
		<h5>Please enter product details to add to stock</h5>
	</div>
	<div class="container">
		<div class="row"></div>
		<div>
			<form action="add" method="POST" >
				<div class="row pb-1">
					<div class="col-sm-1">
						<label for="title">Title</label>
					</div>
					<div class="col">
						<input type="text" name="title" id="title" required>
					</div>
				</div>
				<div class="row pb-1">
					<div class="col-sm-1">
						<label for="quantity">Quantity</label>
					</div>
					<div class="col">
						<input type="number" name="quantity" id="quantity" required>
					</div>
				</div>
				<div class="row pb-1">
					<div class="col-sm-1">
						<label for="size">Size</label>
					</div>
					<div class="col">
						<input type="number" name="size" id="size" required>
					</div>
				</div>
				<div class="row pb-1">
					<div class="col-sm-1">
						<label for="image">Image</label>
					</div>
					<div class="col">
						<input type="file" name="image" id="image" required>
					</div>
				</div>

				<div class="row">
					<div class="col-sm-4"></div>
					<div class="col-sm-1">
						<input type="submit" value="Add">
					</div>
				</div>
			</form>
		</div>
	</div>

	<div class="container mt-5">
		<table class="table table-bordered">
			<thead>
				<tr>
					<th scope="col">S.no.</th>
					<th scope="col">Title</th>
					<th scope="col">Quantity</th>
					<th scope="col">Size</th>
					<th scope="col">Image</th>
					<th scope="col">Actions</th>
				</tr>
			</thead>
			<%
				List<Products> list = new ArrayList<Products>();
			%>
			<%
				list = ProductDao.productList((String) session.getAttribute("username"));
			%>
			<%
				int i = 1;

				for (Products p : list) {
			%>
			<tr>
				<th scope="row"><%=i%></th>
				<td style="text-align: center; vertical-align: middle;"><%=p.getTitle()%></td>
				<td style="text-align: center; vertical-align: middle;"><%=p.getQuantity()%></td>
				<td style="text-align: center; vertical-align: middle;"><%=p.getSize()%></td>
				<td style="text-align: center; vertical-align: middle;"><img src="data:image/jpg;base64,<%=p.getProductImage()%>"
					style="width: 100px; height: 100px;"></td>
				<td style="text-align: center; vertical-align: middle;">
					<a href="edit?productId=<%=p.getId()%>"> 
						<img src="C:\Users\sujaypaul\Desktop\Assignments\sujay-paul\Advanced-Java-Assignment-3\src\main\webapp\icons\edit.jpg" 
							style="width: 30px; height: 30px;" alt="edit"></a>
					<a href="delete?productId=<%=p.getId()%>">
						<img src="C:\Users\sujaypaul\Desktop\Assignments\sujay-paul\Advanced-Java-Assignment-3\src\main\webapp\icons\delete.jpg" 
							style="width: 30px; height: 30px;" alt="delete"></a>

					</td>
			</tr>
			<%
				i++;
				}
			%>
		</table>
		<div class="container">Size of product table is <%=Constants.dbImageLimit%> MB</div>
		
	</div>

</body>

</html>