<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Practice Form<</title>
</head>
<body>

<h1> YAY Registration Successful</h1>
<p><strong>Name:</strong> <%= request.getAttribute("name")%></p>
<p><strong>Email:</strong> <%= request.getAttribute("email")%></p>
<p><strong>Password:</strong> <%= request.getAttribute("password")%></p>
<a href = 'form.html'>Go back</a>
</body>
</html>
