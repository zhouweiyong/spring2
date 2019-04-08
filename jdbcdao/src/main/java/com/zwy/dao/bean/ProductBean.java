package com.zwy.dao.bean;

public class ProductBean {

    private int id;
    private String name;
    private int price;
    private int cid;

    public ProductBean() {
    }

    public ProductBean(int id, String name, int price, int cid) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.cid = cid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }
}
