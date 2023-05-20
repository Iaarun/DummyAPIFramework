package com.apitest.tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.apitest.base.Base;
import com.apitest.endpoint.APIEndpoints;
import com.apitest.pojo.Employees;
import com.apitest.utilities.GenerateTestData;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ApiTests extends Base {
	
	GenerateTestData generateTestData = new GenerateTestData();
	public Integer id;
	
	
	@Test (priority = 0)
	public void test_getallemployees() {
		
	Response response=	given()
		.when()
		.get(APIEndpoints.LIST_ALL_EMPLOYEE)
		.then()
		.statusCode(200)
		.log()
		.all()
		.extract()
		.response();
	
	JsonPath jp = response.jsonPath();
		
	String username= jp.get("[0].first_name");
	Assert.assertEquals("user2", username);;
		
	}
	
	
	@Test(priority = 1)
	public void test_CreateEmployee() {
		
		
		Employees emp = new Employees();
		emp.setFirstName(generateTestData.generatefirstname());
		emp.setLastName(generateTestData.generatelastName());
		emp.setEmail(generateTestData.generateemail());
		
	Employees empresponse=	given()
		.contentType(ContentType.JSON)
		.body(emp)
		.when()
		.post(APIEndpoints.CREATE_EMPLOYEE)
		.then()
		.statusCode(201)
		.log()
		.all()
		.extract()
		.as(Employees.class);
	
	id= empresponse.getId();
	assertThat(empresponse.getFirstName(), equalTo(generateTestData.firstname));
	System.out.println("ID>>>>>"+id);
	}
	
	@Test(priority = 2)
	public void test_deleteemployee() {
		
		given()
		.when()
		.delete(APIEndpoints.DELETE_EMPLOYEE+id)
		.then()
		.statusCode(200);
		
	}
	
	@Test(priority = 3)
public void test_getemployee() {
		
		given()
		.when()
		.get(APIEndpoints.GET_EMPLOYEE+id)
		.then()
		.statusCode(404);
		
	}


}
