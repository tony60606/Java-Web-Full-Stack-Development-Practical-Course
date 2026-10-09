/**
 * 
 */

function Success() {
	setTimeout(function() {
	    window.location.href = contextPath + "/td/To-do.jsp";
	}, 2000);
}

function logout() {
	
	document.cookie = "cred=; max-age=0; path=/homework0930";

	 window.location.href = contextPath + "/index.jsp";
	 
}
