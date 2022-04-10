package util;

import shape.Shape;
import shape.three.dimensional.ThreeDimensionalObject;
import shape.two.dimensional.TwoDimensionalObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.stream.IntStream;

public class MethodUsedIndependently {
    public static double scopeOfShapeList(ArrayList<Shape> list) {
        double scope = 0;
        for (int i = 0; i < list.size(); i++) {
            scope += list.get(i).calculateScope();
        }
        return scope;
    }

    public static double areaOfTwoDiensionalShapeList(ArrayList<TwoDimensionalObject> list) {
        double area = 0;
        for (int i = 0; i < list.size(); i++) {
            area += list.get(i).calculateArea();
        }
        return area;
    }

    public static double volumeOfThreeDimensionalShapeList(ArrayList<ThreeDimensionalObject> list) {
        double volume = 0;
        for (int i = 0; i < list.size(); i++) {
            volume += list.get(i).calculateVolume();
        }

        return volume;
    }


    public static double scopeOfShapeMap(Map<Shape, Double> map) {
        double scope = 0;

        for (Double value : map.values()) {
            scope += value;
        }

        return scope;
    }

    public static void sortList(ArrayList<Shape> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = i; j < list.size(); j++) {
                if (list.get(i).calculateScope() > list.get(j).calculateScope()) {
                    Collections.swap(list, i, j);
                }
            }
        }
    }

    public static Shape binarySearch(ArrayList<Shape> list, double scope, int start, int end) {
        int middle = (int) ((start + end) / 2);
        Shape sh = null;

        if (list.get(middle).calculateScope() == scope) {
            return list.get(middle);
        }
        if (start == end) {
            return null;
        }
        if (list.get(middle).calculateScope() < scope) {
            sh = binarySearch(list, scope, middle + 1, list.size() - 1);
        } else if (list.get(middle).calculateScope() > scope) {
            sh = binarySearch(list, scope, 0, middle - 1);
        }
        return sh;
    }


    public static int factoriel(int n) {

        int f = 1;
        for(int i = 0; i <= n; i++) {
            f *= i;
        }
        return f;
    }

    public static int factorielStream(int n) {

        int f = IntStream.rangeClosed(1, n).reduce((value1, value2) -> value1 * value2).orElse(1);

        return f;
    }

}
