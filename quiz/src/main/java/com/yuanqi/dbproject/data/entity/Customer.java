package com.yuanqi.dbproject.data.entity;

/**
 * @author : yuanqi
 */
public class Customer {
    private Long id;
    private String name;
    private String loginName;
    private String loginSecret;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginSecret() {
        return loginSecret;
    }

    public void setLoginSecret(String loginSecret) {
        this.loginSecret = loginSecret;
    }
}
