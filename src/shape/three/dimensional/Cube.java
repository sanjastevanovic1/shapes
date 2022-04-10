package shape.three.dimensional;

import exception.UserInputException;

public class Cube<T extends Number> implements ThreeDimensionalObject {

    private T a;

    public Cube(T a) throws UserInputException {
        if( a.doubleValue() <= 0 ) {
            throw new UserInputException("Length of the edge must be grather than 0");
        }
        this.a = a;
    }

    public T getA() {
        return a;
    }

    public void setA(T a) throws UserInputException {
        if( a.doubleValue() <= 0 ) {
            throw new UserInputException("Length of the edge must be grather than 0");
        }
        this.a = a;
    }

    @Override
    public String toString() {
        return "Cube{" +
                "a=" + a +
                '}';
    }

    @Override
    public double calculateScope() {
        return a.doubleValue() * 12;
    }

    @Override
    public double calculateVolume() {
        return Math.pow(a.doubleValue(), 3);
    }

    @Override
    public double calculateArea() {
        return 6 * a.doubleValue() * a.doubleValue();
    }

}
