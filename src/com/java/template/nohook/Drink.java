package com.java.template.nohook;

/**
 * 按提示自己实现的抽象类
 * @author ll
 */
public abstract class Drink {

    /*该方法应当声明成final的, 因为步骤是固定的，不希望子类覆盖这个方法
    void prepareRecipe() {
        boilWater();
        dealWithWater();
        pourInCup();
        addRecipe();
    }
    */

    final void prepareRecipe() {
        boilWater();
        dealWithWater();
        pourInCup();
        addRecipe();
    }

    // 所有子类的boil water一样，所以在父类中提供默认实现
    void boilWater() {
        System.out.println("Boiling Water");
    }

    // 子类自行实现
    abstract void dealWithWater();

    protected void pourInCup() {
        System.out.println("Pouring into cup");
    }

    abstract void addRecipe();

}
