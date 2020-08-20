package com.yuanqi.dbproject.services;

import com.yuanqi.dbproject.data.entity.Customer;
import com.yuanqi.dbproject.data.entity.CustomerServiceSubscription;
import com.yuanqi.dbproject.data.mapper.CustomerMapper;
import com.yuanqi.dbproject.data.mapper.SubscriptionMapper;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : yuanqi
 * @since : 2020/8/20
 */
@Service
public class CustomerService {
    private CustomerMapper customerMapper;
    private SubscriptionMapper subscriptionMapper;

    public CustomerService(CustomerMapper customerMapper,
                           SubscriptionMapper subscriptionMapper) {
        this.customerMapper = customerMapper;
        this.subscriptionMapper = subscriptionMapper;
    }

    public Customer customerLogin(String loginName,
                                  String loginSecret) throws Exception {
        return customerMapper.getCustomerInfoFromLogin(loginName, loginSecret);

    }

    public List<CustomerServiceSubscription> getSubscribedServicesByCustomerId(Long customerId) {
        return subscriptionMapper.getCustomerServiceByCustomerId(customerId);
    }


    public boolean addSubscribedServicesByCustomerId(Long customerId,
                                                     Long serviceId,
                                                     String changeableAttribute) throws Exception {
        return subscriptionMapper.addSubscribedService(customerId, serviceId, changeableAttribute);
    }

    public boolean modifySubscribedService(Long subscriptionId, String changeableAttribute) {
        return subscriptionMapper.modifySubscribedService(subscriptionId, changeableAttribute);
    }

    public boolean deleteSubscribedService(Long subscriptionId) {
        return subscriptionMapper.deleteSubscribedService(subscriptionId);
    }

}
