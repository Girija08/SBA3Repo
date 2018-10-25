package com.verizon.idb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verizon.idb.dao.UserDAO;
import com.verizon.idb.model.User;

@Service
public class UserServiceImplementation implements UserService {
	
	@Autowired
	public UserDAO userRepo;
	
	@Override
	public User getUsertById(int customerId) {
		User user = null;
		
		Optional<User> optUser = userRepo.findById(customerId);
		if (optUser.isPresent()) {
			user = optUser.get();
		}
		
		return user;
	}

	@Override
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}

	@Override
	public User addUser(User user) {
		return userRepo.save(user);
	}

	@Override
	public User update(User user) {
		return userRepo.save(user);
	}

	@Override
	public boolean deleteUser(int customerId) {
		boolean isDeleted = false;
		
		if(userRepo.existsById(customerId)) {
			userRepo.deleteById(customerId);
			isDeleted = true;
		}
		return isDeleted;
	}

}
