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
	<h1>List of Artists</h1>
	<div>
		<a href="hire-artist">Home</a>
	</div>
	<br /><br /><br />
	<c:forEach var="artist" items="${artistList}" begin="1" end="5">
	   <div>
			Artist Name: ${artist.displayName} <br />
			
	   </div>
	</c:forEach>
</body>
</html>