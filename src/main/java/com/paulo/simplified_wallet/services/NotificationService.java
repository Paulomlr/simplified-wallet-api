package com.paulo.simplified_wallet.services;

import com.paulo.simplified_wallet.controllers.ClientNotification;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final ClientNotification client;

    public void sendNotification() {
        client.sendNotification();
    }
}