package com.sample.API;


import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
/*
 * 打招呼類別
 * @Path("")：定義此Controller/Service的基礎路徑
 * 
 */
@Path("Hello")
public class HelloService {
	
	//端點一：基本無參數服務
	@Path("helloworld") // 定義方法的子路徑
	@GET				// 設定 Request Method GET - 查詢
	@Produces("text/Plain ; charset=utf-8") // 設定回應的標頭 Context type為純文字 UTF-8編碼
	public String helloworld() {
		//會直接回傳此字串，JAX-RS會將此字串作為HTTP Response Body 輸出站端點
		return "Hello World服務" ;
	}
	
	//端點二：使用 Query String (查詢字串) 傳遞參數
	@Path("hihello")
	@GET
	@Produces("text/Plain ; charset=utf-8")
	public String hihello(@QueryParam("w")String who) {
		// @QueryParam("w")：會自動擷取 URL 問號後方的 key 為 "w" 的參數值
		//若網址為寫 ?w=，who 的值會預設為null
		return who + "您好" ;
	}
	
	//端點三：使用 Path(動態路徑/路徑參數) 傳遞參數
	//使用 {who} 作為動態路徑佔位符，代表此位置的任意字串皆可被比對
	@Path("webhello/{who}/rawdate")
	@GET
	@Produces("text/Plain ; charset=utf-8")
	//@PathParam("who")：將路徑中who的值帶入 Java 參數 name 中
	public String webhello(@PathParam("who") String name) {
		return name + "您好，吃飽沒" ;
	}
	
}
