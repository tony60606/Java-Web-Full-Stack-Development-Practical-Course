/**
 * 
 */


function func01() {
	document.write("從function執行document.write()輸出") ;
}

function func02() {
	let name = "Tony" ;
	let age = 55 ;
	let phone = null ;
	let Email ;
	
	let result = " "  ;
	
	result += name + "的型別" + typeof(name) + "<br>" ; 
	result += age + "的型別" + typeof(age) + "<br>" ; 
	result += phone + "的型別" + typeof(phone) + "<br>" ; 
	result += Email + "的型別" + typeof(Email) + "<br><br>" ; 
	
	document.getElementById("showfunc02-1").innerHTML = result ;
	
	result = `${name}的型別是${typeof(name)}<br>
	${age}的型別是${typeof(age)}<br>
	${phone}的型別是${typeof(phone)}<br>
	${Email}的型別是${typeof(Email)}<br><br>` ;
	
	document.getElementById("showfunc02-2").innerHTML = result ;
}

function func03() {
	let person = {
		name : "Tom" ,
		age : 28 ,
		item : "Tuba"
	} ;
	
	const show = `
		表演者名稱：${person.name}<br>
		表演者年紀：${person.age}<br>
		表演項目：${person.item}<br>
	` ;
	
	document.getElementById("showfunc03").innerHTML = show ;
	
}

function func04() {
	let color = ["Red","Green","Blue"] ;
	
	let colorname = new Array("紅色","綠色","藍色") ;
	
	let result = " " ;
	
	result = `${color[0]}的對應中文是${colorname[0]}<br>
	${color[1]}的對應中文是${colorname[1]}<br>
	${color[2]}的對應中文是${colorname[2]}<br>
	` 
	document.getElementById("showfunc04").innerHTML = result ;
}

function func05() {
	
	let quantity = 15 ;
	let price = 500 ;
	let result = quantity * price ;
	
	let show =`quantity = ${quantity}<br>
	price = ${price}<br>
	總額為 = ${result}<br>`
	
	document.getElementById("showfunc05").innerHTML = show ;
}

function func06() {
	
	let result = " " ;
	
	for(let i = 0 ; i <= 10 ; i++) {
		result += i + "<br>" ;	
	}
	
	document.getElementById("showfunc06").innerHTML = result ;
	
}

function func07() {
	
	let point = 200 ;
	let vip = point >= 100 ;
	
	let result = " " ;
	
	result = `目前會員點數：${point}。是否為VIP：${vip}`  ;
	
	document.getElementById("showfunc07-1").innerHTML = result ;
	
	let coupon = true ;
	let discount = false ;
	
	if (vip && (coupon || discount)) {
		result = `可以折扣會員點數${point}點` ;
	} else {
		result = `會員點數${point}點無法折扣`
	}
	
	document.getElementById("showfunc07-2").innerHTML = result ;
	
	
}



