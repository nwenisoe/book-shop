package com.example.bookshop.service;

import com.example.bookshop.dao.CustomerDao;
import com.example.bookshop.ds.CardItem;
import com.example.bookshop.entity.BookItem;
import com.example.bookshop.entity.Customer;
import com.example.bookshop.entity.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerDao customerDao;
    private final PasswordEncoder passwordEncoder;
    private final CartService cartService;
    @Transactional
    public void saveCustomer(Customer customer) {
        Optional<Customer> customerOptional =
                customerDao.findByName(customer.getName());
        if (!customerOptional.isPresent()) {


            customer.setPassword(passwordEncoder.encode(customer.getPassword()));
            customer.setRole(Role.ROLE_USER);
            addBookItems(customer);

            customerDao.save(customer);
        } else {
        Customer customer1=customerOptional.get();
        customer1.setId(customer1.getId());
        customer1.setPassword(customer1.getPassword());
       Set<BookItem> bookItems = customer1.getBookItems();


        addBookItems(customer1);
        customerDao.saveAndFlush(customer1);
        }
    }

    private void addBookItems(Customer customer) {
        cartService.listCartItems()
                .stream().forEach(c ->
        {
            customer.addBook(toBookItem(c));

        });
    }

    private BookItem toBookItem(CardItem cardItem) {
        return new BookItem(
                cardItem.getId(),
                cardItem.getTitle(),
                cardItem.getAuthor(),
                cardItem.getPrice(),
                cardItem.getQuantity(),
                cardItem.getPrice()*cardItem.getQuantity()
        );
    }

}
