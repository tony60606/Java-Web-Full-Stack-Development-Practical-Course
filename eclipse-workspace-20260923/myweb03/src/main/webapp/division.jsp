<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>EL 運算式語言</h1>

<h3>25 + 3 = ${25 + 3}</h3>
<h3>25 / 3 = ${25 / 3}</h3>
<h3>25 / 0 = ${25 / 0}(得到正無限大結果)</h3>

<hr>

<h2>用 EL 取出表單送過來的參數進行運算</h2>

<h3>${param.a} / ${param.b} = ${param.a / param.b}</h3>

<h3>${param.a} > ${param.b} ： ${param.a > param.b}</h3>
</body>
</html>