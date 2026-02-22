package hu.pinterbeci.effective.java.chapter4.item24;

import java.util.List;

/*
Static nested class:
        Bloch's rule of thumb is simple: if you declare a member class that doesn't need access to the enclosing instance,
        always put the static modifier on it. This is the safe default.

 Non-static inner class:
        Use a non-static member class (inner class) when the nested class genuinely needs to access the enclosing
        instance's fields or methods — typically when implementing an adapter that lets the inner object
        be viewed as an instance of some unrelated type. The classic Java library example is iterators
        inside collections (e.g., ArrayList's iterator needs to read the list's elements).
 */
public class Order {
    private String orderId;
    private List<LineItem> items;

    public static class LineItem { // static — no hidden reference
        private final String productId;
        private final int quantity;

        public LineItem(String productId, int quantity) {
            this.productId = productId;
            this.quantity = quantity;
        }

        public double calculateSubtotal(double unitPrice) {
            return unitPrice * quantity;
        }
    }
}
/*
The Core Distinction
    A non-static member class (inner class) holds an implicit reference to its enclosing instance.

    A static member class does not. That hidden reference has real consequences:
            It costs memory (an extra reference on every inner class instance)
            It can prevent garbage collection of the enclosing instance (a classic memory leak)
            It makes instantiation slightly more complex
 */
class OrderWrongExample {
    private String orderId;
    private List<LineItem> items;

    public class LineItem { // non-static — holds ref to Order, and does not use it
        private final String productId;
        private final int quantity;

        public LineItem(String productId, int quantity) {
            this.productId = productId;
            this.quantity = quantity;
        }
    }
}