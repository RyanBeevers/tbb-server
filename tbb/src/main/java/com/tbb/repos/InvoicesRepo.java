package com.example.demo.Repos;

import java.util.List;

import com.example.demo.models.Invoices;
import com.example.demo.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoicesRepo extends JpaRepository <Invoices, Integer>{

    List<Invoices> findAllByUser(Users user);

    Invoices findInvoicesByInvoiceId(Integer invoiceId);

}
