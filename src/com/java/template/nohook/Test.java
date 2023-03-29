package com.java.template.nohook;

import java.util.EnumSet;

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

        EnumSet<Topping> toppingsNone = EnumSet.noneOf(Topping.class);
        EnumSet<Topping> toppingsAll = EnumSet.allOf(Topping.class);
        System.out.println();
    }

    public enum Topping {HAM, MUSHROOM}
}
