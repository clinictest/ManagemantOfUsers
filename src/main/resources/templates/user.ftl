<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>User</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css"/>
</head>
<body>
<h1>Users List</h1>

<div>
    <a href="/user/new">Next</a> |
    <a href="/user/new">Previous</a> |
    <a href="/login">Logout</a>
</div>
<br/><br/>
<div>
    <table border="1">
        <tr>
            <th>#</th>
            <th>User Name</th>
            <th>Role</th>
            <th>Status</th>
        </tr>
        <#list allUsers>
            <#items as i>
                <tr>
                    <td> ${i_index+1}</td>
                    <td>${i.username}</td>
                    <td><#list i.roles>
                            <#items as i>
                                ${i.name}
                            </#items>
                        </#list>
                    </td>
                    <td>${i.status}</td>
                    <td>
                    <form action="/user" method="post">
                        <select name="format">
                            <option value="SOFT_TOYS">SOFT TOY</option>
                            <option value="DOLLS">DOLL</option>
                            <option value="CONSTRUCTOR">CONSTRUCTOR</option>
                        </select>
                        <button type="submit">UNLOCK</button>
                    </form>
                    </td>
                    <td>

                    </td>
                </tr>
            </#items>
        <#else>
            <p>No element</p>
        </#list>
    </table>
</div>
<br/><br/>
</body>
</html>
