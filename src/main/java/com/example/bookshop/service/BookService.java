package com.example.bookshop.service;

import com.example.bookshop.dao.BookDao;
import com.example.bookshop.entity.Book;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookDao bookDao;

    public List<Book> findAllBooks(){
        return bookDao.findAll();
    }
    public Book findBookById(int id){
        return bookDao.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }
}
