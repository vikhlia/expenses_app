package com.example.vikhlia.utils;

import com.example.vikhlia.entity.Type;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class ViewTransaction {
    @Id
    private int id;
    private long amount;
    private String date;
    private Type type;
    private String category;

}
