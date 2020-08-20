package com.yuanqi.dbproject.controller;

import com.yuanqi.dbproject.data.entity.Customer;
import com.yuanqi.dbproject.services.CustomerService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : yuanqi
 */


@RestController
@RequestMapping("/login")
public class LoginController {
private CustomerService customerService;

    public LoginController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/login")
    public Customer login(@RequestParam(name = "loginName", required = false) String loginName,
                          @RequestParam(name = "loginSecret", required = false) String loginSecret) throws Exception {
        return customerService.customerLogin(loginName, loginSecret);

    }
}
