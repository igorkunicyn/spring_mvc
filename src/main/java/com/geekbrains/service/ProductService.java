package com.geekbrains.service;

import com.geekbrains.entites.Product;
import com.geekbrains.enums.AddProduct;
import com.geekbrains.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductRepository getProductRepository() {
        return productRepository;
    }

    public String getProductById(int id) {
        for (Product product: productRepository.getProductList()) {
            if (product.getId() == id) {
               return String.format("id: %s, title: %s, cost: %s",product.getId(), product.getTitle(),product.getCost());
            }
        }
        return "Product with id = " + id + " not exists";
    }

    public String addProduct(Product product){
        for (Product products : productRepository.getProductList()) {
            if (product.getId() == products.getId()) return AddProduct.ID_NOT_UNIQUE.getName();
            if (product.getTitle().equals(products.getTitle()) && product.getCost()== products.getCost()){
                return AddProduct.PRODUCT_EXISTS.getName();
            }
        }
        productRepository.getProductList().add(product);
        return AddProduct.ADD_PRODUCT.getName();
    }

    public ProductService() {

    }
}
