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
                location.href = "p";
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
<h3>Event Organiser Sign Up:</h3>

<div id="response"></div>
<form id="signUp" name="signUp" action="/signUp" method="POST">

  <br />
  <label for="email">Email: </label>
  <input type="email" name="email" id="email" required />

  <br />
  <label for="username">Username: </label>
  <input type="text" name="username" id="username" required />

  <br />
  <label for="password">Password: </label>
  <input type="password" name="password" id="password" required />

  <br />
  <label for="rePassword">rePassword: </label>
  <input type="password" name="rePassword" id="rePassword" required />

  <br />
  <label for="address">Contact Number: </label>
  <input type="text" name="contactNumber" id="contactNumber" required />

  <br />
  <label for="address">Address: </label>
  <input type="text" name="address" id="address" required />

  <br />
  <label for="name">Display Name: </label>
  <input type="text" name="name" id="name" required />

  <br />
  <input type="submit" value="Sign Up">
</form>

</body>
</html>
