package hu.pinterbeci.effective.java.chapter3.item10;

public class SmellPoint extends Point {
    private final Color color;

    public SmellPoint(int x, int y, Color color) {
        super(x, y);
        this.color = color;
    }

    // Broken - violates transitivity!
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Point))
            return false;
        // If o is a normal Point, do a color-blind comparison
        if (!(o instanceof SmellPoint))
            return o.equals(this);
        // o is a SmellPoint; do a full comparison
        return super.equals(o) && ((SmellPoint) o).color == color;
    }

}
