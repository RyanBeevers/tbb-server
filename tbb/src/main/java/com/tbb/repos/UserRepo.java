package com.tbb.repos;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tbb.models.Users;

@Repository
public interface UserRepo extends JpaRepository <Users, Integer>{
	
	Users findUserByEmail(String email);
	
	List<Users>findUsersByAdminTrue();
	
	Users findUsersByMyAdminPassphrase(String passphrase);
	
	List<Users>findUsersByAdminPassphrase(String passphrase);
}
