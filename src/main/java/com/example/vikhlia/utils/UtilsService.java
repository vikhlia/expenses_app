package com.example.vikhlia.utils;

import com.example.vikhlia.entity.Category;
import com.example.vikhlia.entity.Transaction;
import com.example.vikhlia.entity.Type;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Service
public class UtilsService {

    public List<String> getCategoriesNames(List<Category> categoryList) {
        List<String> stringList = new ArrayList<>();
        String name;
        for (Category category : categoryList) {
            name = category.getName();
            stringList.add(name);
        }
        return stringList;
    }

    public int getAllExpenses(List<Transaction> transactionList) {
        int expenses = 0;
        for (Transaction transaction : transactionList) {
            if (isExpense(transaction))
                expenses += transaction.getAmount();
        }
        return expenses;
    }

    public int getAllIncomes(List<Transaction> transactionList) {
        int incomes = 0;
        for (Transaction transaction : transactionList) {
            if (!isExpense(transaction))
                incomes += transaction.getAmount();
        }
        return incomes;
    }

    private boolean isExpense(Transaction transaction) {
        return (transaction.getType().equals("Expense"));
    }

    public Transaction transformToTransaction(ViewTransaction viewTransaction) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String transactionTime = simpleDateFormat.format(date);
        Transaction transaction = new Transaction();
        transaction.setId(viewTransaction.getId());
        transaction.setAmount(viewTransaction.getAmount());
        transaction.setDate(transactionTime);
        transaction.setType(setTypeTransaction(viewTransaction.getType()));

        return transaction;
    }

    public int getCategoryId(String name, List<Category> categoriesList) {
        int id = 0;
        for (Category category : categoriesList) {
            if (category.getName().equals(name))
                id = category.getId();
        }
        return id;

    }

    public String setTypeTransaction(Type type) {
        String stringType;
        if (type.equals(Type.EXPENSE)) {
            stringType = "Expense";
        } else if (type.equals(Type.INCOME)) {
            stringType = "INCOME";
        } else {
            throw new NullPointerException("Field Type is null");
        }
        return stringType;
    }

    public boolean checkCatergoryIsExist(String name, List<String> namesList) {
        return namesList.contains(name);
    }
}
