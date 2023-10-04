package org.example;

import java.util.Objects;

public class Product {
    final String name;
    private int price;
    final String maker;
    private int quantity;
    private double rating = 4;
    private int countRating = 2;


    protected Product(String name, int price, String maker, int quantity) {
        this.name = name;
        this.price = price;
        this.maker = maker;
        this.quantity = quantity;
    }

    public double getRating() {
        return rating;
    }

    protected void setRating(double rating) {
        if (rating <= 5) {
            this.rating = (rating + this.rating) / countRating;
            countRating +=1;
            System.out.println(getRating());
        } else {
            System.out.println("Неверный ввод");
        }
    }

    @Override
    public String toString() {
        return "Тип продукта - " + name + ", Цена - " + price + ", Производитель - " + maker + ", Количество доступное - " + quantity + ", Рейтинг товара - " + rating;
    }

    protected void setQuantity(int quantity) {
        if (this.quantity >= quantity) {
            this.quantity -= quantity;
        }
    }

    protected int getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return price == product.price && quantity == product.quantity && Double.compare(product.rating, rating) == 0 && countRating == product.countRating && Objects.equals(name, product.name) && Objects.equals(maker, product.maker);
    }

    public int getQuantity() {
        return quantity;
    }
}
