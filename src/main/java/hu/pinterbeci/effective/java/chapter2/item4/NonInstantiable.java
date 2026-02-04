package hu.pinterbeci.effective.java.chapter2.item4;

public class NonInstantiable {
    //to make a class non instantiable make the explicit constructor private
    //the default constructor defines, if there is no explicit constructor
    private NonInstantiable() {
        throw new AssertionError();
    }
}
