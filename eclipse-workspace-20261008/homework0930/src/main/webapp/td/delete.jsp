<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>刪除代辦事項</title>

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">

</head>
<body>

<h1>刪除代辦事項</h1>

<form action="${pageContext.request.contextPath}/deleteqry" method = "post">
	
 <p class="formrow">
    <label>選擇代辦事項：</label>	
	<select name = "index" id = "indexselect" required>
		<option value="" selected disabled>請選擇</option>
	</select>
</p>

<p class = "formrow">
	<label>日期：</label>
	<input type="date" name="date" id="date" required>
</p>
<p class = "formrow">
	<label>代辦項目：</label>
	<input type = "text" name = "title" id = "title" />
</p>
<p class = "formrow">
	<label>事項內容：</label>
	<textarea name = "content" id = "content" rows="10" cols="100"></textarea>
</p>

<div class = "btn">
<button type="submit" onclick="return confirm('確定要刪除這筆代辦事項嗎？')">確認刪除</button><button type="reset">取消</button>
</div>

</form>

<p><a href ="To-do.jsp">回首頁</a></p>

<script>
    const contextPath = "${pageContext.request.contextPath}";
</script>

<script src="${pageContext.request.contextPath}/js/update.js"></script>

<script>
    Update();
</script>


</body>
</html>