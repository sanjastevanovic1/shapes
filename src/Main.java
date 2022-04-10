import exception.NotFoundException;
import exception.UserInputException;
import exception.fileException;
import shape.Shape;
import shape.ShapeFactory;
import shape.two.dimensional.TwoDimensionalObject;
import shape.three.dimensional.Cube;
import shape.three.dimensional.Cuboid;
import shape.three.dimensional.Cylinder;
import shape.two.dimensional.Circle;
import shape.two.dimensional.Rectangle;
import shape.two.dimensional.Triangle;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import util.MethodUsedIndependently;


public class Main {

    //


    public static void main(String[] args) throws FileNotFoundException, UserInputException, fileException {
        List<Exception> exceptions = new ArrayList<>();
        Circle<Integer> circle1 = new Circle<>(3);
        Rectangle<Integer> rectangle1 = new Rectangle<>(3, 5);
        Triangle<Integer> triangle1 = new Triangle<>(4, 5, 6);
        Cube<Integer> cube1 = new Cube<>(7);
        Cuboid<Integer> cuboid1 = new Cuboid<>(3, 2, 5);
        Cylinder<Integer> cylinder1 = new Cylinder<>(2, 4);

        Comparator<Shape> scopeComparator1 = Comparator.comparing(Shape::calculateScope);

        ///null.method().
        System.out.println(circle1);
        System.out.println(rectangle1);
        System.out.println(triangle1);
        System.out.println(cube1);
        System.out.println(cuboid1);
        System.out.println(cylinder1);

        ArrayList<TwoDimensionalObject> list1 = new ArrayList<>();
        list1.add(circle1);
        list1.add(rectangle1);
        list1.add(triangle1);

        ArrayList<Shape> listOfShapes = new ArrayList<>();

        listOfShapes.add(cylinder1);
        listOfShapes.add(circle1);
        listOfShapes.add(rectangle1);
        listOfShapes.add(cuboid1);
        System.out.println("Unsorted:");
        for (Shape listOfShape : listOfShapes) {
            System.out.println(listOfShape.calculateScope());
        }
        // Sortiranje stream
         listOfShapes = (ArrayList<Shape>) listOfShapes.stream().sorted(scopeComparator1).collect(Collectors.toList());
       // sortList(listOfShapes);
        System.out.println("Sorted:");
        for (Shape listOfShape : listOfShapes) {
            System.out.println(listOfShape.calculateScope());
        }

        Map<Shape, Double> map = new HashMap<>();

        map.put(circle1, circle1.calculateScope());
        map.put(cuboid1, cuboid1.calculateScope());
        map.put(rectangle1, rectangle1.calculateScope());
        map.put(cylinder1, cylinder1.calculateScope());


        //filtriraj listu i uzmi sve elemente koji su manji od 20 i ubaci u novu listu
        List<Shape> newList = listOfShapes.stream().filter(shape -> shape.calculateScope() < 20).toList();
        //nadji u listi prvi veci od 20


        Optional<Shape> oneShape = newList.stream().filter(shape -> shape.calculateScope() > 20).findFirst();
        if(oneShape.isPresent()) {
            System.out.println(oneShape);
        } else {
            exceptions.add(new NotFoundException("Not found element"));
        }
//
//        try {
//            int a = 12/0;
//        } catch (Exception e) {
//            exceptions.add(new MyException("Cannot be divided with 0", e));
//        }

        //Najveci scope u listi
        double maxScope = listOfShapes.stream().mapToDouble(Shape::calculateScope).max().orElse(0);
        System.out.println("Max: " + maxScope);
        //Od liste figura napraviti listu scope-ova
        List<Double> listOfScopes = listOfShapes.stream().map(Shape::calculateScope).toList();

        System.out.println("List of Scopes: " + listOfScopes);

        //Od mape napraviti listu
        List<Shape> mapToListKeys = map.keySet().stream().toList();
        List<Double> mapToListValues = map.values().stream().toList();
        System.out.println("mapToListKeys: " + mapToListKeys);
        System.out.println("mapToListValues: " + mapToListValues);


        Map<Shape, Double> listToMap = listOfShapes.stream().collect(Collectors.toMap(value -> value, Shape::calculateScope));
        System.out.println("ListToMap:" + listToMap);
        // intrange.stream suma brojeva sekvencijalno i paralelno
//
//        IntStream.range(0, 1000000).sum();
//        IntStream.range(0, 1000000).parallel().sum();

        //koristi intStrim 0 - 50  i sumiraj samo parne sekvencijalno

        System.out.println("Sum of first 50: " + IntStream.range(0, 50).filter(value -> value % 2 == 0).sum());

        // faktoriel

        System.out.println("Factoriel: " + MethodUsedIndependently.factorielStream(5));


        System.out.println("Binary:" + MethodUsedIndependently.binarySearch(listOfShapes, 201488, 0, listOfShapes.size()));

        System.out.println(listOfShapes);
        System.out.println("Total area of list1: " + MethodUsedIndependently.areaOfTwoDiensionalShapeList(list1));
        System.out.println("Total scope of listOfShapes: " + MethodUsedIndependently.scopeOfShapeList(listOfShapes));




        System.out.println("Map: " + map);
        for (Map.Entry<Shape, Double> entry : map.entrySet()) {
            System.out.println("Shape: " + entry.getValue().toString() + ", scope: " + entry.getKey());
        }

        System.out.println("Total scope of mapOfShapes: " + MethodUsedIndependently.scopeOfShapeMap(map));

        Map<Double, Shape> map1 = new TreeMap<>();
        map1.put(circle1.calculateScope(), circle1);
        map1.put(cuboid1.calculateScope(), cuboid1);
        map1.put(rectangle1.calculateScope(), rectangle1);
        map1.put(cylinder1.calculateScope(), cylinder1);

        for (Map.Entry<Double, Shape> entry : map1.entrySet()) {
            System.out.println("Shape: " + entry.getValue().toString() + ", scope: " + entry.getKey());
        }

        Set<Shape> set = new HashSet<>();

        for (Shape listOfShape : listOfShapes) {
            set.add(listOfShape);
        }
        System.out.println("\nSet:");
        Iterator<Shape> it = set.iterator();
        while(it.hasNext()) {
            System.out.println(it.next().toString());
        }

        TreeSet<Shape> treeSet = new TreeSet<>(scopeComparator1);
        for (Shape listOfShape : listOfShapes) {
            System.out.println("List element" + listOfShape);
            treeSet.add(listOfShape);
        }

        Iterator<Shape> it1 = treeSet.iterator();
        System.out.println("\nTreeSet:");
        while(it1.hasNext()) {
            Shape el = it1.next();
            System.out.println(el.toString() + " - scope: " + el.calculateScope() );
        }

        ShapeFactory factory = new ShapeFactory("resource/input.txt");
        ArrayList<Shape> fileShapes = factory.readObjects();
        System.out.println(fileShapes);

        factory.validate(new Scanner(new File("resource/input.txt")));
        //
//        try (Scanner input1 = new Scanner(new File("resource/input.txt"))) {
//            System.out.println(input1);
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            System.out.println("konacno zavrsih!");
//        }
//
//
//        System.out.println(list2);
//
//        if(!exceptions.isEmpty()) {
//            exceptions.forEach(exception -> {
//                exception.printStackTrace();
//            });
//        }
//
//
//
//
//
//        // Exceptions
//        Circle<Double> krug1 = new Circle<>(1.1);
//        try{
//            Circle<Double> krug2 = new Circle<>(-3.3);
//        } catch (UserInputException e) {
//            e.printStackTrace();
//        }
//        try{
//            Circle<Double> krug3 = new Circle<>(null);
//            Integer a = 2/0;
//        }  catch (UserInputException e) {
//            e.printStackTrace();
//        } catch (ArithmeticException e) {
//            e.printStackTrace();
//        } catch(Exception e) {
//            e.printStackTrace();
//        }
//
//
//        System.out.println(getResultOfFunnyMethod());
//    }
//
//    private static boolean getResultOfFunnyMethod() {
//        try {
//            return true;
//        } finally {
//            return false;
//        }
    }
}
