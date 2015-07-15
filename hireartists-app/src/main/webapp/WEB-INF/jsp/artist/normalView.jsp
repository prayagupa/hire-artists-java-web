<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<title>List of Artists</title>

<link rel="stylesheet" type="text/css"
	href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" />
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.18/jquery-ui.min.js"></script>
<%@ page import="com.hireartists.client.model.Session"%>
</head>

<body>
	<div>
		<h1>List of Events and Organizers</h1>
	</div>

	<br />
	<!-- Display the list of events with their organizers, artists and status -->


	<div>
		<table style="width: 100%">
			<tr>
				<td><strong>Events</strong></td>
				<td><strong>Organizers</strong></td>
				<td><strong>Artists</strong></td>
				<td><strong>Status</strong></td>
			</tr>

		</table>
	</div>

	<div>
		<h4>Convert In Farifield</h4>
		&nbsp;&nbsp;
		<h4>O'Reilly Org.</h4>
		&nbsp;&nbsp;
		<h4>Done</h4>
		<h4>Convert In Ottumwa</h4>
		&nbsp;&nbsp;
		<h4>Arnold and Sons Org.</h4>
		&nbsp;&nbsp;
		<h4>Upcoming</h4>
	</div>



	<div>
		<a href="backToProfile">My Profile</a>
	</div>
	<br />
	<br />
	<br />
	<%-- <c:forEach var="artist" items="${artistList}" begin="1" end="5"> --%>
	<div></div>
	<%-- </c:forEach> --%>
</body>
</html>