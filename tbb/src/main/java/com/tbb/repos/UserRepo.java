package com.tbb.repos;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tbb.models.Users;

@Repository
public interface UserRepo extends JpaRepository <Users, Integer>{
	
	Users findUserByEmail(String email);
	
}
