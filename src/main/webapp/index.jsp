<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<link
	href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ----------></head>
<body>
	




<div class="container" styel="margin">
	<div class="row" style="margin-top:10%; margin-left:10%; margin-right:20%  width=150px">
		<div>
			<form class="form-horizontal" action="login" method="POST" style='background:#F5F8FB;width:65%'>
				<fieldset>
					<div id="legend">
						<legend style='background:#EBF1F7;'>  Login</legend>
					</div>
					<div class="control-group">
						<!-- Username -->
						<label class="control-label" for="username">Username</label>
						<div class="controls">
							<input type="text" id="username" name="username" 
								 required>
						</div>
					</div>
					<div class="control-group">
						<!-- Password-->
						<label class="control-label" for="password">Password</label>
						<div class="controls">
							<input type="password" id="password" name="password"
								required>
						</div>
					</div>
					<div class="control-group" style='background:#EBF1F7;text-align:right;margin-bottom:0px;padding:1%'>
						<!-- Button -->
						<div class="controls" >
							<input class="btn btn-success"  type='submit' value="Login >>"/>
						</div>
					</div>
				</fieldset>
			</form>
		</div>
	</div>
</div>
</body>

</html>
