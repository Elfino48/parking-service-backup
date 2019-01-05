package org;

import logic.Main;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Product {
    public String name;
    public String description;
    public String price;

    public Product(String name, String description, String price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public static List<Product> getList(){

        Product pr1 = new Product("Prod1", "asdfasdf", "123");
        Product pr2 = new Product("Prod2", "asdfasdf", "123");
        Product pr3 = new Product("Prod3", "asdfasdf", "123");
        Product pr4 = new Product("Prod4", "asdfasdf", "123");
        List<Product> list = new ArrayList<>();
        list.add(pr1);
        list.add(pr2);
        list.add(pr3);
        list.add(pr4);

        return list;
    }

}
