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

import com.silicus.librabrymanagment.entity.Role;
import com.silicus.librabrymanagment.service.RoleService;


@RestController
@RequestMapping("/roleController")
public class RoleController {

	@Autowired
	private RoleService roleService;
	
	
	@RequestMapping(value="/createRole", method= RequestMethod.POST)
	public void createRole(@RequestBody Role role)
	{
		roleService.saveRole(role);
	}
	
	@RequestMapping(value="/deleteRole/{id}", method=RequestMethod.DELETE)
	public void deleteRole(@PathVariable("id") long id)
	{
		roleService.delete(id);
	}
	
	
	 @RequestMapping(value="/getAllRoles",method=RequestMethod.GET) 
	  public List<Role> getAllRoles()
	  { return roleService.list(); }
	 
	 @RequestMapping(value="/getRole/{roleId}", method= RequestMethod.GET)
	 public ResponseEntity<Role> getUserRole(@PathVariable("roleId") long id) throws Exception
	 {
		Role role=roleService.getUserRole(id);
		
		 
		 return new ResponseEntity<Role>(role, new HttpHeaders(),HttpStatus.OK);	 
	 }
	 
	 @RequestMapping(value="/updateRole/{id}", method=RequestMethod.PUT)
	 public Object updateRole(@PathVariable("id") long id, @RequestBody Role role)
	 {
		 Role oldRole= roleService.updateRole(role, id);
		 return new ResponseEntity<Role>(role,new HttpHeaders(), HttpStatus.OK);
	 }
	 
}
