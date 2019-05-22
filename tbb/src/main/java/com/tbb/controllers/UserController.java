package com.tbb.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tbb.models.Users;
import com.tbb.services.UserService;
import com.tbb.models.ChallengeQuestions;

@CrossOrigin("*")
@RestController
@RequestMapping("/customer")
public class UserController {

	private UserService service;
	
	@Autowired
	public UserController (UserService userService) {
		this.service = userService;
	}
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Users>> getUsers(){
		List<Users> users = service.getUsers();
		if (users == null) {
			return new ResponseEntity<>(users, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Users>>(users, HttpStatus.OK);
	}
	
//	@PostMapping(path="/login", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<Users> login(@RequestBody Users newUser){
//		Users user = service.findUserByEmail(newUser.getEmail());
//		if (user == null) {
//			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
//		}
//		String password = newUser.getPassword();
//		String password1 = user.getPassword();
//		System.out.println();
//		if(!password.equals(password1)) {
//			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
//		}
//		return new ResponseEntity<>(user, HttpStatus.OK);
//	}
	
//	@PostMapping(path="/checkEmail", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<Users> getEmail(@RequestBody Users newUser){
//		Users user = service.findUserByEmail(newUser.getEmail());
//		if (user == null) {
//			return new ResponseEntity<>(HttpStatus.OK);
//		}
//		return new ResponseEntity<>(user, HttpStatus.ALREADY_REPORTED);
//	}
	
	@PostMapping(path="/getUserByEmail", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Users> getUserByEmail(@RequestBody Users newUser){
		System.out.println(newUser);
		Users user = service.findUserByEmail(newUser.getEmail());
		if (user == null) {
			return new ResponseEntity<>(user, HttpStatus.ALREADY_REPORTED);
		}
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	@PostMapping(path="/register", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Users> addUser( @RequestBody Users newUser){
//		newUser.setAlreadyTexted(false);
		Users user = service.addUser(newUser);
		if (user == null) {
			return new ResponseEntity<>(user, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(user, HttpStatus.CREATED);
	}
	
	@PostMapping(path="/update", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Users> updateUser( @RequestBody Users newUser){
//		if(!newUser.getRoleType().equals("admin")) {
//			newUser.setRoleType("user");
//		}
		Users user = service.updateUser(newUser);
		if (user == null) {
			return new ResponseEntity<>(user, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(user, HttpStatus.CREATED);
	}
}
