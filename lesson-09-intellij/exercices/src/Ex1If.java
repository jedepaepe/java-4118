import processing.core.PApplet;

public class Ex1If extends PApplet {

    @Override
    public void settings() {
        size(300, 300);
    }

    @Override
    public void draw() {
        if (mouseY > height / 2) background(255, 255, 0);
        else background(0, 255, 255);
        line(0, height / 2, width, height / 2);
    }

    public static void main(String[] args) {
        PApplet.runSketch(new String[] {"Ex1If"}, new Ex1If());
    }
}
