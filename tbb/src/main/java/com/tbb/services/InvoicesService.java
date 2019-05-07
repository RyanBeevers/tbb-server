package com.example.demo.Services;

import java.util.List;

import com.example.demo.Repos.InvoicesRepo;
import com.example.demo.models.Invoices;
import com.example.demo.models.Users;
import org.springframework.stereotype.Service;

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

    public Invoices getInvoicesByInvoiceId(Integer invoiceId) {
        return repo.findInvoicesByInvoiceId(invoiceId);
    }

    public Invoices createInvoice(Invoices invoice){
        return repo.save(invoice);
    }

    public Invoices updateInvoice(Invoices invoice){
        return repo.save(invoice);
    }


}
