package com.example.bookshop.ds;

import lombok.*;

import java.util.LinkedList;
import java.util.List;


@Data
@Builder

public class CardItem {
    private int id;
    private String title;
    private String author;
    private Double  price;
    private int quantity=1;
    private boolean renderer;
    private double sum;
//    private List<Integer> quantityList =
//            new LinkedList<>();


}
