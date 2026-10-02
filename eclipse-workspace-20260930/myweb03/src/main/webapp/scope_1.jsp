<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<h1>scope_1.jsp</h1>

<%
	//宣告區域變數
	String com = "巨匠電腦" ;
	String scopeA = "PageContext" ;
	String scopeB = "request" ;
	String scopeC = "session" ;
	String scopeD = "application" ;
	
	//封裝區域變數
	pageContext.setAttribute("company",scopeA ) ;
	
	request.setAttribute("company", scopeB) ;
	
	session.setAttribute("company", scopeC) ;
	
	application.setAttribute("company", scopeD) ;
	
%>

<fieldset>
	<legend>
		使用EL運算式讀取資料
	</legend>
	<p>讀取區域變數com：${com}(EL無法讀取區域變數)</p>
	<p>讀取參照物件company：${company}</p>
	<P>使用EL pageScope.company：${pageScope.company}</P>	
</fieldset>
<fieldset>
	<legend>
		讀取page scope資料
	</legend>
	<p>使用表達式讀取區域變數com：<%= com %></p>
	<p>使用表達式讀取區域變數scopeA：<%= scopeA %></p>
	<p>使用表達式pageContext的company： <%= pageContext.getAttribute("company") %></p>
	<P>使用EL pageScope.company：${pageScope.company}</P>
</fieldset>
<fieldset>
	<legend>
		讀取request scope資料
	</legend>
	<p>使用表達式request的company：<%= request.getAttribute("company") %></p>
	<P>使用EL requestScope.company：${requestScope.company}</P>
	
	<!-- 將request屬性傳遞到scope_2.jsp -->
	<!-- [測試一]純超連結 request的屬性不會跟著傳遞 -->
	<p><a href = "scope_2.jsp">scope_2.jsp</a></p>
	
	<!-- [測試二]用Action Elements forward (會自動跳轉)request的資料過去 -->
	<jsp:forward page="scope_2.jsp"></jsp:forward>
</fieldset>
<fieldset>
	<legend>
		讀取session scope資料
	</legend>
	<p>使用表達式session的company：<%= session.getAttribute("company") %></p>
	<P>使用EL sessionScope.company：${sessionScope.company}</P>
</fieldset>
<fieldset>
	<legend>
		讀取application scope資料
	</legend>
	<p>使用表達式applicationn的company：<%= application.getAttribute("company") %></p>
	<P>使用EL applicationScope.company：${applicationScope.company}</P>
</fieldset>

<p><a href = "index.jsp">回首頁</a></p>


</body>
</html>