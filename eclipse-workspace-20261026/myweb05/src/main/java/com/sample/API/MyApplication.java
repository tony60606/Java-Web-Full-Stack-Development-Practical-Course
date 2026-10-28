package com.sample.API;


import java.util.Set;
//匯入 Jakarta RESTful Web Services 核心配置註解與類別
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;


//Jakarta RESTful Web Services 3.0 API Specification： https://jakarta.ee/specifications/restful-ws/3.0/apidocs/

/**
* RESTful Web Services 應用程式組態入口類別
*
* @ApplicationPath("v1"):
* 設定所有 REST API 服務端點的起始根路徑（全域路徑前綴）
* 完整服務進入位址為：http://localhost:8080/myweb05/v1/...
*/

//配置服務入口位置 http://localhost:8080/myweb05/v1/....
@ApplicationPath("v1") //v1->自訂名稱->服務端點的起始位置
public class MyApplication extends Application{
	
	/**
	 * 覆寫父類別的 getClasses 方法
	 * 用途：宣告並向容器註冊此 REST 應用程式所包含的資源類別（Resources）與提供者（Providers）
	 * 
	 * @return 包含所有註冊類別 Class 物件的 Set 集合
	 */
	
	
	@Override
	public Set<Class<?>> getClasses() {
		// 回傳父類別預設的空集合；在具備類別掃描機制的 JAX-RS 容器中，
		// 容器會自動掃描同 package 與子 package 內所有標註 @Path 的資源類別
		return super.getClasses();
	}
	
	
}
