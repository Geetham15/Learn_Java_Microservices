package com.rest.webservices.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	//Path Parameters
	// /users/{id}/todos/{id} => /users/1/todos/101// 
	// /hello-world/path-variable/{name}
	@GetMapping(path = "/hello-world/path-variable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
		//return new HelloWorldBean("Hello World " + name);
		return new HelloWorldBean(String.format("Hello World, %s", name));
	}
	
	//Run by command
	//http://localhost:8080/hello-world/path-variable/geetha
	//Output: {"message": "Hello World, geetha"
}
