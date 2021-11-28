import processing.core.PApplet;

import java.util.ArrayList;

public class Ex8Revision extends PApplet {
    final int SQUARE_COUNT = 6;
    final int SQUARE_SIZE = 100;
    final int CIRCLE_SIZE_DELTA = 10;
    final int CIRCLE_MOVE = 5;
    int diameter = 30;
    ArrayList<Circle> circles = new ArrayList<>();

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
        drawCircles();
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

    private void drawCircles() {
        fill(255, 0, 255);
        for (Circle c : circles) circle(getInWindowPixels(c.x, width), getInWindowPixels(c.y, height), diameter);
    }

    @Override
    public void mouseClicked() {
        addCircle();
    }

    private void addCircle() {
        circles.add(new Circle(mouseX, mouseY));
    }

    @Override
    public void keyPressed() {
        if ('+' == key && diameter < 100) diameter += CIRCLE_SIZE_DELTA;
        if ('-' == key && diameter > 10) diameter -= CIRCLE_SIZE_DELTA;

        switch (keyCode) {
            case UP:
                moveCircles(0, -CIRCLE_MOVE);
                break;
            case RIGHT:
                moveCircles(CIRCLE_MOVE, 0);
                break;
            case DOWN:
                moveCircles(0, CIRCLE_MOVE);
                break;
            case LEFT:
                moveCircles(- CIRCLE_MOVE, 0);
        }
    }

    private void moveCircles(int deltaX, int deltaY) {
        for (Circle c : circles) {
            c.move(deltaX, deltaY);
        }
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

        public Circle() {
        }

        public Circle(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void move(int deltaX, int deltaY) {
            x += deltaX;
            y += deltaY;
        }
    }
}