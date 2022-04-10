package shape.three.dimensional;

import exception.UserInputException;

public class Cuboid<T extends Number> implements ThreeDimensionalObject {
    private T a;
    private T b;
    private T c;

    public Cuboid(T a, T b, T c) throws UserInputException {
        if(a.doubleValue() <= 0 || b.doubleValue() <= 0 || c.doubleValue() <= 0) {
            throw new UserInputException("Length of edge must be grather than 0");
        }
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public T getA() {
        return a;
    }

    public void setA(T a) throws UserInputException {
        if(a.doubleValue() <= 0) {
            throw new UserInputException("Length of edge must be grather than 0");
        }
        this.a = a;
    }

    public T getB()  {

        return b;
    }

    public void setB(T b) throws UserInputException{
        if(b.doubleValue() <= 0) {
            throw new UserInputException("Length of edge must be grather than 0");
        }
        this.b = b;
    }

    public T getC() {
        return c;
    }

    public void setC(T c) throws UserInputException {
        if(c.doubleValue() <= 0) {
            throw new UserInputException("Length of edge must be grather than 0");
        }
        this.c = c;
    }

    @Override
    public String toString() {
        return "Cuboid{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }

    @Override
    public double calculateScope() {
        return 4 * (a.doubleValue() + b.doubleValue() + c.doubleValue());
    }

    @Override
    public double calculateVolume() {
        return a.doubleValue() * b.doubleValue() * c.doubleValue();
    }

    @Override
    public double calculateArea() {
        return 2 * (a.doubleValue() * (b.doubleValue() + c.doubleValue())  + b.doubleValue() * c.doubleValue());
    }
}
