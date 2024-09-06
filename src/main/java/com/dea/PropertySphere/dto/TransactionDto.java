package com.dea.PropertySphere.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDto {

    private Long id;
    private Long tenantId;
    private Double amount;
    private String transactionType;
    private LocalDateTime transactionDate;
    private String description;
}
