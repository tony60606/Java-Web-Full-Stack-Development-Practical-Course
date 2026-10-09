/**
 * 
 */

function Search() {
	fetch(contextPath + "/searchqry").then(Response => Response.json()).then(data => {
		
		let result = "" ;
			
		data.sort((a, b) => a.date.localeCompare(b.date));
		
		data.forEach(todo => {
			result += 
				`
				<tr>
					<td>${todo.date}</td>	
					<td>${todo.title}</td>
					<td>${todo.content}</td>
					<td>${todo.createdby || ""}</td>
					<td>${todo.createtime || ""}</td>
					<td>${todo.updatedby || ""}</td>
					<td>${todo.updatetime || ""}</td>
					<td>${todo.deletedby || ""}</td>
					<td>${todo.deletetime || ""}</td>
				</tr>
				` ;
		}) ;
		document.getElementById("todoList").innerHTML = result;		
	}) ;
}