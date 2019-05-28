package com.tbb.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tbb.models.Services;
import com.tbb.services.ServiceService;

@Controller
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/services")
public class ServiceController {
	
	private ServiceService service;
	
	@Autowired
	public ServiceController (ServiceService serviceService) {
		this.service = serviceService;
	}
//	
//	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<List<Services>> getServices(){
//		List<Services> services = service.getServices();
//		if (services == null) {
//			return new ResponseEntity<>(services, HttpStatus.NO_CONTENT);
//		}
//		return new ResponseEntity<List<Services>>(services, HttpStatus.OK);
//	}
//	
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Services>> getServices( @RequestBody String adminId){
		System.out.println(adminId);
		List<Services> services = service.getServicesByAdminId(adminId);
		if (services == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<List<Services>>(services, HttpStatus.OK);
	}
	
	@PostMapping(path="/newService", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Services> addService( @RequestBody Services newService){
		System.out.println(newService);
		Services newServices = service.addService(newService);
		if (newServices == null) {
			return new ResponseEntity<>(newServices, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(newServices, HttpStatus.CREATED);
	}
	
	@PutMapping(path="/deleteService", consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> removeService(@RequestBody Services deleteService){
		Integer id = deleteService.getServiceId();
		List<Services> services = service.removeService(id);
		if (services == null) {
			return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
		}
		else{
			return new ResponseEntity<>(true, HttpStatus.OK);
		}
	}
	
	@PostMapping(path="/update", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Services> updateUser( @RequestBody Services updateService){
		Services updatedService = service.updateService(updateService);
		if (updatedService == null) {
			return new ResponseEntity<>(updatedService, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(updatedService, HttpStatus.CREATED);
	}
}
