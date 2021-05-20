package com.geekbrains.controllers;

import com.geekbrains.entites.Product;
import com.geekbrains.enums.AddProduct;
import com.geekbrains.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(path = "/showProductById", method = RequestMethod.GET)
    @ResponseBody
    public String showProductById(@RequestParam int id) {
        return productService.getProductById(id);
    }

    @RequestMapping("/showForm")
    public String showSimpleForm(Model uiModel) {
        Product product = new Product();
        uiModel.addAttribute("product", product);
        return "product-add-form";
    }

    @RequestMapping("/resultAddProduct")
    public String resultAddProduct(@ModelAttribute("product") Product product) {
        String result = productService.addProduct(product);
        if (result.equals(AddProduct.ADD_PRODUCT.getName())) {
            return "product-add-form-success";
        }
        if (result.equals(AddProduct.ID_NOT_UNIQUE.getName())) {
            return "product-not-unique-id";
        }
        return "product-exists";
    }

    @RequestMapping("/listProducts")
    public String listProducts(Model uiModel) {
        List<Product> products = productService.getProductRepository().getProductList();
        uiModel.addAttribute("products", products);
        return "product-result-list";
    }
}

