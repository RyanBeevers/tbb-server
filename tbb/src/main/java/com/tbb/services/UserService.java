package com.tbb.services;

import java.util.List;
import com.tbb.models.ChallengeQuestions;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tbb.models.Users;
import com.tbb.repos.UserRepo;

@Service
public class UserService {

	private UserRepo repo;
	
	@Autowired
	public UserService(UserRepo userRepo) {
		this.repo = userRepo;
	}
	
	public List<Users> getUsers() {
		return repo.findAll();
	}
	
	public Users findUserByEmail (String email) {
		return repo.findUserByEmail(email);
	}
	
	@Transactional
	public Users addUser(Users newUser) {
		return repo.save(newUser);
	}
	@Transactional
	public Users updateUser(Users user) {
		return repo.save(user);
	}
	
	public List<Users> getAdmins() {
		return repo.findUsersByAdminTrue();
	}
	
	public Users getMyAdmin(String passphrase) {
		return repo.findUsersByMyAdminPassphrase(passphrase);
	}
	
	public List<Users> getMyUsers(String passphrase) {
		return repo.findUsersByAdminPassphrase(passphrase);
	}
}
