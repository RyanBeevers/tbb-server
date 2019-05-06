package com.tbb.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.tbb.models.Services;
import com.tbb.repos.ServiceRepo;

@Service
public class ServiceService {

	private ServiceRepo repo;
	
	public ServiceService(ServiceRepo serviceRepo) {
		this.repo = serviceRepo;
	}
	
	public List<Services> getServices(){
		return repo.findAll();
	}
	
	@Transactional
	public Services addService(Services newService) {
		return repo.save(newService);
	}
	
	@Transactional
	public List<Services> removeService(Integer id) {
		return repo.deleteServicesByServiceId(id);
	}
	
	@Transactional
	public Services updateService(Services service) {
		return repo.save(service);
	}

}
