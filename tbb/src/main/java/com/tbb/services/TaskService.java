package com.tbb.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tbb.models.Invoices;
import com.tbb.models.Tasks;
import com.tbb.models.Users;
import com.tbb.repos.TaskRepo;

@Service
public class TaskService {

    private TaskRepo repo;

    @Autowired
    public TaskService (TaskRepo taskRepo){
        this.repo=taskRepo;
    }

    public List<Tasks> getTasks(){
        return repo.findAll();
    }

    public List<Tasks> findAllByUser (Users user){
        return repo.findAllByUser(user);
    }

    public List<Tasks> findAllByUserAndInvoicesIsNull(Users user){
        return repo.findAllByUserAndInvoicesIsNull(user);
    }

    public List<Tasks> findAllByInvoice(Invoices invoice){
        return repo.findAllByInvoices(invoice);
    }

    public Tasks createTask(Tasks task){
        return repo.save(task);
    }

    public Tasks updateTask(Tasks task){
        return repo.save(task);
    }
    
	@Transactional
	public List<Tasks> removeTask(Integer id) {
		return repo.deleteTasksByTaskId(id);
	}
	
    public List<Tasks> findAllByAdminId(String adminId){
        return repo.findAllByAdminId(adminId);
    }

}
