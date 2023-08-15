package com.example.bookshop.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter

@NoArgsConstructor
public class BookItem {
    @Id
    private int id;
    private String title;
    private String author;
    private Double  price;
    private int quantity;

    private double sum;

    public BookItem(int id, String title, String author, Double price, int quantity, double sum) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
        this.quantity = quantity;
        this.sum = sum;
    }

    @ManyToOne
private Customer customer;
}
