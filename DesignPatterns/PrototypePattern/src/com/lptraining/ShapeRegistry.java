package com.lptraining;

import com.lptraining.shapes.Rectangle;
import com.lptraining.shapes.Shape;
import com.lptraining.shapes.ShapeTypes;
import com.lptraining.shapes.Square;

import java.util.HashMap;
import java.util.Map;

public class ShapeRegistry {
    private Map<ShapeTypes, Shape> shapes=new HashMap<>();

    public ShapeRegistry() {
        this.initializer();
    }

    public Shape getShape(ShapeTypes shapeTypes) throws CloneNotSupportedException {
        return (Shape) shapes.get(shapeTypes).clone();

    }
    private void initializer() {
        Square square=new Square(10,10,"BLACK");
        Rectangle rectangle=new Rectangle(10,20,"GREEN");

        shapes.put(ShapeTypes.SQUARE,square);
        shapes.put(ShapeTypes.RECTANGLE,rectangle);
    }

}
