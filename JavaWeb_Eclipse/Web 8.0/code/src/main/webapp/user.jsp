<%@ page language="java" import="java.util. * , model.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<! DOCTYPE HTML PUBLIC"-//W3C//DTD HTML 4.01 Transitional//EN"><html>
<html>
  <head>
    <title>员工之窗</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel ="stylesheet" type=" text/css" href=" ${pageContext.request.contextPath}/css/user.css">
　　<link rel ="stylesheet" type="text/css" href="<%=request. getContextPath()%>"+"/css/user.css">

  </head>
  <body >
 
     <div class="div_01">
     	<h1>员工之窗</h1>
     </div>
     <jsp:useBean id="date" class="java.util.Date" /> 
     <jsp:useBean id="user" class="model.User" scope="session"></jsp:useBean> 
 
	 <jsp:setProperty name="user"  property="userName"/>
     <jsp:setProperty name="user"  property="userPwd" />
     
     <div class="div_02">
     	<span class="span_01"> <jsp:getProperty name="user" property="userName"/>
     	 <jsp:getProperty name="user" property="userPwd"/></span>，欢迎你来到员工之窗。
     	<br/>
     	当前时间：<div id="span_02"><%= date %></div>
     </div>
     
     <div class="div_03">
     	<table border="1" cellspacing="0" align="center">
     		<tr>
     			<th id="th_01">文章编号</th>
     			<th id="th_01">文章类型</th>
     			<th id="th_01">标题</th>
     			<th id="th_01">作者</th>
     			<th id="th_01">发表日期</th>
     		</tr>	
     	
     	
     	<c:forEach items="${articlesList}" var="article">
            <tr>
                 <td class="td_01">${article.articID}</td>
                 <td class="td_01">${article.articType}</td>
                 
                 <td class="td_01"><a href="${pageContext.request.contextPath
                 }/GetArticleServlet?articID=${article.articID}" target="_ blank">${article.articTitle}
                 </a></td>
                 
                 <td class="td_01">${article.articAuthor}</td>
                 <td class="td_01"><fmt:formatDate value="${article.articTime}" pattern="yyyy/MM/dd"/></td>
                              
			</tr>
		</c:forEach>

	</table><br/>
     	
     	<a href="${pageContext.request.contextPath }/publish.jsp">【发表文章】</a>&nbsp;&nbsp;&nbsp;
     	<a href="${pageContext.request.contextPath }/login.jsp">【退出登录】</a>&nbsp;&nbsp;&nbsp;
     	<a href="${pageContext.request.contextPath }/mainWindow.jsp">【新闻页】</a>
     </div>
     
     <!--  
     	<script type="text/javascript">
     	function time2(){
     		var time = (data.getFullYear()+"/"+(data.getMonth()+1)+"/"+data.getDate()
     				+" "+data.getHours()+":"+data.getMinutes());
     		doucument.getElementByld("span_02").innerHTML=time;
     		window.setInterval(time2(),10000);
     	}
     	</script>	
     -->
     
  </body>
</html>