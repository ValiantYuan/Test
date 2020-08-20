package com.yuanqi.dbproject.controller;

/**
 * @author : yuanqi
 */
public class AddSubscriptionRequest {
    Long customerId;
    Long serviceId;
    String changeableAttribute;

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

    public String getChangeableAttribute() {
        return changeableAttribute;
    }

    public void setChangeableAttribute(String changeableAttribute) {
        this.changeableAttribute = changeableAttribute;
    }
}
