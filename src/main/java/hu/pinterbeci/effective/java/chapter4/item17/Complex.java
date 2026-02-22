package hu.pinterbeci.effective.java.chapter4.item17;

//ensure the class can not be extended
//do not provide methods that modify the object state
//make all fields final
//make all field private
//ensure exclusive access to any mutable components
//Immutable objects are inherently thread-safe; they require no synchronization.

import java.util.Objects;

//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//The major disadvantage of immutable classes is that they require a separate object for each distinct value.
public final class Complex {

    private final double re;
    private final double im;

    //provide commonly used 'cached' instances, frequently requested instances
    public static final Complex ZERO = new Complex(0, 0);
    public static final Complex ONE = new Complex(1, 0);
    public static final Complex I = new Complex(0, 1);

    //make static factories instead of public constructors
    private Complex(double re, double im) {
        this.re = re;
        this.im = im;
    }

    //static factory methods ensure the object-caching capacity, look here:
    public static Complex valueOf(double re, double im) {
        if (re == 0 && im == 0) return ZERO;
        if (re == 1 && im == 0) return ONE;
        if (re == 0 && im == 1) return I;

        return new Complex(re, im);
    }

    public double realPart() {
        return re;
    }

    public double imaginaryPart() {
        return im;
    }

    //immutable means when modify the object state, then create a new one from the original!!!!!!!!!!!!!!!!
    public Complex plus(Complex c) {
        return new Complex(re + c.realPart(), im + c.imaginaryPart());
    }

    public Complex minus(Complex c) {
        return new Complex(re - c.re, im - c.im);
    }

    public Complex times(Complex c) {
        return new Complex(re * c.re - im * c.im,
                re * c.im + im * c.re);
    }

    public Complex dividedBy(Complex c) {
        double tmp = c.re * c.re + c.im * c.im;
        return new Complex((re * c.re + im * c.im) / tmp,
                (im * c.re - re * c.im) / tmp);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Complex c))
            return false;

        return Double.compare(c.re, re) == 0
                && Double.compare(c.im, im) == 0;
    }

    @Override
    public int hashCode() {
        return 31 * Double.hashCode(re) + Double.hashCode(im);
    }

    @Override
    public String toString() {
        return "(" + re + " + " + im + "i)";
    }
}
