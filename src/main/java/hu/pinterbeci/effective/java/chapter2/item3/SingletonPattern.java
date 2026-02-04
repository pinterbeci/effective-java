package hu.pinterbeci.effective.java.chapter2.item3;

import javax.naming.OperationNotSupportedException;

//There is a caveat: the singleton bean can be modified state via reflection;
//the client invoke the private constructor reflectively with 'AccessibleObject.setAccessible'
//defend against this attack, I can modify the constructor to make throw an exception, if it is asked to create
//a second instance
public class SingletonPattern {
    private static final SingletonPattern INSTANCE;

    static {
        try {
            INSTANCE = new SingletonPattern();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //defend against the reflection initialization
    private SingletonPattern() throws OperationNotSupportedException {
        if (INSTANCE != null) {
            throw new OperationNotSupportedException("Attempt to create a second instance of a singleton.");
        }
    }

    public static SingletonPattern getInstance() {
        return INSTANCE;
    }
}
