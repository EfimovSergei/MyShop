package org.example;

import java.util.ArrayList;
import java.util.List;

public class Buyer {
    private String name;
    private int money;
    private List<Product> purchaseList=new ArrayList<>();

    public Buyer(String name, int money) {
        this.name = name;
        this.money = money;
    }

    protected String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected int getMoney() {
        return money;
    }

    protected boolean setMoney(int money) {
        if (this.money>=money) {
            this.money -= money;
            return true;
        }
        return false;
    }
    protected void addPurchaseList(Product product){
        purchaseList.add(product);

    }
    public void getPurchaseList() {
        int i=0;
        for (Product product: purchaseList){
            System.out.println(i+" "+product);
            i++;
        }
    }
    protected void addMoney(int money){
        this.money+=money;
        System.out.println("На счёту покупателя "+this.money+" мухов.");
    }
    protected Product getProdByNumber(int numberProduct){
        return purchaseList.get(numberProduct);
    }
}
