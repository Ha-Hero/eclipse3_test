<%@page import="java.util.ArrayList"%>
<%@page import="bean.bean"%>
<%@page import="java.util.Date" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>一覧</title>
</head>
<body>

<form action="/JavaTask_1/Main" method="get">
	<input type="submit" value="一覧画面">

</form>
<p>====================================================================</p>
	<%

	ArrayList<bean> list = (ArrayList<bean>)request.getAttribute("list");
	for(int i = 0 ; i < list.size() ; i++){
		bean bean = list.get(i);
	%>

		<form action="/JavaTask_1/Delete" method="get">
			<p ><%=bean.getForm() %></p>
			<p>投稿者：<%=bean.getName() %>   投稿時間：<%=bean.getTime() %></p>
			<input type="submit" value="削除">
			<input type="hidden" name="id" value=<%=bean.getId() %> >
		</form>
<p>------------------------------------------------------------------------------------------------------------------</p>

<%}%>
</body>

<script>

</script>
</html>