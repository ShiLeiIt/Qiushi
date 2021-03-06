package com.samrt.qiushi.icecream.model;

import java.io.Serializable;

/**
 * Created by shilei on 2018/11/1
 */

public class ProductBean implements Serializable {
    private String name;            //产品名称
    private double price;           //单价
    private double amount;          //总价
    private int num;                //数量

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    private double discount;        //折扣优惠
}
