/**
 * Rectangle.java

 * 
 * Class to represent Shapes of type Rectangle.  <br>
 * A child of the Shape abstract class <br>
 *      Implements the calculateArea() and calculatePerimeter() methods <br>
 *      Overrides the toString() method <br>
 * @author cs230 staff (SK) based on an earlier version by Barry DeRoos <br>
 */

public class Rectangle extends Shape {

    protected double length; //length of the rectangle
    protected double width;  //width of the rectangle

    /**
     * Constructor
     * @param len length of rectangle
     * @param wid width of rectangle
     */
    public Rectangle(double len, double wid) {
        super ("rectangle"); //call the constructor in the super class (Shape)
        this.length = len;
        this.width = wid;
    }

    /**
     * Constructor 
     * @param line formatted using serialize()
     * E.g. "rectangle 4.0 2.0" for a rectangle of length 4.0 and width 2.0
     */
    public Rectangle (String line) {
        super("rectangle");
        String[] tokens = line.split("\\s+");
        
        try{
            this.length = Double.parseDouble(tokens[1]);
            this.width = Double.parseDouble(tokens[2]);
        }
        catch (NumberFormatException e) {
            System.out.println(e);
        }
        catch (NullPointerException e) {
            System.out.println(e);
        }
    }

    /**
     * calculateArea() Implemented for rectangle
     *  @return area
     */
    public double calculateArea() {
        return this.length * this. width;
    }

    /**
     * calculatePerimeter() Implemented for rectangle
     *  @return perimeter
     */
    public double calculatePerimeter() {
        return 2 * (this.length + this. width);
    }

    /**
     * toString()  Implemented for rectangle shapes. Overrides the one in Shape <br>
     *  @return a String representation of the Rectangle shape
     */
    public String toString() {
        String s = super.toString();
        s = s + " (length: " + length + " width: " + width + ")" ;
        return s;
    }

    public String serialize() {
        return this.name + " " + this.length + " " + this.width;
    }

    //for testing
    public static void main(String[] args) {
        System.out.println("**********  Testing Rectangle class  **********");
        Rectangle r1 = new Rectangle(3, 4);
        Rectangle r2 = new Rectangle(2, 5.8);

    }
} //End Rectangle Class
