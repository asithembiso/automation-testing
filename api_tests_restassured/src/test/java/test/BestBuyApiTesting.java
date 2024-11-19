package test;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.BeforeClass;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class BestBuyApiTesting {
	
	@BeforeClass
	public void setup() {
		RestAssured.baseURI = "http://localhost/";
		RestAssured.port = 3030;
	}
	
	@Test
	public void verifyGetProduct() {
		RestAssured.given().when().get("/products").then().statusCode(200);
	}

	@Test
	public void verifyGetProductWithId() {
		RestAssured.given().when().param("id", 43900).get("/products").then().log().all().statusCode(200);
	}
	
	@Test
	public void verifyGetProductWithLimit() {
		RestAssured.given().when().queryParam("$limit", 5).get("/products").then().log().all().statusCode(200);
	}
	
	@Test
	public void verifyPostProduct() {
		String payload = "{\n"
				+ "  \"name\": \"TestProduct\",\n"
				+ "  \"type\": \"string\",\n"
				+ "  \"price\": 0,\n"
				+ "  \"shipping\": 0,\n"
				+ "  \"upc\": \"string\",\n"
				+ "  \"description\": \"string\",\n"
				+ "  \"manufacturer\": \"string\",\n"
				+ "  \"model\": \"string\",\n"
				+ "  \"url\": \"string\",\n"
				+ "  \"image\": \"string\"\n"
				+ "}";
		RestAssured.given().contentType(ContentType.JSON)
		.body(payload)
		.when().post("/products")
		.then().statusCode(201).log().all();
		
	}
	
	@Test
	public void verifyPostProductAsObject() {
		Map<String, Object> payload = new HashMap<>();
		payload.put("name", "iphone");
		payload.put("type", "iphone");
		payload.put("upc", "iphone");
		payload.put("price", 300);
		payload.put("shipping", 30);
		payload.put("description", "iphone");
		payload.put("model", "iphone");
		payload.put("manufacturer", "iphone");
		payload.put("url", "iphone");
		payload.put("image", "iphone");
		
		RestAssured.given().contentType(ContentType.JSON)
		.body(payload)
		.when().post("/products")
		.then().statusCode(201).log().all();
		
	}
	
	@Test
	public void verifyPatchProduct() {
		Map<String, Object> payload = new HashMap<>();
		payload.put("name", "iphone");
		payload.put("type", "iphone");
		payload.put("upc", "iphone");
		payload.put("price", 300);
		payload.put("shipping", 30);
		payload.put("description", "iphone");
		payload.put("model", "iphone");
		payload.put("manufacturer", "iphone");
		payload.put("url", "iphone");
		payload.put("image", "iphone");
		
		int productId = RestAssured.given().contentType(ContentType.JSON)
		.body(payload)
		.when().post("/products")
		.then().extract().path("id");
		
		payload.put("name", "iphone 13");
		
		RestAssured.given().contentType(ContentType.JSON).body(payload)
		.when().put("/products/" + productId).then()
		.statusCode(200).log().all();
	}
	
	@Test
	public void verifyDeleteProduct() {
		Map<String, Object> payload = new HashMap<>();
		payload.put("name", "iphone");
		payload.put("type", "iphone");
		payload.put("upc", "iphone");
		payload.put("price", 300);
		payload.put("shipping", 30);
		payload.put("description", "iphone");
		payload.put("model", "iphone");
		payload.put("manufacturer", "iphone");
		payload.put("url", "iphone");
		payload.put("image", "iphone");
		
		int productId = RestAssured.given().contentType(ContentType.JSON)
		.body(payload)
		.when().post("/products")
		.then().extract().path("id");
		
		RestAssured.given().when().delete("/products/" + productId).then()
		.statusCode(200).log().all();
		
		RestAssured.given().when().get("/products/" + productId).then().statusCode(404);
	}
}
