/**
 * Circle.java
 * 
 * Class to represent Shapes of type Circle. A child of the Shape abstract class <br>
 *      Implements the calculateArea() and calculatePerimeter() methods <br>
 * @author cs230 staff (SK) based on an earlier version by Barry DeRoos  <br>    
 */

public class Circle extends Shape { 
    private double radius;

    /**
     *   Constructor
     *   @param r radius of the circle
     */
    public Circle(double r) {
        super("circle"); //calls constructor in Shape class
        this.radius = r;
    }

    /**
     * Constructor 
     * @param line formatted using serialize()
     * E.g. "circle 4.0" for a circle of radius 4.0
     */
    public Circle (String line) {
        super("circle");
        String[] result = line.split("\\s+");
        try{
            this.radius = Double.parseDouble(result[1]);
        }
        catch (NumberFormatException e) {
            System.out.println(e);
        }
        catch (NullPointerException e) {
            System.out.println(e);
        }
    }

    /**
     *  calculateArea method implemented for circle <br>
     *  @return area of the circle
     */
    public double calculateArea(){  
        return Math.PI * this.radius * this.radius;
    }

    /**
     * calculatePerimeter() (known as circumference) Implemented for circle <br>
     *  @return perimeter of the circle
     */
    public double calculatePerimeter() {
        return 2 * Math.PI * this.radius;
    }

    /**
     * toString()  Implemented for circle <br>
     *  @return a String representation of the Circle shape
     */
    public String toString() {
        String s = super.toString();
        s = s + " (radius: " + radius + ")" ;
        return s;
    }

    public String serialize() {
        return this.name + " " + this.radius;
    }

    /**
     * main() for testing
     * 
     */
    public static void main(String[] args) {
        System.out.println("**********  Testing Circle class  **********");

        Circle dot1 = new Circle(3);
        Circle dot2 = new Circle(5.8);
        Circle dot3 = new Circle(0);

 
    }
} //End Circle class
