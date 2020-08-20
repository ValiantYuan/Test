package com.yuanqi.dbproject.data.entity;

/**
 * @author : yuanqi
 */
public class CustomerServiceSubscription {
    private Long id;
    private Long customerId;
    private Long serviceId;
    private String customerChangeableAttribute;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public String getCustomerChangeableAttribute() {
        return customerChangeableAttribute;
    }

    public void setCustomerChangeableAttribute(String customerChangeableAttribute) {
        this.customerChangeableAttribute = customerChangeableAttribute;
    }
}
