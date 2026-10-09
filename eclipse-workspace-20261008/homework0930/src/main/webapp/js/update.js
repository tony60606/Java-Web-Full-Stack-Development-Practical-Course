/**
 * 
 */


function Update() {
	
	fetch(contextPath + "/searchqry").then(Response => Response.json()).then(data => {
		
		const select =document.getElementById("indexselect") ;
			
		data.forEach((todo , index) => {
			if (todo.deletetime == null) {
				select.add(new Option(todo.date + " - "  + todo.title , index)) ;		
			}
		}) ;
		
		select.addEventListener("change", () => {
	
		    const todo = data[select.value];
	
		    document.getElementById("date").value = todo.date;
		    document.getElementById("title").value = todo.title;
		    document.getElementById("content").value = todo.content;
	
		});
		
	});
	
}