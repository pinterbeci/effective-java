package hu.pinterbeci.effective.java.chapter2.item2;

//JavaBeans pattern:
//in which you call a parameterless
//constructor to create the object and then call setter methods to set each required
//parameter and each optional parameter of interest

//Disadvantage:
//a JavaBean may be in an inconsistent state partway through its construction.
//cannot check the validity when call multiple setters, easily creates an inconsistent state

//JavaBeans Pattern - allows inconsistency, mandates mutability
//JavaBeans Patterns precludes the immutability

//then came the 'Builder Pattern'
//please look at the BuilderPattern
public class JavaBeansPattern {

    private int servingSize = -1; // Required; no default value
    private int servings = -1; // Required; no default value
    private int calories = 0;
    private int fat = 0;
    private int sodium = 0;
    private int carbohydrate = 0;

    public JavaBeansPattern() {
    }

    public void setServingSize(int servingSize) {
        this.servingSize = servingSize;
    }

    public void setServings(int servings) {
        this.servings = servings;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    public void setSodium(int sodium) {
        this.sodium = sodium;
    }

    public void setCarbohydrate(int carbohydrate) {
        this.carbohydrate = carbohydrate;
    }
}
