package com.verizon.idb.restApi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.verizon.idb.model.User;
import com.verizon.idb.service.UserService;

@RestController
@CrossOrigin
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public ResponseEntity<List<User>> getAllUsers() {
		return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<User> addUser(@RequestBody User user) {
		ResponseEntity<User> resp = null;
		
		User u = userService.addUser(user);
			if (u == null)
				resp = new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
			else
				resp = new ResponseEntity<User>(u, HttpStatus.OK);
		return resp;
	}
}
