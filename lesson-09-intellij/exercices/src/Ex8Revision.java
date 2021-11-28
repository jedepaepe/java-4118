import processing.core.PApplet;

public class Ex8Revision extends PApplet {
    final int SQUARE_COUNT = 6;
    final int SQUARE_SIZE = 100;
    final int CIRCLE_SIZE_DELTA = 10;
    final int CIRCLE_MOVE = 5;
    int circleSize = 30;
    int[] positionX = new int[1000];
    int[] positionY = new int[1000];
    int index = 0;

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
        for (int i = 0; i < SQUARE_COUNT; ++i) {
            int p = i * SQUARE_SIZE;
            if (i % 2 == 0) fill(255, 255, 0);
            else fill(0, 255, 255);
            square(p, p, SQUARE_SIZE);
            if (i % 2 == 0) fill(0, 255, 255);
            else fill(255, 255, 0);
            text("carré " + (i + 1), p + SQUARE_SIZE / 2, p + SQUARE_SIZE /2);
        }

        for (int i = 0; i < index; ++i) {
            fill(255, 0, 255);
            circle(positionX[i], positionY[i], circleSize);
        }
    }

    @Override
    public void mouseClicked() {
        positionX[index] = mouseX;
        positionY[index] = mouseY;
        ++index;
    }

    @Override
    public void keyPressed() {
        if ('+' == key && circleSize < 100) circleSize += CIRCLE_SIZE_DELTA;
        if ('-' == key && circleSize > 10) circleSize -= CIRCLE_SIZE_DELTA;

        int deltaX = 0;
        int deltaY = 0;
        switch (keyCode) {
            case UP:
                deltaY = - CIRCLE_MOVE;
                break;
            case RIGHT:
                deltaX = CIRCLE_MOVE;
                break;
            case DOWN:
                deltaY = CIRCLE_MOVE;
                break;
            case LEFT:
                deltaX = - CIRCLE_MOVE;
        }
        if (0 != deltaX || 0 != deltaY) {
            for (int i = 0; i < index; ++i) {
                positionX[i] = (positionX[i] + deltaX) % width;
                if (positionX[i] < 0) positionX[i] = positionX[i] + width;
                positionY[i] = (positionY[i] + deltaY) % height;
                if (positionY[i] < 0) positionY[i] = positionY[i] + height;
            }
        }
    }

    public static void main(String[] args) {
        PApplet.runSketch(new String[] { Ex8Revision.class.getName() }, new Ex8Revision());
    }
}
