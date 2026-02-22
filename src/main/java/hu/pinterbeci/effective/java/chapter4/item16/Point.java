package hu.pinterbeci.effective.java.chapter4.item16;

//encapsulation
//use accessor methods, not public fields
//if a class is accessible outside its package, provide accessor methods
//if a class is package-private or is a private nested class, there is nothing inherently wrong with exposing its data fields
//never a good idea for a public class to expose fields directly

// Public class with exposed immutable fields - questionable
//In summary, public classes should never expose mutable fields
public class Point {
    private double x;
    private double y;

    //without a public field!!!!!!!!!!!!!!!!!!!!!
    //if I want to expose a public field, I need to mark it as 'final' and initialize it when creating a new instance
    //I need to prevent other classes from modifying it; if they could, the state of the instance would change
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }
}