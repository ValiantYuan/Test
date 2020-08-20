package com.yuanqi.quiz.oodesign;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author : yuanqi
 */
public class DrawShapeTool {

    public static String drawShape(Shape shape) {
        return shape.draw();
    }


    @Test
    public void drawCircleCase() {
        Shape circle = new Circle();
        String expected = "do pre processing\n" + "draw a circle" + "\ndo post processing";
        String actual = DrawShapeTool.drawShape(circle);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void drawStrangeCase() {
        Shape strangeShape = new StrangeShape();
        String expected = "do pre processing\n" + "draw a strange shape" + "\ndo post processing";
        String actual = DrawShapeTool.drawShape(strangeShape);
        Assert.assertEquals(expected, actual);
    }
}
