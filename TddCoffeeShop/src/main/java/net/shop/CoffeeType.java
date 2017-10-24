package net.shop;

enum CoffeeType {

    EXPRESSO("Expresso"), LATTE("Latte");

    private String value;

    private CoffeeType(String value) {
        this.value = value;
    }
}
