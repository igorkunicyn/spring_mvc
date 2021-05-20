package com.geekbrains.entites;

public class Product {
    private int id;
    private String title;
    private float cost;
//    private final List<Product> productList = new ArrayList<>();

//    @Autowired
//    public void setProductRepository(ProductRepository productRepository){
//        this.productRepository = productRepository;
//    }

//    public List<Product> getProductList() {
//        return productList;
//    }

//    public Product() {
//        productList.add(this);
//    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public float getCost() {
        return cost;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }
}
