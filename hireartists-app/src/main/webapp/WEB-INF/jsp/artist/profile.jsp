<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
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
<%@ page import="com.hireartists.client.model.Session"%>
</head>

<body>
	<h1>
		Welcome
		<%=Session.userName%>
		!!
	</h1>
	&nbsp; &nbsp;
	<a href="signOut">Sign out</a>
	<br />
	<br />
	
	<div id="main-event">
		<%-- <img src="${pageContext.request.contextPath}/images/taylor.png" /> --%>
		<p>Rihanna has finally released her highly anticipated music video
			for "Bitch Better Have My Money"! Watch on VEVO, TIDAL and download
			on iTunes and Google Play now.</p>
	</div>
	<aside id="sidebar">
		<div>
			<img alt="" src="">
			<p></p>
		</div>

	</aside>
	<div id="event-lists">
		<a href="viewEvents">View All Events</a>

	</div>
</body>
</html>