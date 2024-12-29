<%@ page import="java.util.List, java.util.ArrayList" %>

<html >
<head>
  <title>Fibonacci Sequence Result</title>
</head>
<body>
<h1>Fibonacci Sequence </h1>
<p>The Fibonacci sequence up to the entered number is: <%=request.getAttribute("number") %></p>
<ul>
  <%
    List<Integer> fibonacciSequence = (List<Integer>) request.getAttribute("fibonacciSequence");
    for (int num : fibonacciSequence) {
  %>
  <li><%= num %></li>
  <%
    }
  %>
</ul>

</body>
</html>
