import processing.core.PApplet;

public class Ex5StateSimple extends PApplet {
    // étape 0=>rouge, 1=>vert, 2=>bleu
    int step = 0;

    @Override
    public void settings() {
        size(300, 300);
    }

    @Override
    public void draw() {
        switch (step) {
            case 0:
                background(255, 0, 0);
                break;
            case 1:
                background(0, 255, 0);
                break;
            case 2:
                background(0, 0, 255);
                break;
        }
    }

    @Override
    public void mousePressed() {
        step = (step + 1) % 3;
    }

    @Override
    public void keyPressed() {
        step = (step + 1) % 3;
    }

    public static void main(String[] args) {
        PApplet.runSketch(new String[]{ "Ex5StateSimple "}, new Ex5StateSimple());
    }
}
