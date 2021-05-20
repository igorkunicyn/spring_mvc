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

    //    private StudentsService studentsService;
    private ProductService productService;
//    private ProductRepository productRepository;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }
//    @Autowired
//    public void setProductRepository(ProductRepository productRepository) {
//        this.productRepository = productRepository;
//    }
//    @RequestMapping("/showStudent")
//    public String hello(Model uiModel, @ModelAttribute("student") Student student) {
//        student = studentsService.getStudentById(10);
//        uiModel.addAttribute("student", student);
//        System.out.println(student.getFirstName() + " " + student.getLastName());
//        return "students";
//    }

    @RequestMapping(path = "/showProductById", method = RequestMethod.GET)
    @ResponseBody
    public String showProductById(@RequestParam int id) {
        return productService.getProductById(id);
    }

//    @RequestMapping(path = "/setStudentById", method = RequestMethod.POST)
//    public void setStudent(@RequestBody Student student) {
//        System.out.println(student.getFirstName() + " " + student.getLastName());
//    }

//    @RequestMapping("/showForm")
//    public String showSimpleForm(Model uiModel) {
//        Student student = new Student();
//        uiModel.addAttribute("student", student);
//        return "student-form";
//    }

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

