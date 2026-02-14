package hu.pinterbeci.effective.java.chapter3.item13;

public class Yum {
    public Yum() {
    }

    //A better approach to object copying is to provide a copy constructor or copy factory.
    public Yum(Yum yum) {
    }

    //OR

    //a factory method
    public static Yum newInstance(Yum yum) {
        return new Yum();
    }
}
