package com.geekbrains.enums;

public enum AddProduct {
    ADD_PRODUCT("product add"),
    ID_NOT_UNIQUE("id not unique"),
    PRODUCT_EXISTS("product already exists");

    private String name;

    AddProduct(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
