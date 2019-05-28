package com.tbb.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tbb.models.Services;

	@Repository
	public interface ServiceRepo extends JpaRepository <Services, Integer>{

		List<Services> getServicesByAdminId(String adminId);
	
		List<Services> deleteServicesByServiceId(Integer serviceId);
}
