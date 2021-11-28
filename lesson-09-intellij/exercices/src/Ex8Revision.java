import processing.core.PApplet;

import java.util.ArrayList;

public class Ex8Revision extends PApplet {
    final int SQUARE_COUNT = 6;
    final int SQUARE_SIZE = 100;
    final int CIRCLE_SIZE_DELTA = 10;
    final int CIRCLE_MOVE = 5;
    PCircles pcircles = new PCircles();

    @Override
    public void settings() {
        size(SQUARE_COUNT * SQUARE_SIZE, SQUARE_COUNT * SQUARE_SIZE);
    }

    @Override
    public void setup() {
        textAlign(CENTER, CENTER);
        textSize(20);
    }

    @Override
    public void draw() {
        background(0);
        drawSquares();
        pcircles.draw();
    }

    private void drawSquares() {
        for (int i = 0; i < SQUARE_COUNT; ++i) {
            int p = pixelsFromIndex(i);
            if (i % 2 == 0) fill(255, 255, 0);
            else fill(0, 255, 255);
            square(p, p, SQUARE_SIZE);
            if (i % 2 == 0) fill(0, 255, 255);
            else fill(255, 255, 0);
            text("carré " + (i + 1), p + SQUARE_SIZE / 2, p + SQUARE_SIZE /2);
        }
    }

    private int pixelsFromIndex(int index) {
        return index * SQUARE_SIZE;
    }

    @Override
    public void mouseClicked() {
        pcircles.mouseClicked();
    }

    private void addCircle() {
        pcircles.addCircle(mouseX, mouseY);
    }

    @Override
    public void keyPressed() {
        pcircles.keyPressed();
    }

    private int getInWindowPixels(int position, int size) {
        int result = position % size;
        if (result < 0) result += size;
        return result;
    }

    public static void main(String[] args) {
        PApplet.runSketch(new String[] { Ex8Revision.class.getName() }, new Ex8Revision());
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
        int diameter = 30;

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
        public void draw() {
            fill(255, 0, 255);
            for (Circle c : circles) {
                circle(getInWindowPixels(c.x, width), getInWindowPixels(c.y, height), pcircles.diameter);
            }
        }

        public void keyPressed() {
            if ('+' == key) changeDiameter(CIRCLE_SIZE_DELTA);
            if ('-' == key) changeDiameter(-CIRCLE_SIZE_DELTA);

            switch (keyCode) {
                case UP:
                    move(0, -CIRCLE_MOVE);
                    break;
                case RIGHT:
                    move(CIRCLE_MOVE, 0);
                    break;
                case DOWN:
                    move(0, CIRCLE_MOVE);
                    break;
                case LEFT:
                    move(- CIRCLE_MOVE, 0);
            }
        }

        public void mouseClicked() {
            addCircle(mouseX, mouseY);
        }
    }
}