package com.yuanqi.dbproject.data.mapper;

import com.yuanqi.dbproject.data.entity.CustomerServiceSubscription;
import com.yuanqi.dbproject.data.entity.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author : yuanqi
 */
@org.springframework.stereotype.Service
public class SubscriptionMapper {
    private Service serviceOne = new Service();
    // auto increase id
    private AtomicLong subscriptionId = new AtomicLong(1);

    // initial test date
    {
        serviceOne.setId(1L);
        serviceOne.setName("service one");
        serviceOne.setFixedAttribute("I'm fixed");
    }

    private final CustomerServiceSubscription subscriptionOne = new CustomerServiceSubscription();

    {
        subscriptionOne.setId(subscriptionId.getAndIncrement());
        subscriptionOne.setCustomerId(1L);
        subscriptionOne.setServiceId(1L);
        subscriptionOne.setCustomerChangeableAttribute("I can change");
    }

    private Service serviceTwo = new Service();

    {
        serviceTwo.setId(2L);
        serviceTwo.setName("service two");
        serviceTwo.setFixedAttribute("I'm fixed");
    }

    private final CustomerServiceSubscription subscriptionTwo = new CustomerServiceSubscription();

    {
        subscriptionTwo.setId(subscriptionId.getAndIncrement());
        subscriptionTwo.setCustomerId(1L);
        subscriptionTwo.setServiceId(2L);
        subscriptionTwo.setCustomerChangeableAttribute("I can change");
    }

    /**
     * Use a hash map to simulate data base actions
     */
    private HashMap<Long, List<CustomerServiceSubscription>> subscriptionMap = new HashMap<>();
    private HashMap<Long, CustomerServiceSubscription> subscriptionRecords = new HashMap<>();

    {
        List<CustomerServiceSubscription> list = new ArrayList<>();
        list.add(subscriptionOne);
        list.add(subscriptionTwo);
        subscriptionMap.put(subscriptionOne.getCustomerId(), list);
        subscriptionRecords.put(subscriptionOne.getId(), subscriptionOne);
        subscriptionRecords.put(subscriptionTwo.getId(), subscriptionTwo);
    }


    private List<CustomerServiceSubscription> databaseSelection(Long customerId) {
        return subscriptionMap.get(customerId);
    }

    /**
     * suppose one service can only be subscribed by on customer once
     */
    private int databaseAddition(Long customerId, Long serviceId, String changeableAttribute) throws Exception {
        List<CustomerServiceSubscription> list = subscriptionMap.computeIfAbsent(customerId, k -> new ArrayList<>());
        if (list.stream().anyMatch(subscription -> subscription.getServiceId().equals(serviceId))) {
            throw new Exception("service already has been subscribed");
        }
        CustomerServiceSubscription customerServiceSubscription = new CustomerServiceSubscription();
        customerServiceSubscription.setCustomerId(customerId);
        customerServiceSubscription.setId(subscriptionId.getAndIncrement());
        customerServiceSubscription.setServiceId(serviceId);
        customerServiceSubscription.setCustomerChangeableAttribute(changeableAttribute);
        list.add(customerServiceSubscription);
        subscriptionRecords.put(customerServiceSubscription.getId(), customerServiceSubscription);
        return 1;

    }

    /**
     * modify the changeable value in the subscription
     */
    private int databaseModification(Long subscriptionId, String changeableAttribute) {
        CustomerServiceSubscription subscription = subscriptionRecords.get(subscriptionId);
        if (null != subscription) {
            subscription.setCustomerChangeableAttribute(changeableAttribute);
            return 1;
        }
        return 0;
    }

    private int databaseDeletion(Long subscriptionId) {
        CustomerServiceSubscription subscription = subscriptionRecords.get(subscriptionId);
        if (null == subscription) {
            return 0;
        }
        List<CustomerServiceSubscription> list = subscriptionMap.get(subscription.getCustomerId());
        if (list.remove(subscription)) {
            subscriptionRecords.remove(subscriptionId);
            return 1;
        }
        return 0;
    }


    /**
     * get result from the database
     */
    public List<CustomerServiceSubscription> getCustomerServiceByCustomerId(Long customerId) {
        return databaseSelection(customerId);
    }

    /**
     * add new subscribe service
     */
    public boolean addSubscribedService(Long customerId,
                                        Long serviceId,
                                        String changeableAttribute) throws Exception {
        return 1 == databaseAddition(customerId, serviceId, changeableAttribute);
    }

    /**
     * if modify successfully, return 1, or 0
     */
    public boolean modifySubscribedService(Long subscriptionId, String changeableAttribute) {
        return 1 == databaseModification(subscriptionId, changeableAttribute);
    }

    public boolean deleteSubscribedService(Long subscriptionId) {
        return 1 == databaseDeletion(subscriptionId);
    }
}
