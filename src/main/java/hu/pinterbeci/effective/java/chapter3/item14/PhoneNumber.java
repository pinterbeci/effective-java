package hu.pinterbeci.effective.java.chapter3.item14;

import java.util.Comparator;
import java.util.Objects;

//IMPORTANT!!!!!!!!!!!!!!!!!!!!!
// Therefore, the same caveat
//applies: there is no way to extend an instantiable class with a new value
//component while preserving the compareTo contract, unless you are willing to
//forgo the benefits of object-oriented abstraction (Item 10). The same workaround
//applies, too. If you want to add a value component to a class that implements
//Comparable, don’t extend it; write an unrelated class containing an instance
//of the first class. Then provide a “view” method that returns the contained
//instance. This frees you to implement whatever compareTo method you like
//on the containing class, while allowing its client to view an instance of the
//containing class as an instance of the contained class when needed.
public final class PhoneNumber implements Comparator<PhoneNumber> {
    private final short areaCode, prefix, lineNum;

    public PhoneNumber(int areaCode, int prefix, int lineNum) {
        this.areaCode = rangeCheck(areaCode, 999, "area code");
        this.prefix = rangeCheck(prefix, 999, "prefix");
        this.lineNum = rangeCheck(lineNum, 9999, "line num");
    }

    private static short rangeCheck(int val, int max, String arg) {
        if (val < 0 || val > max)
            throw new IllegalArgumentException(arg + ": " + val);
        return (short) val;
    }

    @Override
    public int compare(PhoneNumber o1, PhoneNumber o2) {
        return COMPARATOR.compare(o1, o2);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof PhoneNumber pn))
            return false;
        return pn.lineNum == lineNum && pn.prefix == prefix
                && pn.areaCode == areaCode;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lineNum, prefix, areaCode);
    }

    // Comparable with comparator construction methods
    //avoid the use of the < and > operators
    private static final Comparator<PhoneNumber> COMPARATOR =
            Comparator.comparingInt((PhoneNumber pn) -> pn.areaCode)
                    .thenComparingInt(pn -> pn.prefix)
                    .thenComparingInt(pn -> pn.lineNum);
}