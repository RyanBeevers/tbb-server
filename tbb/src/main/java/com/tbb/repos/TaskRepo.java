package com.tbb.repos;

import com.tbb.models.Invoices;
import com.tbb.models.Tasks;
import com.tbb.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepo extends JpaRepository <Tasks, Integer> {

    List<Tasks> findAllByUser(Users user);

    List<Tasks> findAllByUserAndInvoicesIsNull(Users user);

    List<Tasks> findAllByInvoices(Invoices invoice);

}
