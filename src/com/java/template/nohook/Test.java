package com.java.template.nohook;

/**
 * @author ll
 */
public class Test {
    public static void main(String[] args) {
        Drink coffee = new Coffee();
        Drink tea = new Tea();
        coffee.prepareRecipe();
        System.out.println("=========");
        tea.prepareRecipe();
    }
}
