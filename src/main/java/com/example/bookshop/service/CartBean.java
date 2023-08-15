package com.example.bookshop.service;

import com.example.bookshop.ds.CardItem;
import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.HashSet;
import java.util.Set;

@SessionScope
@Component
@Data
public class CartBean {
    private Set<CardItem> cardItems =
            new HashSet<>();
    public void addCartItems(CardItem cardItem) {
        this.getCardItems().add(cardItem);
    }
}
