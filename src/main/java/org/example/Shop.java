package org.example;

import java.util.*;


public class Shop {
    private ArrayList<Product> productList;
    private int bankAccount;

    Shop(ArrayList<Product> productList) {
        this.productList = productList;
    }

    public void addProduct(Product product) {
        if (!productList.contains(product))
            productList.add(product);
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void transaction(int productNumber, Buyer buyer, int choiceQuantity) {
        if (productNumber <= productList.size()) {
            int totallyPrice = productList.get(productNumber).getPrice() * choiceQuantity;
            if (buyer.setMoney(totallyPrice)) {
                bankAccount += totallyPrice;
                productList.get(productNumber).setQuantity(choiceQuantity);
                buyer.addPurchaseList(productList.get(productNumber));
                System.out.println("Покупка успешно завершена!");
                buyer.getPurchaseList();
            } else {
                System.out.println("!!!На счёте не хватает деняжкав!!!\n");
            }
        } else {
            System.out.println("!!!Товара под данным номером не сушествует!!!\n");
        }
    }
}
