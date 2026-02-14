package hu.pinterbeci.effective.java.chapter3.item13;

public class Facility implements Cloneable {

    private String department;

    public Facility(String department) {
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public Facility clone() {
        //be aware when copying references, static variable, collections or arrays or maps
        try {
            Facility clone = (Facility) super.clone();
            clone.department = department;
            return clone;
        } catch (CloneNotSupportedException exception) {
            throw new AssertionError();
        }
    }

    @Override
    public int hashCode() {
        int result = this.department.hashCode();
        result *= 31;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof Facility facility)) return false;
        return facility.department.equals(this.department);
    }
}
