import processing.core.PApplet;

public class Ex5State extends PApplet {
    // nombre maximum de cercles
    final int circleMax = 10;
    // index du prochain cercle à dessiner
    int index = 0;
    // positions x des cercles
    int[] circleXs = new int[circleMax];
    // positions y des cercles
    int[] circleYs = new int[circleMax];
    // couleur
    int circleColor = color(255, 255, 255);

    @Override
    public void settings() {
        size(300, 300);
    }

    @Override
    public void setup() {
        super.setup();
    }

    @Override
    public void draw() {
        background(0);
        fill(circleColor);
        for (int i = 0; i < circleMax; ++i) {
            if (circleXs[i] != 0) { // 0 => valeur d'initialisation => pas utilisateur
                circle(circleXs[i], circleYs[i], 30);
            }
        }
    }

    @Override
    public void mousePressed() {
        circleXs[index] = mouseX;
        circleYs[index] = mouseY;
        index = (index + 1) % circleMax;
    }

    @Override
    public void keyPressed() {
        switch (key) {
            case 'r', 'R':
                circleColor = color(255, 0, 0);
                break;
            case 'v', 'G':
                circleColor = color(0, 255, 0);
                break;
            case 'b', 'B':
                circleColor = color(0, 0, 255);
                break;
            default:
                circleColor = color(255);
        }
    }

    public static void main(String[] args) {
        PApplet.runSketch(new String[]{ "Ex5State" }, new Ex5State());
    }
}
