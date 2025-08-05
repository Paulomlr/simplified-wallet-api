package com.paulo.simplified_wallet.services;

import com.paulo.simplified_wallet.controllers.TransactionDTO;
import com.paulo.simplified_wallet.entities.Transaction;
import com.paulo.simplified_wallet.entities.User;
import com.paulo.simplified_wallet.entities.UserType;
import com.paulo.simplified_wallet.repositories.TransactionRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final UserService userService;
    private final AuthorizationService authorizationService;
    private final WalletService walletService;
    private final TransactionRepository transactionRepository;
    private final NotificationService notificationService;

    @Transactional
    public void transferValues(TransactionDTO transactionDTO) {
        User payer = userService.findUser(transactionDTO.payer());
        User payee = userService.findUser(transactionDTO.payee());

        validateTransaction(payer, transactionDTO.value());

        payer.getWallet().setBalance(payer.getWallet().getBalance().subtract(transactionDTO.value()));
        payee.getWallet().setBalance(payee.getWallet().getBalance().add(transactionDTO.value()));

        walletService.save(payer.getWallet());
        walletService.save(payee.getWallet());

        Transaction transaction = Transaction.builder()
                .value(transactionDTO.value())
                .payer(payer)
                .receiver(payee)
                .build();

        transactionRepository.save(transaction);
        notificationService.sendNotification();
    }

    private void validateTransaction(User payer, BigDecimal value) {
        if (payer.getUserType().equals(UserType.SHOPKEEPER)) {
            throw new IllegalArgumentException("Transaction not authorized for this user type");
        }

        if (payer.getWallet().getBalance().compareTo(value) < 0) {
            throw new IllegalArgumentException("Transaction not authorized, insufficient balance");
        }

        if (!authorizationService.validateTransfer()) {
            throw new IllegalArgumentException("Transaction not authorized by API");
        }
    }
}
