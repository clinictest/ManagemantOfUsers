<#import "/spring.ftl" as spring/>
<html lang="en">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
      integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<html>
<head>
    <title>Authorization</title>
    <link rel="stylesheet" type="text/css" href="<@spring.url '/css/style.css'/>"/>
</head>
<body>

<form action="/login" method="POST">



    <div class="form-group" style="padding-right:30rem; margin-left:30rem; margin-top: 2rem" >
        <label for="exampleInputUserName">UserName</label>
        <input type="text" name="username" class="form-control" id="exampleInputUserName" aria-describedby="userNameHelp"  maxlength="16" minlength="3" required ><br/>
        <small id="userNameHelp" class="form-text text-muted">for example: Bob </small>
    </div>
    <div class="form-group" style="padding-right:30rem; margin-left:30rem; margin-top: 2rem" >
        <label for="exampleInputPassword1">Password</label>
        <input type="password"  name="password" class="form-control" id="exampleInputPassword"  title="Должно содержать по крайней мере одно число, одну заглавную и строчную буквы, а также не менее 8 и более символов" required><br/>
        <small id="passwordHelp" class="form-text text-muted">for example: Aa123456</small>
    </div>

    <button type="submit" class="btn btn-primary btn-lg" style="; margin-left:30rem; margin-top: 5rem" >Submit</button>



</form>

</body>

</html>