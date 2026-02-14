package hu.pinterbeci.effective.java.chapter3.item11;

import java.util.Objects;

public final class PhoneNumber {
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
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof PhoneNumber pn))
            return false;
        return pn.lineNum == lineNum && pn.prefix == prefix
                && pn.areaCode == areaCode;
    }

    //hashCode contract:
    //1. when the hashCode method is invoked on an object repeatedly during an execution of an application
    //  it must consistently return the same value.

    //2. if two objects are equal according the equals method, then calling the hashCode on two objects
    // must produce the same integer

    //3. if two objects are unequal according the equals method, it is not required to call the hashCode method
    //.........................................................................................................

    // The worst possible legal hashCode implementation - never use!
    /*@Override
    public int hashCode() {
        return 42;
    }*/

    //a perfect hashCode, but there are lots of boilerplate code
    /*
    @Override
    public int hashCode() {
        //if the field is primitive use the BoxedType.hashCode(primitiveValue) for generates hashCode
        //if the field is a type reference then use this type hashCode method recursively
        //if the field is a collection or array then calculate these elements hashCode one by one

        int result = Short.hashCode(areaCode);
        result = 31 * result + Short.hashCode(prefix);
        result = 31 * result + Short.hashCode(lineNum);
        return result;
    }
    */

    //better solution for use Objects.hashCode(varargs ......)
    // One-line hashCode method - mediocre performance
    @Override
    public int hashCode() {
        return Objects.hash(lineNum, prefix, areaCode);
    }
}