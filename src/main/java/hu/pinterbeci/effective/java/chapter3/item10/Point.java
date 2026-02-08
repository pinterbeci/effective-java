package hu.pinterbeci.effective.java.chapter3.item10;

public class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Point)) return false;
        Point p = (Point) o;
        return p.x == x && p.y == y;
    }

    public boolean violateLiskovEquals(Object o) {
        //does not violate the LISKOV-SUBSTITUTION-PRINCIPLE:
        //if (o == null || o.getClass() != getClass()) DO NOT DO THIS!!!!!!!!!!
        /*
        The Liskov substitution principle says that any important property of a type
        should also hold for all its subtypes so that any method written for the type
        should work equally well on its subtypes
         */

        if (o == null || o.getClass() != getClass())
            return false;
        Point p = (Point) o;
        return p.x == x && p.y == y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
