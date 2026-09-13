/**
 * 
 */

//一般函式建立

function func01() {
	document.write("從function執行document.write()輸出") ;
	
}

function func02() {
	//使用let 宣告可變變數
	//原始型別
	let username = "Tom" ; //String 字串
	let age = 30 ; //Number 數字
	let ismember = true ; //Boolean 布林值
	let futurejob = null ; //Null 明確表示空值
	let unassignedVar ; // Undefined 為定義
	
	//使用 typeof 檢查型別
	//1.宣告一個變數來儲存要輸出內容
	let result = " " ;
	//2.利用 += 將字串與變數串聯
	result += username + " 的型別 = " + typeof(username) + "<br>" ;
	result += age + " 的型別 = " + typeof(age) + "<br>" ;
	result += ismember + " 的型別 = " + typeof(ismember) + "<br>" ;
	result += futurejob + " 的型別 = " + typeof(futurejob) + "<br>" ;
	result += unassignedVar + " 的型別 = " + typeof(unassignedVar) + "<br><br>" ;
	
	document.getElementById("showfunc02_1").innerHTML = result ;
	
	result = `
		${username} 型別：${typeof(username)}<br>
		${age} 型別：${typeof(age)}<br>
		${ismember} 型別：${typeof(ismember)}<br>
		${futurejob} 型別：${typeof(futurejob)}<br>
		${unassignedVar} 型別：${typeof(unassignedVar)}<br>
	` ;
	
	document.getElementById("showfunc02_2").innerHTML = result ;
	
	//複雜型別：物件 (Object)
	let person = {
		name : "Tony",
		age : 32,
		city : "Taipei"
	} ;
	
	//使用const宣告不可重新指定的變數
	const message = `
		名字：${person.name}<br>
		年齡：${person.age}<br>
		city：${person.city}<br><br>
	`
	document.getElementById("showfunc02_3").innerHTML = message ;
	//複雜型別：陣列一
	let color = ["R", "G" ,"B"] ;
	
	//複雜型別：陣列二
	let colorname = new Array("紅色","綠色","藍色") ;
	const getcolor =`${color[0]} => ${colorname[0]}.${color[1]} => ${colorname[1]}.${color[2]} => ${colorname[2]}`
	document.getElementById("showfunc02_4").innerHTML = getcolor ;
	
	
}


function func03() {
	let result = " " ;
	//宣告變數
	let price = 100 ;
	let count = 5 ;
	
	//算數運算子
	//計算並賦值
	let subtotal = price * count ;
	result = `
		價格：${price} <br>
		數量：${count} <br>
		金額：${subtotal} <br>
	`
	
	//複合賦值 += -= *= /= %=
	//加10%服務費
	subtotal *= 1.1 ;
	result += `加服務費後總金額為${subtotal}<br>` ;
	
	//比較運算子
	let point = 200 ;
	let candiscount = point >= 100 ;
	result += `目前點數：${point}.優惠需要點數：${100}.是否有優惠：${candiscount}<br>` ;
	
	//邏輯運算子
	let vip = false ;
	let coupon = true ;
	let discount = coupon && (candiscount || vip) ;
	result += `
	目前點數：${point} <br>
	是否是vip：${vip} <br>
	是否有折價券：${coupon} <br> 
	最後是否可以得到優惠：${discount}<br>` ; 
	
	document.getElementById("showfunc03_1").innerHTML = result ;
	
}

function func04() {
	let result = " " ; 
	
	let a = "5" ;
	let b = "200" ;
	let c = "16" ;
	let d = null;
	
	let i = a + b + c ;
	
	result += `目前 i 的值：${i}<br>` ;
	
	let j = a - b - c ;
	result += `目前 j 的值：${j}<br>` ;
	
	let k = d * 100 ;
	result += `目前 k 的值：${k}<br>` ;
	
	result += "------------------------------<br>" ;
	
	result += "將a.b轉型為數值<br>" ;
	
	let x = parseInt(a) ;
	let y = parseFloat(b) ;
	
	result += `${x}的資料型別為：${typeof(x)}<br>` ;
	result += `${y}的資料型別為：${typeof(y)}<br>` ;
	
	result += ` x + y = ${ x + y }<br>` ;
	result += ` x - y = ${ x - y }<br>` ;
	
	
	document.getElementById("showfunc04_1").innerHTML = result ;
}

function func05() {
	try {
		let heightpt = prompt("請輸入身高(cm)：") ;
		let weightpt = prompt("請輸入體重(kg)：") ;
		
		let height = Number(heightpt) ;
		let weight = Number(weightpt) ;
		
		let BMI = 0.0 ;
		
		//檢查是否轉換成功(如果輸入非數值資料，Number()會變成NaN)
		if(isNaN(height) || isNaN(weight)) {
			throw new Error ("輸入資料格式錯誤，請重新輸入") ;
		} else {
			BMI = weight / ((height / 100) * (height / 100)) ;
		} 
		
		let result = " " ;
		if(BMI >= 24) {
			result = "異常(過重)" ;
		} else if (BMI >= 18.5){
			result = "正常" ;
		} else {
			result = "異常(過輕)"
		} 
		
		alert(`您的 BMI 值為：${BMI.toFixed(2)}\n判別結果：${result}`); // toFixed(2) 四捨五入到小數點後2位
		
		
	} catch (error) {
		//發生錯誤時，會進入彈出視窗
		alert(["發生錯誤"] + error.message) ;
	}
}

//-------------------

const Square = function(Number) {
	document.getElementById("showsquare").innerHTML = Number * Number ;
}
	
function calculateSquare() {
	let inputnuber = Number(document.getElementById("userinput").value) ;
	Square(inputnuber) ;
}

const Multply = (a,b) => {return a * b} ;

function calculatemultiply(a,b) {
	let result = Multply(a ,b) ;
	document.getElementById("showmultiply").innerHTML = `${a} * ${b} = ${result} ` ;
}