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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tbb.models.Invoices;
import com.tbb.models.Users;
import com.tbb.services.InvoicesService;

@Controller
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/invoices")
public class InvoicesController {

    public InvoicesService service;

    @Autowired
    public InvoicesController (InvoicesService invoicesService) {
        this.service = invoicesService;
    }

    @GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Invoices>> getInvoices(){
        List<Invoices> invoices = service.getInvoices();
        if (invoices == null) {
            return new ResponseEntity<>(invoices, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Invoices>>(invoices, HttpStatus.OK);
    }

    @PostMapping(path="/getByUser", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Invoices>> getInvoicesByUser(@RequestBody Users user){
        List<Invoices> invoices = service.getInvoicesByUser(user);
        if (invoices == null) {
            return new ResponseEntity<List<Invoices>>(invoices, HttpStatus.ALREADY_REPORTED);
        }
        return new ResponseEntity<List<Invoices>>(invoices, HttpStatus.OK);
    }
    
    @PostMapping(path="/getByAdminId", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Invoices>> getInvoicesByUser(@RequestBody String adminId){
        List<Invoices> invoices = service.getInvoicesByAdminId(adminId);
        if (invoices == null) {
            return new ResponseEntity<List<Invoices>>(invoices, HttpStatus.ALREADY_REPORTED);
        }
        return new ResponseEntity<List<Invoices>>(invoices, HttpStatus.OK);
    }

    @PostMapping(path="/getByInvoiceId", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Invoices> getInvoicesByInvoiceId(@RequestBody Invoices invoice){
        Integer invoiceId = invoice.getInvoiceId();
        Invoices retrievedInvoice = service.getInvoicesByInvoiceId(invoiceId);
        if (retrievedInvoice == null) {
            return new ResponseEntity<Invoices>(retrievedInvoice, HttpStatus.ALREADY_REPORTED);
        }
        return new ResponseEntity<Invoices>(retrievedInvoice, HttpStatus.OK);
    }

    @PostMapping(path="/newInvoice", consumes= MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Invoices> createTask(@RequestBody Invoices invoice) {
        Invoices newInvoice = service.createInvoice(invoice);
        if (newInvoice == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Invoices>(newInvoice, HttpStatus.OK);
    }

    @PostMapping(path="/updateInvoice", consumes= MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Invoices> updateInvoice(@RequestBody Invoices invoice) {
        Invoices updatedInvoice = service.updateInvoice(invoice);
        if (updatedInvoice == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(updatedInvoice, HttpStatus.OK);
    }
}
