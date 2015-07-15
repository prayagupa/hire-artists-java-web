<%--
  Created by IntelliJ IDEA.
  User: Binod
  Date: 7/14/2015
  Time: 4:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
          url: 'http://localhost:8080/hire-artists/eventOrganiser/add',
          type: 'POST',
          data: JSON.stringify($(this).serializeArray()),
          contentType: 'application/json',
          beforeSend: function () {
            $(this).find("input[type='submit']").attr('disabled',true);
          },
          success: function (data) {
            if ($.trim(data.status) == "success") {
              $("#response").text("You account is created successfully. Please wait, redirecting...");
              setInterval(function () {
                location.href = "profile";
              },3000)
            }
          },
          error: function (jqXHR, textStatus, errorThrown) {
            console.log(errorThrown);
          }
          ,
          complete: function () {
            $(this).find("input[type='submit']").attr('disabled',false);
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

<h1>Hire Artist</h1>
<h3>Create Events:</h3>

<div id="response"></div>
<form id="create" name="create" action="/event/create" method="POST">

  <label for="eventName">Event Name: </label>
  <input type="text" name="eventName" id="eventName" required />


  <br />
  <label for="from">From: </label>
  <input type="datetime" name="from" id="from" required />

  <br />
  <label for="to">To: </label>
  <input type="datetime" name="to" id="to" required />

  <input type="submit" value="Sign Up">
</form>

</body>
</html>
