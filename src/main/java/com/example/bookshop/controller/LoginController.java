package com.example.bookshop.controller;

import com.example.bookshop.dao.CustomerDao;
import com.example.bookshop.entity.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class LoginController {
    private final CustomerDao customerDao;

    @GetMapping("/login")
    public String login() {
        return "login";

    }

    @GetMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login";
    }

    @GetMapping("/account/info")
    public String showAccountInfo(Model model, Authentication authentication) {
        if (authentication == null) {
            return "redirect:/login";
        }
        String customerName = authentication.getName();
        Customer customer = customerDao.findByName(customerName)
                .orElseThrow(() -> new UsernameNotFoundException(customerName + "Not found"));
        model.addAttribute("customerName", customerName);
        model.addAttribute("items",
                customer.getBookItems()
        );
        return "accountInfo";
    }
}
