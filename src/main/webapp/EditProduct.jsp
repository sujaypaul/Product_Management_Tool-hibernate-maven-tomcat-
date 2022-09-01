<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE
html>
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
<title>Edit Product</title>
</head>

<body>

	<%
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	%>


	<div style="margin-top: 10%;">
		<form action="update" style="width: 50%;" class="container">
			<div class="row pb-3">
				<div class="col-sm-3">
					<label for="title">Title</label>
				</div>
				<div class="col">
					<input type="text" name="title" id="title" required
					value="<%out.print(session.getAttribute("title")); %>">
				</div>
			</div>
			<div class="row pb-3">
				<div class="col-sm-3">
					<label for="quantity">Quantity</label>
				</div>
				<div class="col">
					<input type="text" name="quantity" id="quantity" required
					value="<%out.print(session.getAttribute("quantity")); %>">
				</div>
			</div>
			<div class="row pb-3">
				<div class="col-sm-3">
					<label for="size">Size</label>
				</div>
				<div class="col">
					<input type="number" name="size" id="size" required
					value="<%out.print(session.getAttribute("size")); %>">
				</div>
			</div>
			<div class="row pb-3">
				<div class="col-sm-3">
					<label for="image">Image</label>
				</div>
				<div class="col">
					<input type="file" name="image" id="image" required
					value="<%out.print(session.getAttribute("image")); %>">
				</div>
			</div>



			<div class="row justify-content-center mt-5">
				<div class="col-8">

					<input type="submit" value="Save Changes" class="col">
				</div>
			</div>

		</form>
	</div>

</body>

</html>