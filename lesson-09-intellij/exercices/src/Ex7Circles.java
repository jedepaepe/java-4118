import processing.core.PApplet;

public class Ex7Circles extends PApplet {
    final int START_RADIUS = 20;
    final int DELTA_RADIUS = 10;
    int[] positionXs = new int[1000];
    int[] positionYx = new int[1000];
    int[] diameters = new int[1000];
    int index = 0;

    @Override
    public void settings() {
        size(600, 600);
    }

    @Override
    public void setup() {
        stroke(255);
    }

    @Override
    public void draw() {
        background(0);
        noFill();
        for (int i = 0; i < index; ++i) {
            circle(positionXs[i], positionYx[i], diameters[i]);
        }
        if (index > 0 && frameCount % 20 == 0) {
            positionXs[index] = positionXs[index - 1];
            positionYx[index] = positionYx[index - 1];
            diameters[index] = diameters[index - 1] + DELTA_RADIUS;
            ++index;
        }
    }

    @Override
    public void mousePressed() {
        positionXs[index] = mouseX;
        positionYx[index] = mouseY;
        diameters[index] = START_RADIUS;
        ++index;
    }

    @Override
    public void keyPressed() {
        switch (key) {
            case 'r':
                stroke(255, 0, 0);
                break;
            case 'v':
                stroke(0, 255, 0);
                break;
            case 'b':
                stroke(0, 0, 255);
                break;
            case 'j':
                stroke(255, 255, 0);
                break;
            case 't':
                stroke(0, 255, 255);
                break;
            case 'm':
                stroke(255, 0, 255);
                break;
            case 'w':
                stroke(255);
        }
    }

    public static void main(String[] args) {
        PApplet.runSketch(new String[] { "circles" }, new Ex7Circles());
    }
}
