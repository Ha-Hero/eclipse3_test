<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
Cookie cookie = new Cookie("visited","hatake");
response.addCookie(cookie);
cookie.setMaxAge(3);
Cookie[] cks = request.getCookies();
String aki = null;

if(cks != null){
	for(int ck=0; ck<cks.length; ck++){
		if(cks[ck].getName().equals("visited")){
			aki = cks[ck].getValue();
		}
	}
}


if(aki == null){
	out.print("<p>hatake</p>");
	cookie.setMaxAge(3);
	response.addCookie(cookie);
}
else {
	out.print("<p>cookieが破棄されました</p>");
	cookie.setMaxAge(3);
	response.addCookie(cookie);
}
%>
<!doctype html>
<html lang="ja">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
</head>
<body>
​
<!-- Japascript jQuery -->
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>
<script>
$(function(){
	$('#cookie-set').html('JS Cookie: ' + $.cookie('CookieTestName'));
});
</script>
</body>
</html>