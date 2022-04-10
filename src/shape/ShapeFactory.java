package shape;

import exception.UserInputException;
import exception.fileException;
import shape.two.dimensional.Circle;
import shape.two.dimensional.Rectangle;
import shape.two.dimensional.Square;
import shape.two.dimensional.Triangle;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ShapeFactory {

    private Scanner input;
    private ArrayList<Shape> list;

    public ShapeFactory(String filePath) throws FileNotFoundException {
       input = new Scanner(new File(filePath));
       list = new ArrayList<>();
    }
    public ShapeFactory() {}

    public Triangle<Integer> makeTriangle(int a, int b, int c) throws UserInputException {
        return new Triangle<>(a, b, c);
    }
    public Circle<Integer> makeCircle(int a) throws UserInputException {
        return new Circle<>(a);
    }

    public Rectangle<Integer> makeRectangle(int a, int b) throws UserInputException {
        return new Rectangle<>(a, b);
    }

    public Square<Integer> makeSquare(int a) throws UserInputException {
        return new Square<>(a);
    }

    public boolean validate(Scanner input) throws FileNotFoundException {
        int counter = 0;

        ArrayList<Integer> integers = new ArrayList<>();
        boolean valid = true;
        StringBuilder sb = new StringBuilder();
        while(input.hasNextLine()) {
            counter = 0;
            integers.clear();
            String[] chars = input.nextLine().split("\\s+");
            for(int i = 1; i < chars.length; i++) {
                integers.add(Integer.parseInt(chars[i]));
            }
            System.out.println(integers);
            switch (chars[0]){
                case "t":
                    if(counter != 3) {
                        valid = false;
                    }
                    break;
                case "c":
                case "s":
                    if(counter != 1) {
                        valid = false;
                    }
                    break;
                case "r":
                    if(counter != 2) {
                        valid = false;
                    }
                    break;
            }
        }

        return valid;

    }
    public ArrayList<Shape> readObjects() throws UserInputException, FileNotFoundException {
        int counter = 0;
        if(this.validate(input)) {
            while (input.hasNextLine()) {
                counter++;
                try {
                    switch (input.next().charAt(0)) {
                        case 't':
                            list.add(this.makeTriangle(input.nextInt(), input.nextInt(), input.nextInt()));
                            break;
                        case 'r':
                            list.add(this.makeRectangle(input.nextInt(), input.nextInt()));
                            break;
                        case 's':
                            list.add(this.makeSquare(input.nextInt()));
                            break;
                        case 'c':
                            list.add(this.makeCircle(input.nextInt()));
                            break;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Warning: Not enough parameters on line " + counter + " to create shape");
                }
            }
        }
        input.close();
        return list;
    }

    public ArrayList<Shape> readSpecificShape(ShapeType type) throws  UserInputException, fileException {
        int counter = 0;

        while(input.hasNextLine()) {
            counter++;
            try {
                switch (type) {
                    case Triangle:
                        if (input.next().charAt(0) == 't') {
                            list.add(this.makeTriangle(input.nextInt(), input.nextInt(), input.nextInt()));
                        }
                        break;
                    case Rectangle:
                        if (input.next().charAt(0) == 'r') {
                            list.add(this.makeRectangle(input.nextInt(), input.nextInt()));
                        }
                        break;
                    case Square:
                        if (input.next().charAt(0) == 's') {
                            list.add(this.makeSquare(input.nextInt()));
                            break;
                        }
                        break;
                    case Circle:
                        if (input.next().charAt(0) == 'C') {
                            list.add(this.makeCircle(input.nextInt()));
                        }
                        break;
                    default:
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Not enough parameters " + counter + " to create shape");
            }
        }
        input.close();
        return list;
    }
}