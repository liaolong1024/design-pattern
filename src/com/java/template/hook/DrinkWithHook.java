package com.java.template.hook;

/**
 * 带有钩子的模板方法类
 * @author ll
 */
public abstract class DrinkWithHook {

    final void prepareRecipe() {
        boilWater();
        dealWithWater();
        pourInCup();
        if (customerWantsRecipe()) {
            addRecipe();
        }
    }

    /** 所有子类的boil water一样，所以在父类中提供默认实现 */
    void boilWater() {
        System.out.println("Boiling Water");
    }

    /** 子类自行实现 */
    abstract void dealWithWater();

    protected void pourInCup() {
        System.out.println("Pouring into cup");
    }

    abstract void addRecipe();

    /** 钩子方法类，父类可提供默认实现，也可以是空实现，子类可根据需要覆盖这个方法 */
    boolean customerWantsRecipe() {
        return true;
    }

}
