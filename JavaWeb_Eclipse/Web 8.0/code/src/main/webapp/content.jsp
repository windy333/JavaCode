<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<! DOCTYPE HTML PUBLIC"-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>文章内容</title>
	
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	 
	<link rel="stylesheet" type="text/css" href=" ${ pageContext.request.contextPath}/css/content.css">

	</head>

<body>

<div class="div_01">
	<h3>${article.articTitle}</h3>
</div>

<div class="div_02">
	作者:${article.articAuthor}上传时间:${article.articTime}
</div>

<div class ="div_03">
	${article.articContent}
</div>

<div class="div04">
	<a href="javascript:window.opener=null;window.open('user.jsp'); window.close();">【关闭】</a>
</div>

</body>
</html>