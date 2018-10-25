package com.verizon.idb.service;

import java.util.List;

import com.verizon.idb.model.User;

public interface UserService {
	User getUsertById(int customerId);
	List<User> getAllUsers();
	User addUser(User user);
	User update(User user);
	boolean deleteUser(int customerId);
}
