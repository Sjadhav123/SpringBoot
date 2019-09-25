package com.silicus.librabrymanagment.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.silicus.librabrymanagment.Dao.UserRepository;
import com.silicus.librabrymanagment.entity.User;

@Service
public class UserService<U> {

	
	  @Autowired private UserRepository userRepository;
	  
	  
	 public void saveUser(User user) {
		 		 userRepository.save(user);
	  
	  }


	public List<User> list() {
	
		return	userRepository.findAll();
	
	}

	
	public User getUser(long id) throws Exception {
		Optional<User> user = userRepository.findById(id);
		if (user.isPresent()) {
			return user.get();
		} else {

			throw new Exception("User not found");
		}

	}
	
	

	public void delete(long id) {
		
		userRepository.deleteById(id);;
	}


	public User updateUser(long id, User user) {
		Optional<User> existingUser = userRepository.findById(id);
		if (existingUser.isPresent()) {

			User oldUser = existingUser.get();
			
			oldUser.setName(user.getName());
			oldUser.setRoleId(user.getRoleId());
			oldUser.setEmail(user.getEmail());
			oldUser.setPhoneNumber(user.getPhoneNumber());
			userRepository.save(oldUser);
			return oldUser;
			
			
		} else {
			user = userRepository.save(user);
			return user;
		}

	}
		
}
