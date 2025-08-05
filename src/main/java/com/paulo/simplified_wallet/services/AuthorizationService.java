package com.paulo.simplified_wallet.services;

import com.paulo.simplified_wallet.controllers.ClientAuthorization;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthorizationService {

    private final ClientAuthorization client;

    public boolean validateTransfer() {
        return client.validateAuthorization().data().authorization();
    }
}