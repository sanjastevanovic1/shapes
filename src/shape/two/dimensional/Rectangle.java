package shape.two.dimensional;
import exception.UserInputException;

public class Rectangle<T extends Number> implements TwoDimensionalObject {

    private T a;
    private T b;

    public Rectangle(T a, T b) throws UserInputException {
        if(a.doubleValue() <= 0 || b.doubleValue() <= 0) {
            throw new UserInputException("Length of the edge must be grather than 0");
        }
        this.a = a;
        this.b = b;
    }

    public Rectangle() {

    }

    public T getA() {
        return a;
    }

    public T getB() {
        return b;
    }

    public void setA(T a) throws UserInputException {
        if(a.doubleValue() <= 0) {
            throw new UserInputException("Length of the edge must be grather than 0");
        }
        this.a = a;
    }

    public void setB(T b) throws UserInputException {
        if(b.doubleValue() <= 0) {
            throw new UserInputException("Length of the edge must be grather than 0");
        }
        this.b = b;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }

    @Override
    public double calculateScope() {
        return 2 * a.doubleValue() + 2 * b.doubleValue();
    }

    @Override
    public double calculateArea() {
        return a.doubleValue() * b.doubleValue();
    }


}
