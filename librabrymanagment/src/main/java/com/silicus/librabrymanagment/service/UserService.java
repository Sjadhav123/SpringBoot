package com.silicus.librabrymanagment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.silicus.librabrymanagment.Dao.UserRepository;
import com.silicus.librabrymanagment.entity.User;

@Service
public class UserService {

	
	  @Autowired private UserRepository userRepository;
	  
	  
	 public void saveUser(User user) {
		 userRepository.save(user);
	  
	  }
	 
	 /*
	  public void deleteUser(long id) { userRepository.deleteById(id);
	  
	  }
	  
	  public User updateUser(User user) { userRepository.save(user);
	  
	  return user; }*/
	 
		
}
