[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/7NOls9h8)
# CS230X-lab5-F24
# Exceptions and IO: Shapes (again!)

## Task 1: Shapes Collection with Files (IO)

* Open the `Shape` class and notice a new method called `serialize()`. Then see how it is defined in some of the sub-classes, like Triangle, Circle or Rectangle. You can think of this method as an alternative -less verbose- to the familiar `toString() `method. We will use serialize() today when reading/writing from/to files.

* Open and study the class `ShapesCollectionIO`. This class sets up a collection of Shapes.

* Add a few shapes in the collection class.

* Test what they print using the serialize method.

### Task 2A: Writing to a file

* [Refer to these slides to see how we write data onto a file](https://docs.google.com/presentation/d/1pOI44dLbZkY243V4iI7NaEufpDMR_O0Z1Xw1Jwlzhkk/edit#slide=id.p).

* In the `ShapesCollectionIO` class define a method named `writeDataToFile(String fileName)`, to
write all Shape objects in the collection into the output file (passed as parameter to this method), one object per line. Use the
serialize() method to write the object into the file. (Do `not` use the toString() here.)

* Do you need to involve any `exceptions` in this code? If so, add the exception.

As always, test this method before moving on. 

### Task 2B: Reading from a file
* Open the provided file `input.txt` in your editor and examine its contents and formatting.

* [Review from the class slides how we read data from a file](https://docs.google.com/presentation/d/1pOI44dLbZkY243V4iI7NaEufpDMR_O0Z1Xw1Jwlzhkk/edit#slide=id.p).

* In the `ShapesCollectionIO` class add another method, named `readDataFromFile(String fileName)` which takes the name of a text file as input. This file contains Shape data, like the ones you created in the previous step. That is, one Shape per line in the following format:

<code>shape_name side1 side2 </code> etc...

where shape_name is "triangle", or "circle" or "rectangle".

* We suggest that the `readDataFromFile()` method reads the file token by token, creates the appropriate Shape object (Triangle, Rectangle or Circle), and then adds it to the collection.

You can assume that the file is `well-formatted` for now, i.e no errors in the file's formatting, no missing pieces of data etc.

* Once more, make sure you test this method appropriately.

### Task 3: Malformed input data: Exceptions and Recovery

* Do you need to deal with any `exceptions` in this piece of code? What can go wrong? 

* Now read the data from the provided `input2.txt` file, which is not... so "well-formatted"!

* Do you get a run time error? What kind? Think carefully how to deal with this. Ideally you would like the program to just ignore the problematic line and continue to normally process the rest of the input. The exceptions mechanism should be very helpful here.

Do the same for the `input3.txt` input file. Does your program work properly?

## SAVING YOUR WORK ON GITHUB
As we have discussed in class, it is important to work on labs and assignments regularly and save frequently. You should test your work incrementally, which will require you to save your file before compiling/running it. In addition to saving your work on your local machine, you should also frequently push your work to this Github repository. You can refer to Lab0 and the [Git and Github tutorial](https://github.com/CS230X-F24/github-starter-course) for a refresher on using these tools. 

## SUBMITTING TO GRADESCOPE
Turn in your work submitting files Circle and Rectangle classes, as well as ShapeCollectionIO to your Gradescope account for Lab0. You will receive full credit for this lab if you submit a reasonable attempt at completing the lab by the deadline. [Click here for Gradescope instructions.](https://docs.google.com/document/d/1zGAJrbdAhfPZVlyDP9N3MmdKXWvNo7rQqehKNM5Q0_M/edit) 

## AUTOGRADER
When you submit your lab to Gradecope, you will immediately see some feedback through the autograder. You are welcome to resubmit as many times as you wish until the deadline. The autograder will check for accuracy, style, and documentation. Make sure there are no remaining `TODO` comments in your submission code. Click here for 230X instructions on: [testing your code](https://docs.google.com/document/d/19cKOyolT8UtSfMNrVw8MGgVWS-lYgHpBs8g2Cf_8Vvc/edit#heading=h.rt39ohf1jp6s), [styling your code](https://docs.google.com/document/d/14uwj9HAjNKfFBm0ZjUpWR7jdqKSj13rudIEJaG74mPk/edit), and [documenting your code](https://docs.google.com/document/d/15uqs_NH8y2sAuLLpiZuSxlI0UsL6a8CHuWY_qcvF4B4/edit). 

## LAB SOLUTIONS
Lab solutions will be added to this repository after the lab deadline. 
