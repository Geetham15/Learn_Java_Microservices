package com.rest.webservices.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//REST API
@RestController
public class HelloWorldController {
	
	//L1: Create HelloWorld RestAPI
	//@RequestMapping(method = RequestMethod.GET, path = "/hello-world")
	@GetMapping(path="hello-world")
	public String helloWorld() {
		return "Hello World";
	}
	
	//Run by command
    //localhost:8080/hello-world
	
	//L2: Enhance Hello World API to return a Bean

	//Hello World RESTAPI return a Bean
	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World");
	}
	
	//Run by command
	//localhost:8080/hello-world-bean
}
