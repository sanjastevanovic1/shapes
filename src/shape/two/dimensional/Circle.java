package shape.two.dimensional;

import exception.UserInputException;
import shape.ShapeType;
import util.Constants;

public class Circle<T extends Number> implements TwoDimensionalObject {
    private T r;
    private ShapeType type;
    public Circle(T r) throws UserInputException {
        if(r == null) {
            throw new UserInputException("Length of the edge cannot be null");
        }
        if(r.doubleValue() <= 0) {
            throw new UserInputException("Length of the edge must be grather than 0");
        }
        this.r = r;
    }


    public T getR() {
        return r;
    }

    public void setR(T r) throws UserInputException {
        if(r.doubleValue() <= 0) {
            throw new UserInputException("Length of the edge must be grather than 0");
        }
        this.r = r;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "r=" + r +
                '}';
    }


    @Override
    public double calculateScope() {
        return 2 * r.doubleValue() * Constants.PI;
    }

    @Override
    public double calculateArea() {
        return r.doubleValue() * r.doubleValue() * Constants.PI;
    }

}
