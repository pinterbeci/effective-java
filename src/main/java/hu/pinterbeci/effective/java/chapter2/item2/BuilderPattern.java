package hu.pinterbeci.effective.java.chapter2.item2;

//Builder Pattern:
//instead of making the desired object directly,
//the client calls the constructor/static factory with all of required parameters,
//and get a 'BUILDER OBJECT'
//then the client perfectly use the 'BUILDER OBJECT' to set the optional parameters

//finally the client call the 'build()' method to generate the required object, which typically immutable

//IllegalArgumentException thrown after the validity check

//The Builder pattern simulates named optional parameters
public class BuilderPattern {
    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;

    public static class Builder {
        // Required parameters:
        private final int servingSize;
        private final int servings;
        // Optional parameters - initialized to default values:
        private int calories = 0;
        private int fat = 0;
        private int sodium = 0;
        private int carbohydrate = 0;

        public Builder(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings = servings;
        }

        public Builder calories(int val) {
            calories = val;
            return this;
        }

        public Builder fat(int val) {
            fat = val;
            return this;
        }

        public Builder sodium(int val) {
            sodium = val;
            return this;
        }

        public Builder carbohydrate(int val) {
            carbohydrate = val;
            return this;
        }

        public BuilderPattern build() {
            return new BuilderPattern(this);
        }
    }

    private BuilderPattern(Builder builder) {
        servingSize = builder.servingSize;
        servings = builder.servings;
        calories = builder.calories;
        fat = builder.fat;
        sodium = builder.sodium;
        carbohydrate = builder.carbohydrate;
    }
}
