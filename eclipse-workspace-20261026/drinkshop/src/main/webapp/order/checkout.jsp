<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>購物車結帳</title>

<link rel = "stylesheet" href="${pageContext.request.contextPath}/css/main.css">
</head>
<body>

	<%@ include file = "/common/header.jsp" %>
	<%@ include file = "/common/nav.jsp" %>
	
	<main class = "semantic-layout">
		<section class = "cart-wrap" >
			<h2>結帳確認</h2>
			<p>確認後將建立訂單，請確認購物車內容是否正確</p>
			<button onclick = "location.href='${pageContext.request.contextPath}/cart'">返回購物車</button>
			<button onclick = "checkout()">確定送出訂單</button>
		</section>
	</main>
	
	<%@ include file = "/common/footer.jsp" %>
	
	<script>
    const ctx = "${pageContext.request.contextPath}";

    async function checkout() {
        const resp = await fetch(ctx + "/api/orders/checkout", {
            method: "POST",
            credentials: "same-origin"
        });

        if (!resp.ok) {
            alert(await resp.text());
            return;
        }

        location.href = ctx + "/products";
    }
	</script>
	
</body>
</html>