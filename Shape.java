import java.text.DecimalFormat;  //used to format output
/** 
 * Abstract class Shape  <br>
 * Defines the Abstract Class Shape, 
 * which is at the top of the Shapes hierarchy
 * <p>
 * Methods: <br>
 * Abstract methods: calculateArea() and calculatePerimeter()
 *                   to be implemented in inheriting classes  <br>
 * final method compareTo() - compare two shapes by area  <br>
 * final method toString() - provides a string representation 
 *                           of a shape <br>
 * Property: name - protected property name of this shape <br>

 * @author cs230 staff. (SK)
 * Based on older version started by Barry DeRoos
 * @version Fall 2019 updated 2021.02.25
 */

public abstract class Shape {
    protected static double minDiff = 0.01;

    protected String name;  // like "Circle", or "Triangle"

    /**
     * Constructor
     *    
     * @param shapeName  the name of the shape to be created
     */
    public Shape(String shapeName) {
        this.name = shapeName;
    }

    /**
     *  abstract method calculateArea()  <br>
     *  To be implemented in the inheriting classes
     *
     *  @return the area of the shape.
     */
    abstract public double calculateArea();

    /**
     * abstract method calculatePerimeter()  <br>
     * To be implemented in the inheriting classes
     *
     * @return the perimeter of the shape
     */
    abstract public double calculatePerimeter();

    /**
     *  Method final compareTo()  <br>
     *  Compares the invoking and the input shapes by area  <br>
     *  
     *  @param otherShape  Shape to be compared to this shape
     *  @return int   0 if the two shapes have the same area,  <br>
     *                1 if the invoking shape's area is greatet <br>
     *                -1 if the invoking shape's area is smaller <br>
     */
    final public int compareTo(Shape other) {
        //remember how we compare floating numbers for equality!
        if ((Math.abs(this.calculateArea() - other.calculateArea())) <= minDiff) 
            return 0;
            
        if (this.calculateArea() - other.calculateArea() > minDiff) 
            return 1;
            
        return -1;

        // alternatively,
        //  int result = (this.calculateArea() - otherShape.calculateArea() <= minDiff) ? 0 : 
        //                ((this.calculateArea() - otherShape.calculateArea() > minDiff) ? 1 : -1);
        // return result;

        // ok, one last (even shorter) version. Turns out you don't
        // need a variable.  Can simply put it all in a return statement
        // like this:
        // return (this.calculateArea() - otherShape.calculateArea() <= minDiff) ? 0 :                   
        //                ((this.calculateArea() - otherShape.calculateArea() > minDiff) ? 1 : -1); 
    }

    /**
     *  Method  toString()
     *  
     *  @return a string representation of this Shape
     */
    public String toString() {
        // the "0.###" string specifies that numbers will be printed
        // to the 3rd decimal place
        DecimalFormat fmt = new DecimalFormat("0.###");
        
        return this.name + " - area: " + fmt.format(calculateArea()) +
               " perimeter: " + fmt.format(calculatePerimeter());
    }
    
    abstract public String serialize();
} // End Abstract Shape Class

