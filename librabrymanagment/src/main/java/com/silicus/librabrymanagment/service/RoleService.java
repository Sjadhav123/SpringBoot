package com.silicus.librabrymanagment.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.silicus.librabrymanagment.Dao.RoleRepository;
import com.silicus.librabrymanagment.entity.Role;

@Service
public class RoleService {

	@Autowired
	private RoleRepository roleRepository;
	
	public void saveRole(Role role)
	{
		roleRepository.save(role);
		
	}
	
	public List<Role> list()
	{
		return roleRepository.findAll();
	}
	
	public void delete(long id)
	{
		roleRepository.deleteById(id);
		
	}
	
	/*
	 * public Role updateRoleName(Role role, String roleName) {
	 * 
	 * List<Role> roleList= list();
	 * 
	 * Optional<Role> matchingObject = roleList.stream(). filter(p ->
	 * p.getRoleName().equals(roleName)). findFirst();
	 * 
	 * 
	 * if(matchingObject.isPresent()) { Role oldRole = matchingObject.get();
	 * 
	 * oldRole.setRoleName(roleName); roleRepository.save(oldRole); return oldRole;
	 * } else { role= roleRepository.save(role); return role; } }
	 */
	
	public Role getUserRole(long id) throws Exception
	{
		Optional<Role> role= roleRepository.findById(id);
		
		if(role.isPresent())
		{
			return role.get();
		}
		else
		{
			throw new Exception("User Role Not Found");
			
		}
	}
	
	public Role updateRole(Role role, long id)
	{
		Optional<Role> existingRole= roleRepository.findById(id);
		
		
		if(existingRole.isPresent())
		{
			Role oldRole= existingRole.get();
			
			oldRole.setRoleName(role.getRoleName());
			roleRepository.save(oldRole);
			return oldRole;
		}
		else
		{
			role= roleRepository.save(role);
			return role;
			
		}
		
		
		
	}
	
	
}
