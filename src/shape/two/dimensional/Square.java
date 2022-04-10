package shape.two.dimensional;

import exception.UserInputException;

public class Square<T extends Number> implements TwoDimensionalObject {

    public T a;

    public Square(T a) throws UserInputException {
        if( a.doubleValue() <= 0 ) {
            throw new UserInputException("Length of the edge must be grather than 0");
        }
        this.a = a;
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

    @Override
    public String toString() {
        return "Square{" +
                "a=" + a +
                '}';
    }

    @Override
    public double calculateScope() {
        return 4 * a.doubleValue();
    }

    @Override
    public double calculateArea() {
        return a.doubleValue() * a.doubleValue();
    }
}
