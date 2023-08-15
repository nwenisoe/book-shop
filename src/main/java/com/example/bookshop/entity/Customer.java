package com.example.bookshop.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity

@Getter
@Setter
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true)
    private String name;
    private String phoneNumber;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;
    @OneToMany(mappedBy = "customer",cascade = CascadeType.PERSIST)
    private Set<BookItem> bookItems =
            new HashSet<>();
    public void  addBook(BookItem bookItem) {
        bookItem.setCustomer(this);
        this.bookItems.add(bookItem);
    }
    /*@OneToMany(mappedBy = "customer")
    private List<Book> books =
            new ArrayList<>();
*/
}
