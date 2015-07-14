<html>
<head>
    <link rel="stylesheet" type="text/css" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" />
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.18/jquery-ui.min.js"></script>

    <script type="text/javascript">
            function getEvents() {
                $.ajax({
                    dataType: "jsonp",
                    url : 'http://localhost:8080/hire-artists/main/events',
                    success : function(data) {
                        var json = $.parseJSON(e.responseText)
                        console.log(json)

                        $.each(json, function(index,jsonObject){
                            $.each(jsonObject, function(key,val){
                                console.log("key : "+key+" ; value : "+val);
                                if(key == "name")
                                    $("#name").text(val)
                            });
                        });
                    },
                    error : function(e) {
                        var json = $.parseJSON(e.responseText)
                        console.log(json)

                        $.each(json, function(index,jsonObject){
                            $.each(jsonObject, function(key,val){
                                console.log("key : "+key+" ; value : "+val);
                                if(key == "name")
                                    $("#name").text(val)
                            });
                        });
                    }
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
<h2>Hire Artists!</h2>

<div>
	<a href="artist">Sign Up as an Artist</a>

	<br />
	<a href="loginView">login</a>
</div>

<div id="result">
    <ul>
        <a><li id="name"></li></a>
    </ul>
</div>
</body>
</html>
