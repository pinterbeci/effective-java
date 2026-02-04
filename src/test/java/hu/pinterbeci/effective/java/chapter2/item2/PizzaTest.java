package hu.pinterbeci.effective.java.chapter2.item2;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class PizzaTest {
    @Test
    public void different_kind_of_pizzas_initialize() {
        NyPizza nyPizza = new NyPizza.Builder(NyPizza.Size.SMALL)
                .addTopping(Pizza.Topping.HAM)
                .addTopping(Pizza.Topping.ONION)
                .addTopping(Pizza.Topping.PEPPER)
                .build();
        assertThat(nyPizza.toppings).isEqualTo(Set.of(Pizza.Topping.HAM, Pizza.Topping.ONION, Pizza.Topping.PEPPER));
        assertThat(nyPizza.getSize()).isEqualTo(NyPizza.Size.SMALL);
    }

    @Test
    public void should_rejects_initialization() {
        assertThatThrownBy(() ->
                new NyPizza.Builder(null)
                        .addTopping(Pizza.Topping.HAM)
                        .addTopping(Pizza.Topping.ONION)
                        .addTopping(Pizza.Topping.PEPPER)
                        .build()
        );
    }
}