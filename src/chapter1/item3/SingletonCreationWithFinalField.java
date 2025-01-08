package chapter1.item3;

public class SingletonCreationWithFinalField {
    public static final SingletonCreationWithFinalField INSTANCE = new SingletonCreationWithFinalField();

    private SingletonCreationWithFinalField() {
    }

    public void someMethod() {
    }
}
