import processing.core.PApplet;

public class Circles extends PApplet {
    boolean started = false;
    int x;
    int y;
    int radius;
    int color;

    public static void main(String[] args) {
        PApplet.runSketch(new String[]{"stars"}, new Circles());
    }

    @Override
    public void settings() {
        size(600, 600);
    }

    @Override
    public void setup() {
        frameRate(5);
        background(0);
    }

    @Override
    public void draw() {
        if (started) {
            noFill();
            stroke(color);
            circle(x, y, radius);
            radius += 10;
        }
    }

    @Override
    public void mousePressed() {
        started = true;
        x = mouseX;
        y = mouseY;
        radius = 10;
        color = color(random(255), random(255), random(255));
    }
}
