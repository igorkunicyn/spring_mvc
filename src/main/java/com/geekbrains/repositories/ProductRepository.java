package com.geekbrains.repositories;

import com.geekbrains.entites.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductRepository {
    private List<Product> productList;

//    @Autowired
    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @Autowired
    public ProductRepository() {
        productList = new ArrayList<>();
    }
//    public void addProduct(int id, String title, float cost){
//        Product product = new Product();
//        product.setId(id);
//        product.setTitle(title);
//        product.setCost(cost);
//        productList.add(product);
//    }
//    public Product addProduct(){
//        Product product = new Product();
//        productList.add(product);
//        return product;
//    }
    public Product findProductById(int id){
        return productList.get(id);
//        for (Product product: productList) {
//            if (product.getId() == id) {
//                return product;
//            }
//        }
//        return "Объект с id = " + id + " отсутствует";
    }

    public List<Product> getProductList() {
        return productList;
    }

}
