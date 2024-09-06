package com.dea.PropertySphere.Service.Implementation;

import com.dea.PropertySphere.Mapper.TransactionMapper;
import com.dea.PropertySphere.Model.Transaction;
import com.dea.PropertySphere.dto.TransactionDto;
import com.dea.PropertySphere.exception.ResourceNotFoundException;
import com.dea.PropertySphere.Repository.ITransactionRepository;
import com.dea.PropertySphere.Service.ITransactionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
@AllArgsConstructor
public class TransactionService implements ITransactionService {

    private ITransactionRepository transactionRepository;
    @Override
    public TransactionDto createTransaction(TransactionDto transactionDto) {
        Transaction transaction = TransactionMapper.mapToTransaction(transactionDto);
        Transaction savedTransaction = transactionRepository.save(transaction);
        return TransactionMapper.mapToTransactionDto(savedTransaction);
    }

    @Override
    public TransactionDto getTransactionById(Long transactionId) {
        Transaction transaction = transactionRepository.findById(transactionId)
                .orElseThrow(()->
                        new ResourceNotFoundException("Transaction not exist with the given Id:  "+transactionId));
        return  TransactionMapper.mapToTransactionDto(transaction);
    }

    @Override
    public List<TransactionDto> getAllTransactions() {
        List<Transaction> transactions = transactionRepository.findAll();
        return transactions.stream().map((transaction) -> TransactionMapper.mapToTransactionDto(transaction))
                .collect(Collectors.toList());
    }
//comments
    @Override
    public TransactionDto updateTransaction(Long transactionId, TransactionDto updatedTransaction) {
        Transaction transaction = transactionRepository.findById(transactionId).orElseThrow(
                ()-> new ResourceNotFoundException("Transaction not exist with the given id: "+transactionId)
        );

        transaction.setTenantId(updatedTransaction.getTenantId());
        transaction.setAmount(updatedTransaction.getAmount());
        transaction.setTransactionType(updatedTransaction.getTransactionType());
        transaction.setTransactionDate(updatedTransaction.getTransactionDate());
        transaction.setDescription(updatedTransaction.getDescription());


        Transaction updatedTransactionObj = transactionRepository.save(transaction);

        return TransactionMapper.mapToTransactionDto(updatedTransactionObj);
    }

    @Override
    public void deleteTransaction(Long transactionId) {
        Transaction transaction = transactionRepository.findById(transactionId).orElseThrow(
                ()-> new ResourceNotFoundException("Tenant not exist with the given id: "+transactionId)
        );

        transactionRepository.deleteById(transactionId);
    }
}
