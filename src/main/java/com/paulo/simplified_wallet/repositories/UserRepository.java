package com.paulo.simplified_wallet.repositories;

import com.paulo.simplified_wallet.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{
}
