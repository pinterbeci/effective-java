package hu.pinterbeci.effective.java.chapter3.item10;

import java.time.LocalDate;

public class ClassWithHighQualityEquals {
    private final LocalDate localDate;

    public ClassWithHighQualityEquals(LocalDate localDate) {
        this.localDate = localDate;
    }

    @Override
    public boolean equals(Object object) {
        //1. Use the == operator to check if the argument is a reference to this object.
        if (this == object) return true;

        //pattern variable, so awesome btw

        //2. Use the instanceof operator to check if the argument has the correct type.
        if (!(object instanceof ClassWithHighQualityEquals classWithHighQualityEquals)) return false;

        //3. Cast the argument to the correct type. (pattern variable help for this cast :) )
        //4. For each “significant” field in the class, check if that field of the
        //argument matches the corresponding field of this object.

        //use '==' for primitive types, and Object.equals(instance1, instance2);
        //sort of the fields equality check:
        //fields that are more likely to differ, less expensive to compare, or, ideally, both
        return classWithHighQualityEquals.localDate.equals(this.localDate);

        //Always override hashCode when you override equals!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    }

    /*
    // Broken - parameter type must be Object!!!!!!!!!!!!!!!!!!!!!!!
        public boolean equals(ClassWithHighQualityEquals o) {
        ...
        }
     */
}
