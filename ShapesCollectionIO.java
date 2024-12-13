import java.util.*;
import java.io.*;

/**
 * Uses an array to maintain a collection of Shapes.
 * Uses File I/O
 *
 * @author ()
 * @version ()
 */
public class ShapesCollectionIO
{
    private final int CAPACITY = 10;

    private Shape[] shapes;
    private int counter;

    public ShapesCollectionIO() {
        shapes = new Shape[CAPACITY];
        counter = 0;
    }

    /**
     * getCounter()
     * @return int counter the number of Shape objects in the collection
     **/
    public int getCounter(){
        return counter;
    }

    /**
     * toString
     * returns a string represenation of this collection of shapes
     * @return String a string representation of this collection
     **/
    public  String toString(){
        String s = ".......................\nThis collection contains " +
            counter + " shape";

        s += (counter != 1) ? "s": ""; // add an "s" to "shape", if more than one shapes
        s += (counter == 0) ? "." + "\n": ":" + "\n"; // add . if 0 shapes, else :

        for (int i=0; i<counter; i++) {
            s = s + ("   " + shapes[i] + "\n");
        }
        return s;
    }

    /**
     * adds the input Shape to the collection
     * Doubles the array size when needed
     *
     * @param Shape The shape to be added to the collection
     *
     * */
    public void addShape(Shape s) {
        if (counter == shapes.length) { //there is no more space in the array
            doubleArray();
        }
        //now you can safely add the new object
        shapes[counter] = s;
        counter++;
    }

    /**
     * Writes all Shape objects in the collection to the output file
     * 
     * @param fileName the name of the file to be written to
     */
    public void writeDataToFile(String fileName) {
        try {
            PrintWriter writer = new PrintWriter (new File(fileName));
            for (int i = 0; i < counter; i++) {
                writer.println(shapes[i].serialize());
            }
            writer.close();
        }catch (IOException e) {
            System.out.println(e); // Handle file-not-found
        }
    }

    /**
     * Reads data from an input file and creates the appropriate Shape objects, adding them to the collection
     */
    public void readDataFromFile(String fileName) {
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNext()) {
                String shapeName = scanner.next();
                Shape shape = null;
                try {
                    switch(shapeName.toLowerCase()) {
                        case "rectangle":
                            double length = scanner.nextDouble();
                            double width = scanner.nextDouble();
                            shape = new Rectangle(length, width);
                            break;
                        case "triangle":
                            double side1 = scanner.nextDouble();
                            double side2 = scanner.nextDouble();
                            double side3 = scanner.nextDouble();
                            shape = new Triangle(side1, side2, side3);
                            break;
                        case "circle":
                            double radius = scanner.nextDouble();
                            shape = new Circle(radius);
                            break;
                    }
                    if (shape != null) {
                        this.addShape(shape);
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    //helper if any of the arrays run out of space
    private void doubleArray() {
        Shape[] tempArray = new Shape[2*shapes.length];

        for (int i= 0; i<shapes.length; i++) {
            tempArray[i]=shapes[i];
        }
        shapes = tempArray;
    }

    /**
     * Basic testing
     */
    public static void main (String[] args) { 
        ShapesCollectionIO tester = new ShapesCollectionIO();
        tester.addShape(new Rectangle(3, 5));
        tester.addShape(new Triangle(3, 4, 5));
        tester.addShape(new Circle(3));

        for (int i = 0; i < tester.getCounter(); i++) {
            System.out.println(tester.shapes[i].serialize());
        }

        tester.writeDataToFile("output.txt");

        ShapesCollectionIO inputTester = new ShapesCollectionIO();
        inputTester.readDataFromFile("input.txt");
        System.out.println(inputTester.toString());
        
        // input2.txt returns java.util.InputMismatchException before error handling
        ShapesCollectionIO input2Tester = new ShapesCollectionIO();
        input2Tester.readDataFromFile("input2.txt");
        System.out.println(input2Tester.toString());
        
        ShapesCollectionIO input3Tester = new ShapesCollectionIO();
        input3Tester.readDataFromFile("input3.txt");
        System.out.println(input3Tester.toString());
    }
}

