package com.example.vikhlia.service;

import com.example.vikhlia.dao.TransactionRepository;
import com.example.vikhlia.entity.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService{

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    @Override
    public void saveTransaction(Transaction transaction) {
        transactionRepository.save(transaction);
    }

    @Override
    public Transaction getTransaction(long id) {
        Transaction transaction = null;
        Optional<Transaction> optional = transactionRepository.findById(id);
        if(optional.isPresent())
            transaction=optional.get();

        return transaction;
    }

    @Override
    public void deleteTransaction(long id) {
        transactionRepository.deleteById(id);
    }
}
