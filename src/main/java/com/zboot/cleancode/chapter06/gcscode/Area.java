package com.zboot.cleancode.chapter06.gcscode;

public class Area {
    public final double PI = 3.14;

    public double getArea(Object shape) {
        if (shape instanceof Circle) {
            return 1D;
        }
        if (shape instanceof Square) {
            return 3D;
        }
        return 0D;
    }
}
