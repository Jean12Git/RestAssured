package test;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

public class testexample5 {
/*
	@Test
	public void test1() {

		Response response =	get("https://reqres.in/api/users?page=2");
		System.out.println(response.getStatusCode());
		System.out.println(response.getTime());
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusLine());
		System.out.println(response.getHeader("content-type"));

		int statuscode = response.getStatusCode();
		Assert.assertEquals(statuscode, 200);
	}

	@Test
	public void test2() {

		baseURI = "https://reqres.in/api";
		given().get("/users?page=2").then().statusCode(200).body("data[1].id", equalTo(8)).log().all();
//		given().
//		get("/users?page=2").
//		then().
//		statusCode(200).
//		body("data[1].id", equalTo(8));
	}

	@Test
	public void testGet() {

		baseURI = "https://reqres.in/api";
		given().get("/users?page=2").then().statusCode(200).
		body("data[4].first_name", equalTo("George")).
		body("data.first_name", hasItems("George","Rachel"));
	}
*/
	@Test
	public void testPost() {
		
//		Request -- Option1		
/*			
	Map<String,Object> map = new HashMap<String, Object>();
	map.put("\"name\"", "ABC");
	map.put("\"job\"", "teacher");
	System.out.println(map);
*/	
		
		
//	Request -- Option2
/*	
	Map<String,Object> map = new HashMap<String, Object>();
	map.put("name", "ABC");
	map.put("job", "teacher");
	JSONObject request = new JSONObject(map); 
	System.out.println(request.toJSONString());
*/	
		
		
//	Request -- Option3 (Need "json simple" jar)
	
	JSONObject request2 = new JSONObject(); 
	
	request2.put("name", "ABC");
	request2.put("job", "Teacher");
	
	System.out.println(request2);
	System.out.println(request2.toJSONString());
	
	baseURI = "https://reqres.in/api";
	
	given().
		header("Content-Type", "application/json").
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(request2.toJSONString()).
	when().
		post("/users").
	then().
		statusCode(201).log().all();

	}
	
	
	@Test
	public void testPut() {
	
		JSONObject request3 = new JSONObject(); 
		
		request3.put("name", "ABC");
		request3.put("job", "Teacher");
		
		System.out.println(request3);
		System.out.println(request3.toJSONString());
		
		baseURI = "https://reqres.in/api";
		
		given().
			header("Content-Type", "application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request3.toJSONString()).
		when().
			put("/users/2").
		then().
			statusCode(200).
			log().all();

		}
	
	@Test
	public void testPatch() {
	
		JSONObject request3 = new JSONObject(); 
		
		request3.put("name", "ABC");
		request3.put("job", "Teacher");
		
		System.out.println(request3);
		System.out.println(request3.toJSONString());
		
		baseURI = "https://reqres.in";
		
		given().
			header("Content-Type", "application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request3.toJSONString()).
		when().
			patch("/api/users/2").
		then().
			statusCode(200).
			log().all();

		}
	
	@Test
	public void testDelete() {
	
		JSONObject request3 = new JSONObject(); 
		
		request3.put("name", "ABC");
		request3.put("job", "Teacher");
		
		System.out.println(request3);
		System.out.println(request3.toJSONString());
		
		baseURI = "https://reqres.in";
		
		given().
			header("Content-Type", "application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request3.toJSONString()).
		when().
			delete("/api/users/2").
		then().
			statusCode(204).
			log().all();

		}
}
