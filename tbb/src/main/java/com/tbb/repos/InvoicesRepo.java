package com.tbb.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tbb.models.Invoices;
import com.tbb.models.Users;

@Repository
public interface InvoicesRepo extends JpaRepository <Invoices, Integer>{

    List<Invoices> findAllByUser(Users user);

    Invoices findInvoicesByInvoiceId(Integer invoiceId);

    List<Invoices> getInvoicesByAdminId (String adminId);
}
