package shape.three.dimensional;

import exception.UserInputException;
import util.Constants;

public class Cylinder<T extends Number> implements ThreeDimensionalObject {
    private T r;
    private T h;

    public Cylinder(T r, T h) throws UserInputException {
        if(r.doubleValue() <= 0 || h.doubleValue() <= 0) {
            throw new UserInputException("Length of the edge must be grather than 0");
        }
        this.r = r;
        this.h = h;
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

    public T getH() {
        return h;
    }

    public void setH(T h) throws UserInputException {
        if(r.doubleValue() <= 0) {
            throw new UserInputException("Length of the edge must be grather than 0");
        }
        this.h = h;
    }

    @Override
    public String toString() {
        return "Cylinder{" +
                "r=" + r +
                ", h=" + h +
                '}';
    }



    @Override
    public double calculateScope() {
        return 4 * r.doubleValue() * Constants.PI + 2 * h.doubleValue();
    }

    @Override
    public double calculateVolume() {
        return 2 * r.doubleValue() * h.doubleValue() * Constants.PI;
    }

    @Override
    public double calculateArea() {
        return 2 * Constants.PI * r.doubleValue() * h.doubleValue() + 2 * Constants.PI * r.doubleValue() * r.doubleValue();
    }


}
