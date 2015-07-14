<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Artist Sign Up Page</title>
</head>
<body>

	<h1>hire-artists</h1>
	<h3>Artist Sign Up Form:</h3>

	<form action="/signUp" method="POST">
		<label for="name">Artist Name: </label>
		<input name="name" id="name" />
		
		<br />
		<label for="email">Email: </label>
		<input type="email" name="email" id="email" />
		
		<br />
		<label for="password">Password: </label>
		<input type="password" name="password" id="password" />
		
		<br />
		<label for="rePassword">rePassword: </label>
		<input type="password" name="rePassword" id="rePassword" />
		
		<br />
		<label for="address">Address: </label>
		<input type="text" name="address" id="address"></input>
		
		<br />
		<label for="gender">Gender: </label>
		<input type="text" name="gender" id="gender"></input>
		
		<br />
		<label for="displayName">Display Name: </label>
		<input type="text" name="displayName" id="displayName"></input>
		
		<br />
		<input type="submit" value="Sign Up">
	</form>

</body>
</html>