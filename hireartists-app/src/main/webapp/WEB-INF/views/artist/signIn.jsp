<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" type="text/css"
	href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" />
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.18/jquery-ui.min.js"></script>

<script type="text/javascript">
	function getEvents() {
		$('form').submit(function() {
			$.ajax({
				url : 'http://localhost:8080/hire-artists/login',
				type : 'POST',
				data : JSON.stringify($(this).serializeArray()),
				contentType : 'application/json',
				success : function(data) {

					if (data.status != "OK") {
						alert("Incorrect Login");
					} else {
						location.href = data.url;
					}

				},
				error : function(jqXHR, textStatus, errorThrown) {
					console.log(errorThrown)
				}
			})

			return false
		});
	}

	$(document).ready(function() {
		console.log("ready!");
		getEvents()
		console.log("end!");
	});
</script>

</head>
<body>

	<h1>hire-artists</h1>
	<h3>Sign In</h3>

	<form>
		<label for="name">User Name: </label> <input name="userName"
			id="userName" /> <br /> <label for="password"> Password: </label> <input
			type="password" name="password" id="password" /> <input
			type="submit" value="Sign In">
	</form>


</body>
</html>