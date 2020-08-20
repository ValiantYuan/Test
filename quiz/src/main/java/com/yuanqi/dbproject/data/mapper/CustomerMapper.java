package com.yuanqi.dbproject.data.mapper;

import com.yuanqi.dbproject.data.entity.Customer;

import org.springframework.stereotype.Service;

/**
 * @author : yuanqi
 */
@Service
public class CustomerMapper {
    private final Customer customer = new Customer();

    {
        customer.setId(1L);
        customer.setName("test user");
        customer.setLoginName("login");
        customer.setLoginSecret("secret");
    }

    public Customer getCustomerInfoFromLogin(String loginName,
                                             String loginSecret) throws Exception {
        Customer customerFromDB = dataBaseSelection(loginName, loginSecret);
        if (null != customerFromDB) {
            return customerFromDB;
        }
        throw new Exception("user does not exist or wrong password");
    }

    /**
     * get customer id from database,
     */
    private Customer dataBaseSelection(String loginName,
                                      String loginSecret) {
        return customer;
    }
}
