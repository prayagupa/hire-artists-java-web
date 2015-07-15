<%@ page import="com.hireartists.client.model.Session" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<title>Artist Profile</title>

<link rel="stylesheet" type="text/css"
	href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" />
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.18/jquery-ui.min.js"></script>

	<script type="text/javascript">
		$(function () {
			$(document).ready(function () {
				var username = "asdfasfd";
				$.ajax({
					url: 'http://localhost:8080/hire-artists/eventOrganiser/profileDetail/',
					type: 'POST',
					data: "username="+username,
					contentType: 'application/json',
					success: function (data) {
						console.log(data);
					},
					error: function (jqXHR, textStatus, errorThrown) {
						console.log(errorThrown);
					}
				})


				$.ajax({
					url: 'http://localhost:8080/hire-artists/main/events/',
					type: 'GET',
					data: "",
					contentType: 'application/json',
					success: function (data) {
						console.log("List of events = "+data);
					},
					error: function (jqXHR, textStatus, errorThrown) {
						console.log(errorThrown);
					}
				})
			});
		})
	</script>
</head>

<body>
	<h1>Event Organiser Profile</h1>

	<h3>Welcome <%= Session.userName %>!</h3>
	<div>
		<a href="/signOut">Sign out</a>
	</div>
	<div id = "main-event">
		<!-- <img src="/resources/static/bigyan.jpg"> -->
		<p>List of Events</p>
	</div>
	<aside id="sidebar">
		<div>
			<img alt="" src="">
			<p>   </p>
		</div>
	
	</aside>
	<div class="add-events-form-wrap">
		<form id="form-add-events">

		</form>
	</div>
	<div id="event-lists">
	
	
	</div>
</body>
</html>