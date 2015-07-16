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
	<!-- <h1>List of Events</h1>
	
	<h4>Convert In Farifield</h4>
	<h4>Convert In Ottumwa</h4>
	<h4>Convert In Mount Pleasant</h4>
	<h4>Convert In Jefferson</h4>
	<h4>Convert In Iowa City</h4>
	<div>
		<a href="backToProfile">My Profile</a>
	</div> -->
	
	<script type="text/javascript">
            function getEvents() {
									$.ajax({
										url: 'http://localhost:8080/hire-artists/main/events',
										type: 'GET',
										data: JSON.stringify($(this).serializeArray()),
										contentType: 'application/json',
										success: function (data) {
											console.log(data)
											toTable(data)
										},
										error: function (jqXHR, textStatus, errorThrown) {
											console.log(errorThrown)
										}
									})

									return false
            }

			function toTable(data){
					var tbl_body = "";
					var odd_even = false;
					$.each(data, function() {
						var tbl_row = "";
						$.each(this, function(k , v) {
							tbl_row += "<td>"+v+"</td>";
						})
						tbl_body += "<tr class=\""+( odd_even ? "odd" : "even")+"\">"+tbl_row+"</tr>";
						odd_even = !odd_even;
					})
					$("#target_table_id tbody").html(tbl_body);
			}

        $( document ).ready(function() {
            console.log( "ready!" );
            getEvents()
            console.log( "end!" );
        });

    </script>
	
	<br /><br /><br />

	   <table id="target_table_id">
			
			
	   </table>

</body>
</html>