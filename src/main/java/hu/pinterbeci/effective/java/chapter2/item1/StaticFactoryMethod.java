package hu.pinterbeci.effective.java.chapter2.item1;

import java.util.Objects;

public class StaticFactoryMethod {


    private StaticFactoryMethod() {
    }

    private final static String FIRST = "1";

    //static factory methods vs constructors:
    //has names
    // they can invoke cached object, like FIRST
    //they can return an object of any subtype of their return type
    //the class of the returned object can vary from call to call as a function of the input parameters

    //limitations:
    //if a class which use only static factory method, and they have no public or protected constructor, then
    //this class cannot have subclass
    //hard to find them, because they are not stand in API's

    //type-conversion method
    //get a single parameter, and returns a corresponding object
    public String from(int a) {
        if (a == 1) {
            return FIRST;
        }
        return new String("a");
    }

    //aggregation method
    //it gets multiple parameters
    public int of(short first, short second) {
        return first + second;
    }

    //getInstance
    public static StaticFactoryMethod instance(Object object) {
        //create new instance by another 'Object'
        return new StaticFactoryMethod();
    }

    //newInstance
    public static StaticFactoryMethod create(Object object) {
        return new StaticFactoryMethod();
    }
    //and so on and so on....
}
