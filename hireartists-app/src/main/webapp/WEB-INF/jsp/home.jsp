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
		$.ajax({
			dataType : "jsonp",
			url : 'http://localhost:8080/hire-artists/main/events',
			success : function(data) {
				var json = $.parseJSON(e.responseText)
				console.log(json)

				$.each(json, function(index, jsonObject) {
					$.each(jsonObject, function(key, val) {
						console.log("key : " + key + " ; value : " + val);
						if (key == "name")
							$("#name").text(val)
					});
				});
			},
			error : function(e) {
				var json = $.parseJSON(e.responseText)
				console.log(json)

				$.each(json, function(index, jsonObject) {
					$.each(jsonObject, function(key, val) {
						console.log("key : " + key + " ; value : " + val);
						if (key == "name")
							$("#name").text(val)
					});
				});
			}
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
	<h1>&nbsp;&nbsp;&nbsp;Hire Artists!</h1>

	<div>
		<a href="artist-sign-up">Sign Up as an Artist</a>  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="eventOrganiser/signup">Sign Up as an Event Organiser</a>  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="loginView">Sign In here</a> <br /><br />
		<a href="artistList">View Artists Here</a> &nbsp;&nbsp;&nbsp;
		<a href="main/events">Proceed As Normal User</a> 
	</div>
	<br />
	<br />

	<P>ArtTrade.com will allow the users to sign up as an artist or an
		event organizer. Event organizer can create events and request artists
		(if they are available) to perform on their events. Similarly, artists
		can look up for events and request to perform in that events. Upon
		agreement, they will do the event mutually, and finally when they are
		done with it, they will end up giving feedback to each other and
		clearing the payments. This way, our web app will help new artist to
		find new job opportunities and also help event organizers to easily
		reach the artists.</P>
	<p>
	
	<strong>Team Members:</strong><br> 1. Prayag Upadhyay<br> 2.
		Bigyan Thapa<br> 3. Binod Gurung<br>
	</p>

	<p>
		<strong>Features:</strong><br> 1. Create account as artist or
		event organiser<br> 2. Artist - Add portfolios : Videos<br>
		3. Artist - Set next available date<br> 4. Event Organisers -
		create events<br> 5. Artist - Request to perform on events<br>
		6. Event Organisers - Request artists to perform on events<br> 7.
		Agreement and settlements.<br> 8. Give Feedbacks to each others.<br>
		9. Normal users can see the list of artist and events.

	</p>

<div id="result">
		<ul>
			<a><li id="name"></li></a>
		</ul>
	</div>
</body>
</html>
