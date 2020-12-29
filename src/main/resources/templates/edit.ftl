<#import "/spring.ftl" as spring/>
<html lang="en">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
      integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<html>
<head>
    <title>Authorization</title>
    <link rel="stylesheet"
          type="text/css" href="<@spring.url '/css/style.css'/>"/>
</head>
<body>
<form action="/login" method="POST">








    <button type="submit" class="btn btn-primary btn-lg" style="; margin-left:30rem; margin-top: 5rem" >Submit</button>



</form>

<a href="/login" class="btn btn-primary btn-lg" role="button" aria-pressed="true" style="margin-left:30rem; margin-top: 2rem" >Logout</a>

</body>

</html>