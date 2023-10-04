package org.example;


import java.util.*;

public class Main {
    public static void main(String[] args) {
        Shop kittyShop = shopMaker();
        Buyer buyer = new Buyer("Alina", 100000);
        Scanner input = new Scanner(System.in);
        System.out.println("Привет, красотка! Я - твой прекрасный магазин \"Kitty Shop\"!\n" +
                "Выберите подходяший для Вас пункт:\n");

        // SOLID [S]: каждый класс выполняет свои функции, у покупателя функционал покупательский и т.д.
        // SOLID [О]: если я правильно понял, это касается и полей. В классе Buyer есть поле с List<Product>
        //      для совершенных покупок. Мы никак не можем повлиять на сам лист, кроме как делая покупи.
        //      Одновременно открыт для добавления, и закрыт для замены и удаления.
        // DRY: может пример так себе, но этот цикл написан один раз
        //      и будет повторяться сколько нужно
        loop:
        while (true) {
            consoleStandart();
            String choice = input.next();
            if (choice.equals("end")) {
                System.out.println("Вы вышли из магазина. До свидания!");
                break;
            }
            switch (Integer.parseInt(choice)) {
                case 1:
                    // Magics: здесь можно было использовать for, как последнее число использовать размер productList
                    for (Product product : kittyShop.getProductList()) {
                        System.out.println(product + "\n");
                    }
                    break;
                case 2:
                    System.out.println("Выберите товар или напишите \"end\" для выхода из магазина: ");
                    int i = 0;
                    ///// Magics: здесь можно было использовать for, как последнее число использовать размер productList
                    for (Product product : kittyShop.getProductList()) {
                        System.out.println("[" + i + "] " + product);
                        i++;
                    }
                    System.out.println();
                    choice = input.next();
                    System.out.println("Введите кол-во покупаемого товара или напишите \"end\" для выхода из магазина: ");
                    int choiceQuantity = input.nextInt();
                    if (choice.equals("end")) {
                        break loop;
                    }
                    kittyShop.transaction(Integer.parseInt(choice), buyer, choiceQuantity);
                    break;
                case 3:
                    System.out.println("Выберите из списка товар или напишите \"end\" для выхода из магазина: ");
                    buyer.getPurchaseList();
                    String choiceProduct = input.next();
                    if (choiceProduct.equals("end")) {
                        break loop;
                    }
                    System.out.println("Поставьте оценку от 1 до 5 или напишите \"end\" для выхода из магазина: ");
                    String choiceProductRating = input.next();
                    buyer.getProdByNumber(Integer.parseInt(choiceProduct)).setRating(Double.parseDouble(choiceProductRating));
                    System.out.println("Спасибо за оценку\n");
                    System.out.println();
                    break;
                case 4:
                    System.out.println(buyer.getMoney() + " мухов!!!\n");
                    break;
                default:
                    System.out.println("!!!Неизвестная команда!!!\n");
            }

        }
    }


    public static Shop shopMaker() {
        Product product1 = new Product("Помада", 7500, "Dior", 30);
        Product product2 = new Product("Духи", 7500, "Versace", 20);
        Product product3 = new Product("Лак", 7500, "Prada", 10);
        Product product4 = new Product("Тени", 7500, "Dior", 5);
        ArrayList<Product> productList = new ArrayList<>();
        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
        productList.add(product4);
        return new Shop(productList);
    }

    public static void consoleStandart() {
        System.out.println(
                "1-Показать все товары\n" +
                        "2-Купить товар\n" +
                        "3-Оценить товар\n" +
                        "4-Запросить баланс\n" +
                        "Для выхода из магазина напишите \"end\""
        );
    }
}