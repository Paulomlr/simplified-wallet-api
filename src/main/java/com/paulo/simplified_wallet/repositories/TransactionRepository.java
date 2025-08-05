package com.paulo.simplified_wallet.repositories;

import com.paulo.simplified_wallet.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, String> {
}
