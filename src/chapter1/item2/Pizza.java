package chapter1.item2;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

public abstract class Pizza {
    public enum Topping {HAM, MUSHROOM, ONION, PEPPER, SAUSAGE}

    final Set<Topping> toppings;

    // recursive type parameter, the Builder referring oneself
    //T generic value is a class, which extends this Builder<T> static abstract class
    abstract static class Builder<T extends Builder<T>> {
        final EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);

        public T addTopping(final Topping topping) {
            toppings.add(Objects.requireNonNull(topping));
            return self();
        }

        abstract Pizza build();

        // Subclasses must override this method to return "this"
        protected abstract T self();
    }

    Pizza(final Builder<?> builder) {
        toppings = builder.toppings.clone(); // See Item 50
    }
}
