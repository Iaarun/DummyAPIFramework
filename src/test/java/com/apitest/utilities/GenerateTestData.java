package com.apitest.utilities;

import com.github.javafaker.Faker;

public class GenerateTestData {
	Faker faker = new Faker();
	public  String firstname;
	public String lastname;
	public String email;
	
	public String generatefirstname() {
		firstname= faker.name().firstName();
		return firstname;
	}
	
	public String generatelastName() {
		lastname= faker.name().lastName();
		return lastname;
	}
	
	public String generateemail() {
		email= firstname + "." + lastname + "@test.com";
		return email;
	}
}
