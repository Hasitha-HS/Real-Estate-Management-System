package com.dea.PropertySphere.Service;

import com.dea.PropertySphere.dto.TransactionDto;

import java.util.List;

public interface ITransactionService {
    TransactionDto createTransaction (TransactionDto transactionDto);
    TransactionDto getTransactionById(Long transactionId);
    List<TransactionDto> getAllTransactions();
    TransactionDto updateTransaction(Long transactionId, TransactionDto updatedTransaction);
    void deleteTransaction(Long transactionId);
}
