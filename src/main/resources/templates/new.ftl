<#import "/spring.ftl" as spring/>
<html lang="en">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
      integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<html>
<head>
    <title>Create New User</title>
    <link rel="stylesheet"
          type="text/css" href="<@spring.url '/css/style.css'/>"/>
</head>
<body>

<form action="/new" method="POST" >

    <div class="form-group" style="padding-right:30rem; margin-left:30rem; margin-top: 1rem">
        <label for="exampleInputUserName">userName</label>
        <input type="text" name="userName" class="form-control" id="exampleInputFirsName"   title = "Имя должно начинаться с заглавной латинской буквы и не может быть короче 2 латинских символов,  и больше 15"  maxlength="15" required><br/>
        <small id="userNameHelp" class="form-text text-muted">for example: Bob </small>
    </div>
    <div class="form-group" style="padding-right:30rem; margin-left:30rem; margin-top: 1rem">
        <label for="exampleInputPassword1">Password</label>
        <input type="password" name="password" class="form-control" id="exampleInputPassword1"  title="Должно содержать по крайней мере одно число, одну заглавную и строчную буквы, а также не менее 8 и более символов" required><br/>
        <small id="passwordHelp" class="form-text text-muted">for example: Aa123456</small>
    </div>

    <div class="form-group" style="padding-right:30rem; margin-left:30rem; margin-top: 1rem">
        <label for="exampleInputFirstName">firstName</label>
        <input type="text" name="firstName" class="form-control" id="exampleInputFirsName"    title = "Имя должно начинаться с заглавной латинской буквы и не может быть короче 2 латинских символов,  и больше 15"  maxlength="15" required><br/>
        <small id="firsNameHelp" class="form-text text-muted">for example: Bob </small>
    </div>

    <div class="form-group"style="padding-right:30rem; margin-left:30rem; margin-top: 1rem">
        <label for="exampleInputLastName">lastName</label>
        <input type="text" name="lastName" class="form-control" id="exampleInputLastName"   title = "Фамилия должна начинаться с заглавной латинской буквыне может быть короче двух латинских символов, и больше 15"  maxlength="15"required><br/>
        <small id="lastNameHelp" class="form-text text-muted"> for example: Smith </small>
    </div>




    <button type="submit" class="btn btn-primary btn-lg" style="; margin-left:30rem; margin-top: 5rem" >Submit</button>

</form>


</form>

<a href="/login" class="btn btn-primary btn-lg" role="button" aria-pressed="true" style="margin-left:30rem; margin-top: 2rem" >Logout</a>

</body>

</html>