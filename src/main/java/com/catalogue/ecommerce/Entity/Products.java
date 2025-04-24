package com.catalogue.ecommerce.Entity;


import jakarta.persistence.*;

@Entity

public class Products {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String product_name;

    @Lob
    private byte[] product_image;

    private String product_description;

    private String product_price;

    private String product_category;

    public Products() {
    }

    public Products(Long id, String product_name, byte[] product_image, String product_description, String product_price, String product_category) {
        this.id = id;
        this.product_name = product_name;
        this.product_image = product_image;
        this.product_description = product_description;
        this.product_price = product_price;
        this.product_category = product_category;
    }

    @Override
    public String toString() {
        return "Products{" +
                "id=" + id +
                ", product_name='" + product_name + '\'' +
                ", product_image=" + product_image +
                ", product_description='" + product_description + '\'' +
                ", product_price='" + product_price + '\'' +
                ", product_category='" + product_category + '\'' +
                '}';
    }

    public byte[] getProduct_image() {
        return product_image;
    }

    public void setProduct_image(byte[] product_image) {
        this.product_image = product_image;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProduct_description() {
        return product_description;
    }

    public void setProduct_description(String product_description) {
        this.product_description = product_description;
    }

    public String getProduct_price() {
        return product_price;
    }

    public void setProduct_price(String product_price) {
        this.product_price = product_price;
    }

    public String getProduct_category() {
        return product_category;
    }

    public void setProduct_category(String product_category) {
        this.product_category = product_category;
    }
}
