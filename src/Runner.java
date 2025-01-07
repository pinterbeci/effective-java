import chapter1.item2.NutritionFacts;

public class Runner {
    public static void main(String[] args) {

        final NutritionFacts nutritionFacts = new NutritionFacts.Builder(10, 10).calories(55).fat(55).build();
        System.out.println("Hello world!");
    }
}