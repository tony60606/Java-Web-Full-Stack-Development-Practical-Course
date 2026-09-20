/**
 * 
 */

function introduce() {
	
	const introduce = document.getElementById("introduce") ;
	introduce.textContent = "目前已學課程有：Java OCP JP程式設計師認證班、Python商業分析決策" ;
}


function birth() {
	
	const showbirth = document.getElementById("showbirth") ;
	showbirth.textContent = "很特別吧~4年才一次";
	
}

function getBMI() {
	
	let height = 170 ;
	let weight = 126 ; 
	let BMI = weight / ((height/100)*(height/100)) ;
	
	let show = "" ;
	
	show += `<ul>` ;
		show += `<li>我的身高為 ${height} 公分</li>` ;
		show += `<li>我的體重為 ${weight} 公斤</li>` ;
		show += `<li>我的BMI值為 ${BMI.toFixed(2)}</li>` ;
		if (BMI >=35) {
			show += `人家只是有點大隻，不要說出去唷` ;
		} else if (BMI < 18.5) {
			show += `WOW~我輕到可以飛上天拉~~` ;
		} else {
			show += `恩~剛好而已啦~` ;
		}
	show += `</ul>` ;
	
	document.getElementById("showBMI").innerHTML = show ;
}

function gotop() {
	window.scrollTo({
	        top: 0,
	        behavior: "smooth"
	    });
}