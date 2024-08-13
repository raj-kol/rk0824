package com.hd.rental.model;


public class Tool {

    private String code;

    private String type;

    private String brand;

    private PriceInfo priceInfo;

    public Tool(String code, String type, String brand, PriceInfo priceInfo) {
        this.code = code;
        this.type = type;
        this.brand = brand;
        this.priceInfo = priceInfo;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public PriceInfo getPriceInfo() {
        return priceInfo;
    }

    public void setPriceInfo(PriceInfo priceInfo) {
        this.priceInfo = priceInfo;
    }

}
