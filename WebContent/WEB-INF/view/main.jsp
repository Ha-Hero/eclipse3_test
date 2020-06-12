<%@page import="java.util.ArrayList"%>
<%@page import="bean.bean"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>一覧</title>
</head>
<body>

	<form action="/JavaTask_1/Admin" method="get">
	<input type="submit" value="管理者画面">

	</form>

	<form action="/JavaTask_1/Add" method="get">
		名前：<input type="text" name="name" id="name"><br>
		メール:<input type="text" name = "mail" id="mail"><br>
		内容:<input type="text" name = "form" id="form"><br>
		<input type="submit" value="追加">
	</form>

<p>====================================================================</p>
		<%
		ArrayList<bean> list = (ArrayList<bean>)request.getAttribute("list");
		for(int i = 0 ; i < list.size() ; i++){
			bean bean = list.get(i);
		%>
				<p><%=bean.getForm() %></p>
				<p>投稿者：<%=bean.getName() %>   投稿時間：<%=bean.getTime()%></p>

	<form id="my_form" action="upload" method="post" enctype="multipart/form-data" >
      <input type="file" name="input_file" > <br>
      <input type="submit" value="送信" >
    </form>
<p>------------------------------------------------------------------------------------------------------------------</p>

		<%}%>


</body>
<script>

const fileInput = document.getElementById('input_file');

const handleFileSelect = () => {
	  const files = fileInput.files;
	  for (let i = 0; i < files.length; i++) {
	    console.log(files[i]);　// 1つ1つのファイルデータはfiles[i]で取得できる
	  }
	}

</script>
</html>