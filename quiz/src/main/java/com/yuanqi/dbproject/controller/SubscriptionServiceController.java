package com.yuanqi.dbproject.controller;

import com.yuanqi.dbproject.data.entity.CustomerServiceSubscription;
import com.yuanqi.dbproject.services.CustomerService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author : yuanqi
 */
@RestController
@RequestMapping("/v1")
public class SubscriptionServiceController {
    private CustomerService customerService;

    public SubscriptionServiceController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{customerId}/subscriptions")
    public List<CustomerServiceSubscription> getCustomerSubscribedServices(@PathVariable("customerId") Long customerId) {
        return customerService.getSubscribedServicesByCustomerId(customerId);
    }

    @PostMapping("/subscriptions")
    public Boolean addCustomerSubscribedServices(@RequestBody AddSubscriptionRequest request) throws Exception {
        return customerService.addSubscribedServicesByCustomerId(request.getCustomerId(),
            request.getServiceId(), request.getChangeableAttribute());
    }

    /**
     * i don't handle exceptions here and just return an boolean, because it is just similar with
     * add peration, and so dose the other operations.
     * @param subscriptionId
     * @param changeableAttribute
     * @return
     */
    @PutMapping("/subscriptions/{subscriptionId}")
    public Boolean modifyCustomerSubscribedServices(@PathVariable("subscriptionId") Long subscriptionId,
                                                    @RequestParam("changeableAttribute") String changeableAttribute) {
        return customerService.modifySubscribedService(subscriptionId, changeableAttribute);
    }

    @DeleteMapping("/subscriptions/{subscriptionId}")
    public Boolean deleteCustomerSubscribedService(@PathVariable("subscriptionId") Long subscriptionId) {
        return customerService.deleteSubscribedService(subscriptionId);
    }
}
