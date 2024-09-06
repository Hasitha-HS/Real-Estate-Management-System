package com.dea.PropertySphere.Mapper;

import com.dea.PropertySphere.Model.Transaction;
import com.dea.PropertySphere.dto.TransactionDto;

public class TransactionMapper {
    public static TransactionDto mapToTransactionDto(Transaction transaction){
        return  new TransactionDto(
                transaction.getId(),
                transaction.getTenantId(),
                transaction.getAmount(),
                transaction.getTransactionType(),
                transaction.getTransactionDate(),
                transaction.getDescription()
        );
    }
    public  static Transaction mapToTransaction(TransactionDto transactionDto){
        return new Transaction(
                transactionDto.getId(),
                transactionDto.getTenantId(),
                transactionDto.getAmount(),
                transactionDto.getTransactionType(),
                transactionDto.getTransactionDate(),
                transactionDto.getDescription()
        );
    }
}
