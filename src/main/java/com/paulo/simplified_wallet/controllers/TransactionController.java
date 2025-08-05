package com.paulo.simplified_wallet.controllers;

import com.paulo.simplified_wallet.services.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/transfer")
public class TransactionController {

    private final TransactionService transactionService;

    @PostMapping
    public ResponseEntity<Void> processTransaction(@RequestBody TransactionDTO transactionDTO) {
        transactionService.transferValues(transactionDTO);
        return ResponseEntity.accepted().build();
    }
}
