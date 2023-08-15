package com.example.bookshop;

import com.example.bookshop.dao.BookDao;
import com.example.bookshop.entity.Book;
import com.example.bookshop.entity.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class BookShopApplication {
    private final BookDao bookDao;
    // public Book(String title, double price, String author,String imageUrl, LocalDate publishedDate, Category category) {
    public static void main(String[] args) {
        SpringApplication.run(BookShopApplication.class, args);
    }

    @Bean @Transactional //@Profile("test")
    public ApplicationRunner runner(){
        return r ->{
            List.of(
                    new Book("England History",35.5,"Macaulay",
                            "https://source.unsplash.com/366x200/?flower",
                            LocalDate.of(1957,3,21),
                            Category.HISTORICAL),
                    new Book("World History",40.5,"H.G Wells",
                            "https://source.unsplash.com/366x200/?fruit",
                            LocalDate.of(1957,3,21),
                            Category.HISTORICAL),
                    new Book("Return of The Native",40.5,"Thomas Hardy",
                            "https://source.unsplash.com/366x200/?sunrise",
                            LocalDate.of(1870,3,21),
                            Category.NOVEL),
                    new Book("Victor Frankenstein",45.5,"Mary Shelly",
                            "https://source.unsplash.com/366x200/?flower",
                            LocalDate.of(1957,3,21),
                            Category.HORROR),
                    new Book("A Tale of Two Cities",50.5,"Charles Dickens",
                            "https://source.unsplash.com/366x200/?ocean",
                            LocalDate.of(1957,3,21),
                            Category.NOVEL),
                    new Book("Emma",45.5,"Charlotte Bronte",
                            "https://source.unsplash.com/366x200/?sunset",
                            LocalDate.of(1957,3,21),
                            Category.ROMANCE),
                    new Book("Wuthering Heights",45.5,"Emily Brontë",
                            "https://source.unsplash.com/366x200/?library",
                            LocalDate.of(1957,3,21),
                            Category.ROMANCE),
                    new Book("A Pale View Of Hill",45.5,"Kazuo Ishiguro",
                            "https://source.unsplash.com/366x200/?library",
                            LocalDate.of(1982,3,21),
                            Category.NOVEL)
            )
                    .forEach(bookDao::save);
        };
    }
}










