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
        $.ajax({
          url: 'http://localhost:8080/hire-artists/main/events',
          type: 'GET',
          data: "",
          contentType: 'application/json',
          beforeSend: function () {
            $(this).find("input[type='submit']").attr('disabled',true);
          },
          success: function (data) {
            console.log(data);
            var events = "";
            $.each(data,function(k,event){
              events += '<div class="event"><p>Event Name = '+event.name+'<br>Event Organiser = '+event.organiser.name+'</p>';
            });
            console.log(events);
            $(".events-list").html(events);
          },
          error: function (jqXHR, textStatus, errorThrown) {
            console.log(errorThrown);
          }
          ,
          complete: function () {
            $(this).find("input[type='submit']").attr('disabled',false);
          }
        })
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
<h3>Events Lists:</h3>
<div class="events-list">

</div>

</body>
</html>
