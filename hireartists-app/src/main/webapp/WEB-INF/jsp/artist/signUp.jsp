<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" />
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.18/jquery-ui.min.js"></script>

    <script type="text/javascript">
            function getEvents() {
				$("form[name=signUp]").submit(function(e){
				    e.preventDefault();
					$.ajax({
						headers: {
							'Accept': 'application/json',
							'Content-Type': 'application/json'
						},
						'type': 'POST',
						'url': 'http://localhost:8080/hire-artists/signUp',
						'data': $('form#signUp').serialize(),
						'dataType': 'json',
						'contentType': "application/json",
						'success': function(data) {
										   console.log(data)
								   }
						});
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
	<h3>Artist Sign Up Form:</h3>

	<form id="signUp" name="signUp" action="/signUp" method="POST">
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
		<label for="displayName">Display Name: </label>
		<input type="text" name="displayName" id="displayName"></input>
		
		<br />
		<input type="submit" value="Sign Up">
	</form>

</body>
</html>