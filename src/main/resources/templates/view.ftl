<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8" />
    <title>User</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css"/>
</head>
<body>
<h1>Users Info</h1>

<div>
    <a href="/user">Back</a> |
    <a href="/login">Logout</a>
</div>
<br/><br/>
<div>
    <table border="1">
        <tr>
            <th>#</th>
            <th>User Name</th>
            <th>Password</th>
            <th>Firs Name</th>
            <th>Last Name</th>
            <th>Role</th>
            <th>Status</th>
            <th>Creat At</th>
            <th>Edit User</th>
            <th>Delete User</th>
        </tr>
        <#list allUsers>
            <#items as i>
                <tr>
                    <td> ${i_index+1}</td>
                    <td>${i.username}</td>
                    <td>${i.password}</td>
                    <td>${i.firstName}</td>
                    <td>${i.lastName}</td>
                    <td>${i.id}</td>
                    <td>
                        <select name="status">
                            <option value="ACTIVE">ACTIVE</option>
                            <option value="INACTIVE">INACTIVE</option>
                        </select>
                    </td>
                    <td>${i.createdAt}</td>
                    <td><a href="/edit">Edit</a></td>
                    <td> <a href="${'/users/' + i.id + '/delete'}">Delete</a></td>
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
