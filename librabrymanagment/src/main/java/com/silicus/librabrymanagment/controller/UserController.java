package com.silicus.librabrymanagment.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.silicus.librabrymanagment.entity.User;
import com.silicus.librabrymanagment.service.UserService;

@RestController
@RequestMapping("/userController")
public class UserController {
	
	  @Autowired 
	  private UserService userService;
	  
	  
	  @RequestMapping(value="/createUser",method=RequestMethod.POST)
	  public void save(@RequestBody User user)
	  { userService.saveUser(user); }
	  
	  
	  @RequestMapping(value="/getAllUsers",method=RequestMethod.GET) 
	  public List<User> getAllUser()
	  {
		  return userService.list();
		  
	  }
	  
	
	  @RequestMapping(value="/getUser/{id}",method=RequestMethod.GET) 
	  public ResponseEntity<User> getUserById(@PathVariable("id") long id) throws Exception
	  { 
		  User user = userService.getUser(id);
		  
		  return new ResponseEntity<User>(user, new HttpHeaders(), HttpStatus.OK); 
		
	  }
	  
	  @RequestMapping(value="/deleteUser/{id}",method=RequestMethod.DELETE)
	  public void deleteUser(@PathVariable("id") long id)
	  {
		  userService.delete(id);
	  }
	  
	  @RequestMapping(value="/updateUser/{id}",method=RequestMethod.PUT) 
	  public Object updateUser(@PathVariable("id") long id, @RequestBody User user)
	  {
		  User updateUser = userService.updateUser(id, user);
			return new ResponseEntity<User>(updateUser, new HttpHeaders(), HttpStatus.OK);
	  }
	  
	  
	  
}
