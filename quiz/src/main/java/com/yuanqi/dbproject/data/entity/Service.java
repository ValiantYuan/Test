package com.yuanqi.dbproject.data.entity;

/**
 * @author : yuanqi
 */

public class Service {
    private Long id;
    private String name;
    private String fixedAttribute;

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

    public String getFixedAttribute() {
        return fixedAttribute;
    }

    public void setFixedAttribute(String fixedAttribute) {
        this.fixedAttribute = fixedAttribute;
    }
}
