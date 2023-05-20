package com.apitest.base;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

import com.apitest.utilities.ExtentreportListeners;

import io.restassured.RestAssured;

@Listeners(ExtentreportListeners.class)
public class Base {
	@BeforeClass
	public void setBaseURI() {
		RestAssured.baseURI="http://localhost:3000";
	}

}
