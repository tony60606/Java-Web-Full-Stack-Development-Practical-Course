<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品列表</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/main.css">
</head>
<body>
	<%@ include file="common/header.jsp"%>
	<%@ include file="common/nav.jsp"%>


	<main class="semantic-layout">
		<section class="product-list">

			<div id="cart-badge"
				style="position: fixed; top: 10px; right: 20px; background: #ff5252; color: white; padding: 4px 10px; border-radius: 20px; font-weight: bold; cursor: pointer;"
				onclick="location.href='${pageContext.request.contextPath}/cart'">
				🛒 <span id="cart-count">0</span>
			</div>

			<h2>飲料商品列表</h2>

			<c:if test="${empty products }">
				<p>目前沒有商品資料</p>
			</c:if>

			<c:if test="${not empty products }">
				<div class="products">
					<c:forEach var="p" items="${products }">
						<article class="product-card">
							<img src = "${pageContext.request.contextPath}/image/${p.sku}.png"
							 alt = "${p.name}"
							 class = "product-img">
							<h3>${p.name }</h3>
							<p>${p.description }</p>
							<p>價格：${p.price }</p>
							<p>庫存：${p.stock }</p>

							<div class="product-actions">
								<input type="number" id="qty-${p.sku}" value="1" min="1"
									style="width: 60px">
								<button type="button" onclick="addToCart('${p.sku}')">加入</button>
							</div>
						</article>

					</c:forEach>
				</div>

			</c:if>

		</section>

	</main>

	<script>
		  const ctx = "${pageContext.request.contextPath}";
		  const cartAddUrl = ctx + "/api/cart/items";
		  const cartGetUrl = ctx + "/api/cart";		
		
		  async function addToCart(sku) {
		    const qty = getQtyBySku(sku);		
		
		    const resp = await fetch(cartAddUrl, {
		      method: "POST",
		      credentials: "same-origin",   // 讓 JSESSIONID 一定會帶上（同源）
		      headers: { "Content-Type": "application/json", "Accept": "application/json" },
		      body: JSON.stringify({ sku, qty })
		    });		
		
		    const data = await resp.json();
		
		    if (!resp.ok) {
		      alert(data.message || "加入失敗");
		      return;
		    }
		
		    const count = data.items.reduce((s, it) => s + it.qty, 0);
		    document.getElementById("cart-count").innerText = count;
		  }	
		  
		
		  function getQtyBySku(sku) {
			  const el = document.getElementById("qty-" + sku);
			  if (!el) {
			    console.error("qty input not found for sku=", sku);
			    return 1; // 找不到就給預設 1，避免整個爆掉
			  }
			  return parseInt(el.value, 10) || 1;
			}
		
		
		
		  // 初始化 badge
		  window.addEventListener("DOMContentLoaded", async () => {
		    const resp = await fetch(cartGetUrl, {
		      headers: { "Accept": "application/json" }
		    });
		    if (!resp.ok) return;
		
		    const data = await resp.json();
		    const count = data.items.reduce((s, it) => s + it.qty, 0);
		    document.getElementById("cart-count").innerText = count;
		  });
	</script>

	<%@ include file="common/footer.jsp"%>

</body>
</html>