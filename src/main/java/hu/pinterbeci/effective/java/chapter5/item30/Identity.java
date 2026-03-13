package hu.pinterbeci.effective.java.chapter5.item30;

import java.util.function.UnaryOperator;

public final class Identity<T> {
    // Generic singleton factory pattern
    private final static UnaryOperator<Object> IDENTITY_FN = (t) -> t;

    private Identity() {
    }

    @SuppressWarnings("unchecked")
    public static <T> UnaryOperator<T> identityFunction() {
        return (UnaryOperator<T>) IDENTITY_FN;
    }
}
