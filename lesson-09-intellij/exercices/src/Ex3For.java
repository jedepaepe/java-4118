import processing.core.PApplet;

public class Ex3For extends PApplet {
    @Override
    public void settings() {
        size(300, 300);
    }

    @Override
    public void setup() {
        background(0);
        noFill();
        stroke(255, 255, 0);
        rectMode(CENTER);
    }

    @Override
    public void draw() {
    }

    @Override
    public void mousePressed() {
        for (int width = 15; width <= 75; width += 15) {
            square(mouseX, mouseY, width);
        }
    }

    public static void main(String[] args) {
        PApplet.runSketch(new String[] { "Ex3For" }, new Ex3For());
    }
}
