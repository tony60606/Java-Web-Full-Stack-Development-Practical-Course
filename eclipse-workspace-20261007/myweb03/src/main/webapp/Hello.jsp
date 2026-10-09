<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- HTML註解 -->
<%-- JSP註解 --%>

<%--JSP轉譯成Servlet 的檔案路徑 --%>
<%--C:\Users\ttoon\Full data\eclipse-workspace-20260921\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\work\Catalina\localhost\myweb03\org\apache\jsp --%>

<%-- scriptlet <% %>：撰寫JAVA語法，都會放在_jspService()方法，用來宣告區域變數或撰寫敘述句 --%>
<% 
	//Java註解
	String address = "台北市中正區公園路30號3樓" ;
%>

<h3><% out.println("區域變數address：" + address); %></h3>

<%--宣告元素 <%! %> --%>
<%!
	private String companyname ;
	
	//覆寫方法 jspInit()
	
	public void jspInit() {
		this.companyname = "巨匠電腦" ;
	}
	
	//自訂方法(物件成員方法)
	
	public String getmessage(String name) {
		return name.format("%s %s網站程式開發",this.companyname,name) ;
	}
%>
<h2>
	<font color = "Green">
		<% 
			out.println("物件成員 companyname" + this.companyname + "，" + getmessage("JAVA")) ;
		%>
	</font>
</h2>

<%--運算式元素 <%= %>：只能寫一行字沒有分號，會使用out.println輸出 --%>
<h3>
	[運算式元素] 輸出getmessage() ： <%= this.getmessage("Python") %>
</h3>

</body>
</html>