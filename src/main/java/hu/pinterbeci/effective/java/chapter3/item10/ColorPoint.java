package hu.pinterbeci.effective.java.chapter3.item10;

public class ColorPoint extends Point {
    private final Color color;

    public ColorPoint(int x, int y, Color color) {
        super(x, y);
        this.color = color;
    }


    //symmetry: a.equal(b) is true AND b.equal(a) is true
    //consistency: a.equal(b) is true AND b.equal(c) is true AND a.equal(c) is true
/*
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof ColorPoint)) return false;
        ColorPoint cp = (ColorPoint) object;
        return color.equals(cp.color) && point.equals(cp.point);
    }
*/

    // Broken - violates symmetry!
    public boolean violatesSymmetryEquals(Object o) {
        if (!(o instanceof ColorPoint))
            return false;
        //brokes the violates of symmetry
        return super.equals(o) && ((ColorPoint) o).color == color;
    }

    // Broken - violates transitivity!

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Point))
            return false;
        // If o is a normal Point, do a color-blind comparison
        if (!(o instanceof ColorPoint))
            return o.equals(this);
        // o is a ColorPoint; do a full comparison
        return super.equals(o) && ((ColorPoint) o).color == color;
    }

    public Color getColor() {
        return color;
    }
}
