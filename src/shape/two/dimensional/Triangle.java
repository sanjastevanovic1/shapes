package shape.two.dimensional;

import exception.UserInputException;

public class Triangle<T extends Number> implements TwoDimensionalObject {

    public T a;
    public T b;
    public T c;

    public Triangle(T a, T b, T c) throws UserInputException {
        if(a.doubleValue() <= 0 || b.doubleValue() <= 0 || c.doubleValue() <= 0) {
            throw new UserInputException("Length of the edge must be grather than 0");
        }
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Triangle() {

    }

    public T getA() {
        return a;
    }

    public void setA(T a) throws UserInputException {
        if(a.doubleValue() <= 0) {
            throw new UserInputException("Length of the edge must be grather than 0");
        }
        this.a = a;
    }

    public T getB() {
        return b;
    }

    public void setB(T b) throws UserInputException {
        if(c.doubleValue() <= 0) {
            throw new UserInputException("Length of the edge must be grather than 0");
        }
        this.b = b;
    }

    public T getC() {
        return c;
    }

    public void setC(T c) throws UserInputException {
        if(c.doubleValue() <= 0) {
            throw new UserInputException("Length of the edge must be grather than 0");
        }
        this.c = c;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }



    @Override
    public double calculateScope() {
        return a.doubleValue() + b.doubleValue() + c.doubleValue();
    }

    @Override
    public double calculateArea() {
        double s = (a.doubleValue() + b.doubleValue() + c.doubleValue())/2;
        return Math.sqrt(s * (s - a.doubleValue()) * (s - b.doubleValue()) * (s - c.doubleValue()));
    }
}
