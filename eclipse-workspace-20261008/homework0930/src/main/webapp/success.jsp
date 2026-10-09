<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登入成功</title>

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">

</head>
<body>

<h2>驗證成功</h2>
<h2>2秒後自動跳轉至代辦事項系統頁面</h2>

<script>
    const contextPath = "${pageContext.request.contextPath}";
</script>

<script src ="${pageContext.request.contextPath}/js/jsstyle.js"></script>

<script>
    Success();
</script>

</body>
</html>