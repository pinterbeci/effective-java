package chapter1.item3;

public class SingletonCreationWithStaticMethod {

    private static final SingletonCreationWithStaticMethod INSTANCE = new SingletonCreationWithStaticMethod();

    private SingletonCreationWithStaticMethod() {
    }

    public static SingletonCreationWithStaticMethod getInstance() {
        return INSTANCE;
    }
}
