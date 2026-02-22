package hu.pinterbeci.effective.java.chapter4.item22;

//avoid the Constant interface antipattern
//an interface that stores constants
//expose this value to the API, please don't do that

//or use enums or constant utility classes, but don't use constant interfaces
public class PhysicalConstants {
    private PhysicalConstants() {
    }

    public static final double AVOGADROS_NUMBER = 6.022_140_857e23;
    public static final double BOLTZMANN_CONST = 1.380_648_52e-23;
    public static final double ELECTRON_MASS = 9.109_383_56e-31;
}
