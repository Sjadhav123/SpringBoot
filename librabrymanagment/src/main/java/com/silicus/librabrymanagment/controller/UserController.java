package com.silicus.librabrymanagment.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.silicus.librabrymanagment.entity.User;
import com.silicus.librabrymanagment.service.UserService;

@RestController
@RequestMapping("/userController")
public class UserController {
	
	  @Autowired private UserService userService;
	  
	  
	  @RequestMapping(value="/createUser",method=RequestMethod.POST) public void
	  save(@RequestBody User user) { userService.saveUser(user); }
	  
	  
	  
	/*
	 * @RequestMapping(value="/getUser/{id}",method=RequestMethod.GET) public User
	 * getUser(@PathVariable("id")long id){ return userServicec.get(id); }
	 * 
	 * @RequestMapping(value="/getAllUsers",method=RequestMethod.GET) public
	 * List<User> getAllUser(){ return userServicec.list(); }
	 * 
	 * @RequestMapping(value="/updateUser/{id}",method=RequestMethod.PUT) public
	 * Object updateUser(@PathVariable("id") long id, @RequestBody User user){
	 * return userServicec.update(id,user); }
	 * 
	 * @RequestMapping(value="/deleteUser/{id}",method=RequestMethod.DELETE) public
	 * void deleteUser(@PathVariable("id") long id){ userServicec.delete(id);
	 * 
	 * }
	 */
	 
}
