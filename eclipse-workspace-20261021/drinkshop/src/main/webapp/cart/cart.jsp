<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>     
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>購物車</title>
<link rel = "stylesheet" href="${pageContext.request.contextPath}/css/main.css">
<style>
.cart-wrap {
	max-width: 100%;
	margin: 0 auto;
}

.cart-item {
	display: flex;
	gap: 12px;
	align-items: center;
	padding: 10px;
	border-bottom: 1px solid #eee;
}

.cart-item img {
	width: 60px;
	height: 60px;
	object-fit: cover;
	border-radius: 6px;
}

.cart-item .name {
	flex: 1;
}

.cart-item .price, .cart-item .subtotal {
	width: 120px;
	text-align: right;
}

.cart-item .qty {
	width: 90px;
}

.cart-actions {
	display: flex;
	gap: 10px;
	justify-content: flex-end;
	margin-top: 12px;
}

.total {
	text-align: right;
	font-size: 18px;
	font-weight: bold;
	margin-top: 12px;
}

button {
	cursor: pointer;
}
</style>

</head>
<body>

	<%@ include file = "/common/header.jsp" %>
	<%@ include file = "/common/nav.jsp" %>
	
	<main class = "semantic-layout">
		<section class = "cart-wrap">
			<h2>購物車</h2>
			<div id = "cart-empty" style = "display : none">
			<p>購物車目前是空的</p>
			<button onclick="location.href='${pageContext.request.contextPath}/products'">←返回商品購物</button>
			</div>
			<div id = "cart-list"></div>
			<div class="total">
				總金額：$<span id="cart-total">0.00</span>
			</div>

			<div class="cart-action">
				<button onclick="goCheckout()">前往結帳</button>
			</div>
		</section>
	</main>
	
	
	<%@ include file = "/common/footer.jsp" %>
<script>
  const ctx = "${pageContext.request.contextPath}";
  const cartGetUrl = ctx + "/api/cart";
  const cartUpdateUrl = sku => ctx + "/api/cart/items/" + encodeURIComponent(sku);
  const cartRemoveUrl = sku => ctx + "/api/cart/items/" + encodeURIComponent(sku);

  async function loadCart() {
    const resp = await fetch(cartGetUrl, {
      method: "GET",
      credentials: "same-origin",
      headers: { "Accept": "application/json" }
    });

    if (!resp.ok) {
      alert("讀取購物車失敗");
      return;
    }
    const cart = await resp.json();
    renderCart(cart);
  }

  function renderCart(cart) {
    const listEl = document.getElementById("cart-list");
    const emptyEl = document.getElementById("cart-empty");

    listEl.innerHTML = "";

    const items = cart.items || [];
    if (items.length === 0) {
      emptyEl.style.display = "block";
      document.getElementById("cart-total").innerText = "0.00";
      return;
    }

    emptyEl.style.display = "none";

    items.forEach(it => {
      const row = document.createElement("div");
      row.className = "cart-item";

      const img = document.createElement("img");
      img.src = ctx + "/image/" + it.sku + ".png";
      img.onerror = () => img.src = ctx + "/image/no-image.png";

      const name = document.createElement("div");
      name.className = "name";

      const title = document.createElement("b");
      title.textContent = it.name || it.sku;

      const skuLine = document.createElement("div");
      skuLine.textContent = "SKU：" + it.sku;

      name.appendChild(title);
      name.appendChild(document.createElement("br"));
      name.appendChild(skuLine);

      const price = document.createElement("div");
      price.className = "price";
      price.innerText = "$" + formatMoney(it.price);

      const qty = document.createElement("input");
      qty.className = "qty";
      qty.type = "number";
      qty.min = "1";
      qty.value = it.qty;
      qty.onchange = () => updateQty(it.sku, qty.value);

      const subtotal = document.createElement("div");
      subtotal.className = "subtotal";
      subtotal.innerText = "$" + formatMoney(it.subtotal);

      const delBtn = document.createElement("button");
      delBtn.innerText = "移除";
      delBtn.onclick = () => removeItem(it.sku);

      row.appendChild(img);
      row.appendChild(name);
      row.appendChild(price);
      row.appendChild(qty);
      row.appendChild(subtotal);
      row.appendChild(delBtn);
      listEl.appendChild(row);
    });

    document.getElementById("cart-total").innerText = formatMoney(cart.total);
  }

  async function updateQty(sku, qty) {
    const n = parseInt(qty, 10);
    if (!n || n <= 0) return;

    const resp = await fetch(cartUpdateUrl(sku), {
      method: "PUT",
      credentials: "same-origin",
      headers: { "Content-Type": "application/json", "Accept": "application/json" },
      body: JSON.stringify({ sku, qty: n })
    });

    const data = await resp.json();
    if (resp.ok) renderCart(data);
  }

  async function removeItem(sku) {
    const resp = await fetch(cartRemoveUrl(sku), {
      method: "DELETE",
      credentials: "same-origin",
      headers: { "Accept": "application/json" }
    });

    const data = await resp.json();
    if (resp.ok) renderCart(data);
  }

  function goCheckout() {
    location.href = ctx + "/orders/checkout";
  }

  function formatMoney(v) {
    return Number(v || 0).toFixed(2);
  }

  window.addEventListener("DOMContentLoaded", loadCart);
</script>
</body>
</html>