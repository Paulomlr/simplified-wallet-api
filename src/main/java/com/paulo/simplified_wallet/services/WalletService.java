package com.paulo.simplified_wallet.services;

import com.paulo.simplified_wallet.entities.Wallet;
import com.paulo.simplified_wallet.repositories.WalletRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WalletService {
    private final WalletRepository walletRepository;

    public void save(Wallet wallet) {
        walletRepository.save(wallet);
    }
}