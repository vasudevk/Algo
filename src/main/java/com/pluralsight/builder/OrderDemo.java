package com.pluralsight.builder;

public class OrderDemo {

    public static void main(String[] args) {

        Order.Builder builder = new Order.Builder();
        builder.bread("Sourdough").condiments("Lettuce").dressing("Ranch").meat("Bacon");

        Order order = builder.build();
        System.out.println(order.getBread());
        System.out.println(order.getCondiments());
        System.out.println(order.getDressing());
        System.out.println(order.getMeat());
    }
}