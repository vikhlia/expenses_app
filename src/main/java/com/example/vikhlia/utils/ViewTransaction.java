package com.example.vikhlia.utils;

import com.example.vikhlia.entity.Category;
import com.example.vikhlia.entity.Type;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Data
public class ViewTransaction {
    @Id
    private int id;
    private long amount;
    private Date date;
    private Type type;
    private Category category;

}
