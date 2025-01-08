import chapter1.item3.SingletonCreationWithFinalField;
import chapter1.item2.Calzone;
import chapter1.item2.NutritionFacts;
import chapter1.item2.NyPizza;
import chapter1.item2.Pizza;

public class Runner {
    public static void main(String[] args) {
        final NutritionFacts nutritionFacts = new NutritionFacts
                .Builder(10, 10)
                .calories(55)
                .fat(55)
                .build();

        final NyPizza newNyPizza = new NyPizza.Builder(NyPizza.Size.MEDIUM)
                .addTopping(Pizza.Topping.MUSHROOM)
                .addTopping(Pizza.Topping.HAM)
                .addTopping(Pizza.Topping.ONION)
                .build();

        final Calzone newCalzone = new Calzone.Builder()
                .addTopping(Pizza.Topping.ONION)
                .addTopping(Pizza.Topping.MUSHROOM)
                .addTopping(Pizza.Topping.SAUSAGE)
                .sauceInside()
                .build();

        SingletonCreationWithFinalField.INSTANCE.someMethod();
    }
}