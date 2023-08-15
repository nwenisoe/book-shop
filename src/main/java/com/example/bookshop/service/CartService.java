package com.example.bookshop.service;

import com.example.bookshop.ds.CardItem;
import com.example.bookshop.entity.Book;
import jakarta.persistence.GeneratedValue;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CartService
{
    private final CartBean cartBean;
    public int cartSize() {
        return cartBean.getCardItems().size();
    }
    public Set<CardItem> listCartItems() {
        return cartBean.getCardItems();
    }
    public void deleteById(int id){
        cartBean.getCardItems().removeIf(
                c -> c.getId() == id
        );
    }
   /* public void addToCartItemQty(List<Integer> list) {
       int i = 0;
       for (CardItem cardItem : cartBean.getCardItems()) {
           cardItem.getQuantityList().add(list.get(i));
           i++;
       }
    }*/
    public void setValueRedener(boolean value) {
        cartBean.setCardItems(
                cartBean.getCardItems()
                        .stream().map(c -> {
                            c.setRenderer(value);
                            return c;
                        }).collect(Collectors.toSet())
        );
    }
    public void clearCart() {
        cartBean.getCardItems().clear();
    }

    public void addToCart(Book book) {

        this.cartBean.addCartItems(
                CardItem.builder()
                        .id(book.getId())
                        .title(book.getTitle())
                        .author(book.getAuthor())
                        .price(book.getPrice())
                        .build()
        );

    }

}
