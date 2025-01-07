package chapter1.item2;

public class NutritionFacts {
    //required parameters
    private final int servingSize;
    private final int servings;

    //non-required parameters
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;

    //Builder pattern
    public static class Builder {
        private final int servingSize;
        private final int servings;

        private int calories = 0;
        private int fat = 0;
        private int sodium = 0;
        private int carbohydrate = 0;

        public Builder(final int servingSize, final int servings) {
            this.servingSize = servingSize;
            this.servings = servings;
        }

        public Builder calories(int value) {
            calories = value;
            return this;
        }

        public Builder fat(int value) {
            fat = value;
            return this;
        }

        public Builder sodium(int value) {
            sodium = value;
            return this;
        }

        public Builder carbohydrate(int value) {
            carbohydrate = value;
            return this;
        }

        public NutritionFacts build() {
            return new NutritionFacts(this);
        }
    }

    private NutritionFacts(final Builder builder) {
        servingSize = builder.servingSize;
        servings = builder.servings;
        calories = builder.calories;
        fat = builder.fat;
        sodium = builder.sodium;
        carbohydrate = builder.carbohydrate;
    }
}
