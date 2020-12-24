package com.lptraining;

import com.lptraining.shapes.Shape;
import com.lptraining.shapes.ShapeTypes;
import com.lptraining.shapes.Square;

public class Application {

    public static void main(String[] args) {
        ShapeRegistry shapeRegistry=new ShapeRegistry();
        try {
            Shape square =(Square) shapeRegistry.getShape(ShapeTypes.SQUARE);
            System.out.println(square);
            square.setColor("BLUE");
            System.out.println(square);

            Shape square1=(Square) shapeRegistry.getShape(ShapeTypes.SQUARE);
            System.out.println(square1);
        } catch (CloneNotSupportedException cloneNotSupportedException) {
            System.out.println(cloneNotSupportedException.getMessage());
        }
    }
}
