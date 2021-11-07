import processing.core.PApplet;

public class Ex4Array extends PApplet {
    int[] sizes = { 10, 20, 35, 52, 71 };

    @Override
    public void settings() {
        size(300, 300);
    }

    @Override
    public void setup() {
        frameRate(4);
        rectMode(CENTER);
        background(0);
        noFill();
        stroke(255, 153, 51);
    }

    @Override
    public void draw() {
        for(int s : sizes) {
            square(mouseX, mouseY, s);
        }
    }

    public static void main(String[] args) {
        PApplet.runSketch(new String[]{ "Ex4Array" }, new Ex4Array());
    }
}
