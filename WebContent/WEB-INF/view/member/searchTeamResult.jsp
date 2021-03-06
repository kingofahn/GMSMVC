<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 	String ctx = application.getContextPath(); %>
<%@ page import = "service.*" %>
<%@ page import = "domain.*" %>
<%@ page import = "java.util.*" %>

<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>Team name Search Result </title>
	<link rel="stylesheet" href="${css}/style.css"/>
</head>
<body>
	<%
		List<MemberBean> lst = MemberServiceImpl.getInstance().findMemberByTeamName(request.getParameter("teamid"));
	%>
	<h1>  Searched Member List by Team Name</h1>
	<table> 
	<tr> 
		<th>이름 </th>
		<th>TEAM ID</th>  
		<th>ID</th> 
		<th>AGE</th> 
		<th>ROLL</th> 
		<th>SSN</th>
		<th>PASSWORD</th>
	</tr>
	
<%-- 	<%	
		for(int i=0; i<lst.size(); i++){
		%> <tr> 
			<td> <%= lst.get(i).getName() %> </td>
			<td> <%= lst.get(i).getTeamId() %> </td>
			<td> <%= lst.get(i).getUserId() %> </td>
			<td> <%= lst.get(i).getAge() %> </td>
			<td> <%= lst.get(i).getRoll() %> </td>
			<td> <%= lst.get(i).getSsn() %> </td>
			<td> <%= lst.get(i).getPassword() %> </td>
			</tr> 
			<% }  %>
 --%>
 
 	<%	
		for(MemberBean m : lst){
		%> <tr> 
			<td> <%= m.getName() %> </td>
			<td> <%= m.getTeamid() %> </td>
			<td> <%= m.getUserid() %> </td>
			<td> <%= m.getAge() %> </td>
			<td> <%= m.getRoll() %> </td>
			<td> <%= m.getSsn() %> </td>
			<td> <%= m.getPassword() %> </td>
			</tr> 
			<% }  %>
 </table>
</body>


</html>
