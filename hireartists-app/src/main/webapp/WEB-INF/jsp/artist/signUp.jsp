<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" />
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.18/jquery-ui.min.js"></script>

    <script type="text/javascript">
            function getEvents() {
				 $('form').submit(function () {
									$.ajax({
										url: 'http://localhost:8080/hire-artists/signup',
										type: 'POST',
										data: JSON.stringify($(this).serializeArray()),
										contentType: 'application/json',
										success: function (data) {
											console.log(data)
											if ($.trim(data.status) == "success") {
												alert("Account Created Successfully");
												location.href="artist/profile";
											}
										},
										error: function (jqXHR, textStatus, errorThrown) {
											console.log(errorThrown)
										}
									})

									return false
				  });
            }

        $( document ).ready(function() {
            console.log( "ready!" );
            getEvents()
            console.log( "end!" );
        });

    </script>
</head>
<body>

	<h1>hire-artists</h1>
	<h3>Artist Sign Up:</h3>

	<form id="signUp" name="signUp" action="/signUp" method="POST">

		<br />
		<label for="username">User Name: </label>
		<input type="text" name="username" id="username" required />
		
		<br />
		<label for="password">Password: </label>
		<input type="password" name="password" id="password" required />
		
		<br />
		<label for="rePassword">rePassword: </label>
		<input type="password" name="rePassword" id="rePassword" required />
		
		<br />
		<label for="address">Address: </label>
		<input type="text" name="address" id="address" required/>
		
		<br />
		<label for="displayName">Display Name: </label>
		<input type="text" name="displayName" id="displayName" required />
		
		<br />
		<input type="submit" value="Sign Up">
	</form>

</body>
</html>