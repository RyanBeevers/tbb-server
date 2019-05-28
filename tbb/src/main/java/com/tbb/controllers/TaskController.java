package com.tbb.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tbb.models.Invoices;
import com.tbb.models.Tasks;
import com.tbb.models.Users;
import com.tbb.services.TaskService;

@RestController
@RequestMapping("/tasks")
@CrossOrigin("*")
public class TaskController {

    private TaskService service;

    @Autowired
    public TaskController (TaskService taskService){
        this.service = taskService;
    }

    @GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Tasks>> getTasks(){
        List<Tasks> tasks = service.getTasks();
        if (tasks == null) {
            return new ResponseEntity<>(tasks, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Tasks>>(tasks, HttpStatus.OK);
    }
    
    @PostMapping(path="/getTasksByAdminId", consumes= MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Tasks>> getTasksByAdminId(@RequestBody String adminId){
    	System.out.println(adminId);
        List<Tasks> tasks = service.findAllByAdminId(adminId);
        if (tasks == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Tasks>>(tasks, HttpStatus.OK);
    }

    @PostMapping(path="/getTasksByUserId", consumes= MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Tasks>> getTasksByUserId(@RequestBody Users user){
        List<Tasks> tasks = service.findAllByUser(user);
        if (tasks == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Tasks>>(tasks, HttpStatus.OK);
    }

    @PostMapping(path="/getTasksByUserIdAndNoInvoice", consumes= MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Tasks>> getTasksByUserIdAndNoInvoice(@RequestBody Users user){
        List<Tasks> tasks = service.findAllByUserAndInvoicesIsNull(user);
        if (tasks == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Tasks>>(tasks, HttpStatus.OK);
    }

    @PostMapping(path="/getTasksByInvoice", consumes= MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Tasks>> getTasksByInvoice(@RequestBody Invoices invoice){
    	System.out.println(invoice);
        List<Tasks> tasks = service.findAllByInvoice(invoice);
        if (tasks == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        System.out.println(tasks);
        return new ResponseEntity<List<Tasks>>(tasks, HttpStatus.OK);
    }

    @PostMapping(path="/newTask", consumes= MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Tasks> createTask(@RequestBody Tasks task) {
        System.out.println(task);
        Tasks newTask = service.createTask(task);
        if (newTask == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(newTask, HttpStatus.OK);
    }

    @PostMapping(path="/updateTask", consumes= MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Tasks> updateTask(@RequestBody Tasks task) {
        Tasks updatedTask = service.updateTask(task);
        if (updatedTask == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(updatedTask, HttpStatus.OK);
    }
    
	@PutMapping(path="/deleteTask", consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> removeTask(@RequestBody Tasks deleteTask){
		Integer id = deleteTask.getTaskId();
		List<Tasks> tasks = service.removeTask(id);
		if (tasks == null) {
			return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
		}
		else{
			return new ResponseEntity<>(true, HttpStatus.OK);
		}
	}

}
