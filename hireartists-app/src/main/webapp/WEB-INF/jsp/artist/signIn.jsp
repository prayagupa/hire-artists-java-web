<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
</head>
<body>

	<h1>hire-artists</h1>
	<h3>Sign In:</h3>

	<form action="/signIn" method="POST">
		<label for="name">User Name: </label> <input name="name" id="name" />

		<br /> <label for="password">Password: </label> <input
			type="password" name="password" id="password" /> <input
			type="submit" value="Sign In">
	</form>

</body>
</html>