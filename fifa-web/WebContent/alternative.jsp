<%@ page import="java.util.*, java.io.*"%>
<!DOCTYPE html>
<html>
<head>
	<title>esprit</title>
</head>
<body>
	<%! int visistCount=0;%>
	<%visistCount++; %>
	<h1>This is <%=getServletContext().getInitParameter("year") %></h1>
	<%for(int i =0; i<3; i++) {%>
	<h2>Hello <%=request.getParameter("name")%></h2>
	<%} %>
	<h3>visits : <%=visistCount%></h3>
</body>
</html>