import processing.core.PApplet;

public class Ex2Switch extends PApplet {

    @Override
    public void settings() {
        size(300, 300);
    }

    @Override
    public void setup() {
        background(0);
    }

    @Override
    public void draw() {
    }

    @Override
    public void keyReleased() {
        switch (key) {
            case 'b', 'B':
                fill(0, 0, 255);
                break;
            case 'j', 'J':
                fill(255, 255, 0);
                break;
            case 'm', 'M':
                fill(255, 0, 255);
                break;
            case 'n', 'N':
                fill(0);
                break;
            case 'o', 'O':
                fill(255, 153, 51);
                break;
            case 'r', 'R':
                fill(255, 0, 0);
                break;
            case 't', 'T':
                fill(0, 255, 255);
                break;
            case 'v', 'V':
                fill(0, 255, 0);
                break;
            default:
                fill(255);
        }
        circle(mouseX, mouseY, 50);
    }

    public static void main(String[] args) {
        PApplet.runSketch(new String[]{"Ex2Switch"}, new Ex2Switch());
    }
}
