package com.paulo.simplified_wallet.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_transaction")
@Builder
public class  Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;

    private BigDecimal value;

    @JoinColumn(name = "receiver_id")
    @ManyToOne
    private User receiver;

    @JoinColumn(name = "payer_id")
    @ManyToOne
    private User payer;
    private LocalDateTime transactionDateTime;

    @PrePersist
    void prePersist() {
        transactionDateTime = LocalDateTime.now();
    }
}