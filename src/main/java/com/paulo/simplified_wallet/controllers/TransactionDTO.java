package com.paulo.simplified_wallet.controllers;

import java.math.BigDecimal;

public record TransactionDTO(BigDecimal value, Long payer, Long payee) {
}
