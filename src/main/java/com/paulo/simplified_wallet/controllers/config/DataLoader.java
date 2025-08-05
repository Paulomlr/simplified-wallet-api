package com.paulo.simplified_wallet.controllers.config;

import com.paulo.simplified_wallet.entities.User;
import com.paulo.simplified_wallet.entities.UserType;
import com.paulo.simplified_wallet.entities.Wallet;
import com.paulo.simplified_wallet.repositories.UserRepository;
import com.paulo.simplified_wallet.repositories.WalletRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.math.BigDecimal;
import java.util.List;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner userLoader(UserRepository userRepository, WalletRepository walletRepository) {
        return args -> {
            if (userRepository.count() == 0) {
                BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

                User user1 = new User(null, "Carlos Silva", "carlos@email.com", "111111111111",
                        encoder.encode("123456"), null, UserType.COMMON);

                User user2 = new User(null, "Ana Souza", "ana@email.com", "22222222222",
                        encoder.encode("123456"), null, UserType.COMMON);

                User shopkeeper = new User(null, "Loja Exemplo", "loja@email.com", "33333333333",
                        encoder.encode("123456"), null, UserType.SHOPKEEPER);

                userRepository.saveAll(List.of(user1, user2, shopkeeper));

                Wallet wallet1 = new Wallet(null, new BigDecimal("1000.00"), user1);
                Wallet wallet2 = new Wallet(null, new BigDecimal("2000.00"), user2);
                Wallet wallet3 = new Wallet(null, new BigDecimal("5000.00"), shopkeeper);

                walletRepository.saveAll(List.of(wallet1, wallet2, wallet3));

                System.out.println("Users and wallets successfully populated!");
            }
        };
    }
}
