package com.example.vikhlia.controller;

import com.example.vikhlia.entity.Category;
import com.example.vikhlia.entity.Transaction;
import com.example.vikhlia.service.CategoryServiceImpl;
import com.example.vikhlia.service.TransactionServiceImpl;
import com.example.vikhlia.utils.UtilsService;
import com.example.vikhlia.utils.ViewTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StartPageController {

    @Autowired
    CategoryServiceImpl categoryServiceIml;

    @Autowired
    TransactionServiceImpl transactionServiceImp;

    @Autowired
    UtilsService utilsService;

    @GetMapping("/main")
    public String mainPage(Model model) {
        UtilsService utilsService = new UtilsService();
        List<String> namesList = utilsService.getCategoriesNames(categoryServiceIml.getAllCategories());
        int allExpenses = utilsService.getAllExpenses(transactionServiceImp.getAllTransactions());
        int allIncomes = utilsService.getAllIncomes(transactionServiceImp.getAllTransactions());

        model.addAttribute("viewTransaction", new ViewTransaction());
        model.addAttribute("category", namesList);
        model.addAttribute("allExpenses", allExpenses);
        model.addAttribute("allIncomes", allIncomes);

        return "main-page";
    }

    @PostMapping("/main")
    public String submit(@ModelAttribute ViewTransaction viewTransaction, Model model) {

        Transaction transaction = utilsService.transformToTransaction(viewTransaction);
        transaction.setCategory(getCategoryId(viewTransaction.getCategory()));

        transactionServiceImp.saveTransaction(transaction);
        return "redirect:/main";
    }

    public int getCategoryId(String categoryName) {

        List<Category> categoryList = categoryServiceIml.getAllCategories();
        List<String> categoryNamesList = utilsService.getCategoriesNames(categoryList);

        if (!utilsService.checkCatergoryIsExist(categoryName, categoryNamesList)) {
            try {
                Category category = new Category();
                category.setName(categoryName);
                categoryServiceIml.saveCategory(category);
                categoryList = categoryServiceIml.getAllCategories();
            } catch (Exception e) {
                System.out.println("Exception in getCategoryID " + e);
                return -1;
            }
        }
        return utilsService.getCategoryId(categoryName, categoryList);
    }
}
