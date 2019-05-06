package com.tbb.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tbb.models.Invoices;
import com.tbb.models.Users;
import com.tbb.repos.InvoicesRepo;

@Service
public class InvoicesService {

	private InvoicesRepo repo;
	
	public InvoicesService(InvoicesRepo invoicesRepo) {
		this.repo = invoicesRepo;
	}
	
	public List<Invoices> getInvoices(){
		return repo.findAll();
	}

	public List<Invoices> getInvoicesByUser(Users user) {
		return repo.findAllByUser(user);
	}
}
