package org.derryfield.math;

public class Geometry {

    public static double calcVolSphere(double r) {
        double volSphere = Math.PI * 4 / 3 * Math.pow(r,3);
        return volSphere;
    }

    public static double calcSurfSphere(double r) {
        double surfSphere = Math.PI * 4 * Math.pow(r,2);
        return surfSphere;
    }

    public static void main(String[] args) {
    }
}
