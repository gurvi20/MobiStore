package com.example.mobistorefinal;


public class Product {
    String name;
    String BrandName;
    Double Price;
    int rating;
    String imagePath;

    public Product() {
        this.name = "";
        BrandName = "";
        Price = 0.0;
        this.rating = 5;
        this.imagePath = "";
    }

    public Product(String name, String brandName, Double price, int rating, String imagePath) {
        this.name = name;
        BrandName = brandName;
        Price = price;
        this.rating = rating;
        this.imagePath = imagePath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrandName() {
        return BrandName;
    }

    public void setBrandName(String brandName) {
        BrandName = brandName;
    }

    public Double getPrice() {
        return Price;
    }

    public void setPrice(Double price) {
        Price = price;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
