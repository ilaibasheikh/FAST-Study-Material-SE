
<html ">
<head>
    <title>Character Frequency Result</title>
    <style>
        table {
            width: 50%;
            margin: 20px 0;
        }
        table, th, td {
            border: 1px solid black;
        }
        th, td {
            padding: 10px;
            text-align: left;
        }
    </style>
</head>
<body>
<h1>Character Frequency Count</h1>
<p>Entered String: <%= request.getAttribute("input") %></p>
<p>Character Frequencies:</p>
<table>
    <thead>
    <tr>
        <th>Character</th>
        <th>Frequency</th>
    </tr>
    </thead>
    <tbody>
    <% int[] frequency = (int[]) request.getAttribute("charFrequency");
        for (int i = 0; i < frequency.length; i++) {
            if (frequency[i] > 0) { %>
    <tr>
        <td><%= (char) i %></td>
        <td><%= frequency[i] %></td>
    </tr>
    <%  } } %>
    </tbody>
</table>
</body>
</html>
