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

@RestController
@RequestMapping("/customer")
@CrossOrigin
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
	
	@PostMapping(path="/getUserByEmail", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Users> getUserByEmail(@RequestBody Users newUser){
		Users user = service.findUserByEmail(newUser.getEmail());
		if (user == null) {
			return new ResponseEntity<>(user, HttpStatus.ALREADY_REPORTED);
		}
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	@PostMapping(path="/register", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Users> addUser( @RequestBody Users newUser){
		Users user = service.addUser(newUser);
		if (user == null) {
			return new ResponseEntity<>(user, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(user, HttpStatus.CREATED);
	}
	
	@PostMapping(path="/update", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Users> updateUser( @RequestBody Users newUser){
		Users user = service.updateUser(newUser);
		if (user == null) {
			return new ResponseEntity<>(user, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(user, HttpStatus.CREATED);
	}
	
	@PostMapping(path="/verifyAdmin", consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> verifyAdmin( @RequestBody String passphrase){
		System.out.println(passphrase);
		
		if (passphrase.equals("tbb-admin-2019")){
			return new ResponseEntity<>(true, HttpStatus.OK);
		}
		else {
		return new ResponseEntity<>(false, HttpStatus.OK);
		}
	}
	
	@GetMapping(path="/getAdmins", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Users>> getAdmins(){
		List<Users> users = service.getAdmins();
		if (users == null) {
			return new ResponseEntity<>(users, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Users>>(users, HttpStatus.OK);
	}
	
	@PostMapping(path="/getMyAdmin", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Users> getMyAdmin( @RequestBody String passphrase){
		Users user = service.getMyAdmin(passphrase);
		if (user == null) {
			return new ResponseEntity<>(user, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Users>(user, HttpStatus.OK);
	}
	
	@PostMapping(path="/getMyUsers", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Users>> getMyUsers( @RequestBody String passphrase){
		List<Users> users = service.getMyUsers(passphrase);
		if (users == null) {
			return new ResponseEntity<List<Users>>(users, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Users>>(users, HttpStatus.OK);
	}
}
