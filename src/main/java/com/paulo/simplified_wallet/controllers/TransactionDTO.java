package com.paulo.simplified_wallet.controllers;

import java.math.BigDecimal;

public record TransactionDTO(BigDecimal value, String payer, String payee) {
}
