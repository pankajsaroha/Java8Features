package org.java.design.patterns;

import java.util.ArrayList;
import java.util.List;

/* Structural Design Pattern */
public class Composite {

    public static void main(String[] args) {
        Shape triangle1 = new Triangle();
        Shape triangle2 = new Triangle();
        Shape circle = new Circle();

        Drawing drawing = new Drawing();
        drawing.add(triangle1);
        drawing.add(triangle2);
        drawing.add(circle);

        drawing.draw("Red");

        drawing.clear();

        drawing.add(triangle1);
        drawing.add(circle);
        drawing.draw("Green");
    }
}

/* Base Component */
interface Shape {
    public void draw(String fillColor);
}

/* Leaf Objects */
class Triangle implements Shape {

    @Override
    public void draw(String fillColor) {
        System.out.println("Drawing triangle with color " + fillColor);
    }
    
}

class Circle implements Shape {

    @Override
    public void draw(String fillColor) {
        System.out.println("Drawing circle with color " + fillColor);
    }
    
}

/* 
 * Composite Object
 * A Composite object contains group of leaf objects and we should provide some helper methods
 * to add or delete leafs from the group. 
 */
class Drawing implements Shape {

    public List<Shape> shapes = new ArrayList<>();

    @Override
    public void draw(String fillColor) {
        for(Shape shape : shapes) {
            shape.draw(fillColor);
        }
    }

    public void add(Shape shape) {
        this.shapes.add(shape);
    }

    public void remove(Shape shape) {
        this.shapes.remove(shape);
    }

    public void clear() {
        System.out.println("Clearing all the shapes from drawing.");
        this.shapes.clear();
    }
    
}