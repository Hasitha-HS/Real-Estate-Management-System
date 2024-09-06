package com.dea.PropertySphere.Repository;

import com.dea.PropertySphere.Model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITransactionRepository extends JpaRepository<Transaction, Long> {

}
