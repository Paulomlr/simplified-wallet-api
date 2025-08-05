package com.paulo.simplified_wallet.repositories;

import com.paulo.simplified_wallet.entities.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<Wallet, Long> {
}
