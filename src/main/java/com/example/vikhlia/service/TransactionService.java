package com.example.vikhlia.service;

import com.example.vikhlia.entity.Transaction;

import java.util.List;

public interface TransactionService {
    public List<Transaction> getAllTransactions();

    public void saveTransaction(Transaction transaction);

    public Transaction getTransaction(long id);

    public void deleteTransaction(long id);
}
