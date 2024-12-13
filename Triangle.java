/**
 * FILE NAME:Triangle.java
 * WHO: Copyright 1999 by J. Barry DeRoos
 * Edited by Stella K. 
 * WHEN: Edits in Feb 2008
 * WHAT: Class with Triangle properties.
 * Inherits from Shape class
 * Implements the area() method
 */
public class Triangle extends Shape {

    protected double a; //but private would also work
    protected double b;
    protected double c;

    /**
     * Constructor
     * @param side1 The length of one side of the triangle
     * @param side2 The length of the second side of the triangle
     * @param side3 The length of the third side of the triangle
     */
    public Triangle(double side1, double side2, double side3) {
        super ("triangle"); //call the constructor in the super class (Shape)
        this.a = side1;
        this.b = side2;
        this.c = side3;
    }
    
    /**
     * Constructor 
     * @param line formatted using serialize()
     * E.g. "triangle 3.0 4.0 5.0" for a triangle of sides 3.0 4.0 5.0
     */
    public Triangle (String line) {
        super("triangle");
        String[] result = line.split("\\s+");
        try{
            this.a = Double.parseDouble(result[1]);
            this.b = Double.parseDouble(result[2]);
            this.c = Double.parseDouble(result[3]);
        }
        catch (NumberFormatException e) {
            System.out.println(e);
            //throw new NumberFormatException("The input has not been formatted correctly; line ignored");
        }
        catch (NullPointerException e) {
            System.out.println(e);
        }
    }

    /**
     * area() Implemented for triangle, according to Heron's formula:
     * S = 1/4 * sqrt( (a^2 + b^2 + c^2)^2  - 2*(a^4 + b^4 + c^4))
     *  @return area
     */
    public double calculateArea() {
        double temp1 = a*a + b*b + c*c;
        temp1 = temp1*temp1;

        double temp2 = Math.pow(a,4) + Math.pow(b,4) + Math.pow(c,4);
        return 1.0/4 * Math.sqrt(temp1 - 2*temp2);
    }

    /**
     * perimeter() Implemented for triangle
     *  @return perimeter
     */
    public double calculatePerimeter() {
        return this.a + this.b + this.c;
    }

    public String toString() {
        String s = super.toString();
        s = s + " (sides: " + a + ", " + b + ", " + c + ")" ;
        return s;
    }
    
    public String serialize() {
        return name + " " + a + " " + b + " " + c;
    }

    public static void main(String[] args) {
        Triangle t1 = new Triangle(3, 4, 5);
        Triangle t2 = new Triangle(3, 5, 5.8);
        Triangle t3 = new Triangle(1, 1, 1);

        System.out.println("t1 area = " + t1.calculateArea());
        System.out.println("t2 area = " + t2.calculateArea());
        System.out.println("t3 area = " + t3.calculateArea());

        System.out.println("t1 perimeter = " + t1.calculatePerimeter());
        System.out.println("t2 perimeter = " + t2.calculatePerimeter());
        System.out.println("t3 perimeter = " + t3.calculatePerimeter());
        
        System.out.println(t1);
    }
} //End Triangle Class
