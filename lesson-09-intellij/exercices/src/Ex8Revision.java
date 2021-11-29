import processing.core.PApplet;

import java.util.ArrayList;
import java.util.Arrays;

public class Ex8Revision extends PApplet {
    AppParameters appParameters;
    PCircles pCircles;
    PSquares pSquares;

    public Ex8Revision() {
    }

    public Ex8Revision initialize(String[] args) {
        appParameters = new AppParametersHelper().build(args);
        pCircles = new PCircles(appParameters.circleDiameter, appParameters.circleSizeDelta, appParameters.circleMove);
        pSquares = new PSquares(appParameters.squareCount, appParameters.squareSize);
        return this;
    }

    @Override
    public void settings() {
        int size = appParameters.squareCount * appParameters.squareSize;
        size(size, size);
    }

    @Override
    public void setup() {
        textAlign(CENTER, CENTER);
        textSize(20);
    }

    @Override
    public void draw() {
        background(0);
        pSquares.draw();
        pCircles.draw();
    }

    @Override
    public void mouseClicked() {
        pCircles.mouseClicked();
    }

    private void addCircle() {
        pCircles.addCircle(mouseX, mouseY);
    }

    @Override
    public void keyPressed() {
        pCircles.keyPressed();
    }

    private int getInWindowPixels(int position, int size) {
        int result = position % size;
        if (result < 0) result += size;
        return result;
    }

    public static void main(String[] args) {
        PApplet.runSketch(new String[] { Ex8Revision.class.getName() }, new Ex8Revision().initialize(args));
    }

    class Circle {
        int x;
        int y;

        public Circle(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void move(int deltaX, int deltaY) {
            x += deltaX;
            y += deltaY;
        }
    }

    class Circles {
        ArrayList<Circle> circles = new ArrayList<>();
        int diameter;

        public Circles(int diameter) {
            this.diameter = diameter;
        }

        public void addCircle(int x, int y) {
            circles.add(new Circle(x, y));
        }

        public void changeDiameter(int delta) {
            int newDiameter = diameter + delta;
            if (10 < newDiameter && newDiameter < 100) diameter = newDiameter;
        }

        public void move(int deltaX, int deltaY) {
            for (Circle c : circles) c.move(deltaX, deltaY);
        }
    }

    class PCircles extends Circles {
        int sizeDelta;
        int moveDelta;

        public PCircles(int diameter, int sizeDelta, int moveDelta) {
            super(diameter);
            this.sizeDelta = sizeDelta;
            this.moveDelta = moveDelta;
        }

        public void draw() {
            fill(255, 0, 255);
            for (Circle c : circles) {
                circle(getInWindowPixels(c.x, width), getInWindowPixels(c.y, height), pCircles.diameter);
            }
        }

        public void keyPressed() {
            if ('+' == key) changeDiameter(sizeDelta);
            if ('-' == key) changeDiameter(-sizeDelta);

            switch (keyCode) {
                case UP:
                    move(0, -moveDelta);
                    break;
                case RIGHT:
                    move(moveDelta, 0);
                    break;
                case DOWN:
                    move(0, moveDelta);
                    break;
                case LEFT:
                    move(- moveDelta, 0);
            }
        }

        public void mouseClicked() {
            addCircle(mouseX, mouseY);
        }
    }

    class PSquares {
        int count;
        int size;

        public PSquares(int count, int size) {
            this.count = count;
            this.size = size;
        }

        public void draw() {
            for (int i = 0; i < count; ++i) {
                int p = pixelsFromIndex(i);
                if (i % 2 == 0) fill(255, 255, 0);
                else fill(0, 255, 255);
                square(p, p, size);
                if (i % 2 == 0) fill(0, 255, 255);
                else fill(255, 255, 0);
                text("carré " + (i + 1), p + size / 2, p + size /2);
            }
        }

        private int pixelsFromIndex(int index) {
            return index * size;
        }
    }

    class AppParameters {
        int squareCount = 6;
        int squareSize = 100;
        int circleDiameter = 30;
        int circleSizeDelta = 10;
        int circleMove = 5;
    }

    class AppParametersHelper {
        public AppParameters build(String[] args) {
            AppParameters appParameters = new AppParameters();
            ArrayList<Integer> params = new ArrayList<Integer>();
            for (String arg : args) {
                params.add(Integer.getInteger(arg));
            }
            if (args.length >= 1) appParameters.squareCount = params.get(0);
            if (args.length >= 2) appParameters.squareSize = params.get(1);
            if (args.length >= 3) appParameters.circleDiameter = params.get(2);
            if (args.length >= 4) appParameters.circleSizeDelta = params.get(3);
            if (args.length >= 5) appParameters.circleMove = params.get(4);
            return appParameters;
        }
    }
}