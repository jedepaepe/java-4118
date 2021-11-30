import processing.core.PApplet;

import java.util.ArrayList;

public class CorrectionExamen extends PApplet {
    // constantes
    final int YELLOW = color(255, 255, 0);
    final int TURQUOISE = color(0, 255, 255);
    final int PURPLE = color(255, 0, 255);

    // état
    ArrayList<Integer> circleXs = new ArrayList<>();
    ArrayList<Integer> circleYs = new ArrayList<>();
    int diameter = 30;

    @Override
    public void settings() {
        size(600, 600);
    }

    @Override
    public void setup() {
        textAlign(CENTER, CENTER);
        textSize(20);
    }

    /**
     * dessine tout
     */
    @Override
    public void draw() {
        background(0);
        drawTextSquares();
        drawCircles();
    }

    /**
     * dessine les 6 carrés avec leur texte
     */
    void drawTextSquares() {
        boolean isYellowSquare = true;
        for (int i = 0; i < 6; ++i) {
            int xy = i * 100;

            int brushColor = isYellowSquare ? YELLOW : TURQUOISE;
            fill(brushColor);
            square(xy, xy, 100);

            brushColor = isYellowSquare ? TURQUOISE : YELLOW;
            fill(brushColor);
            text("carré " + (i + 1), xy + 50, xy + 50);

            isYellowSquare = ! isYellowSquare;
        }
    }

    /**
     * dessine les cercles
     */
    void drawCircles() {
        fill(PURPLE);
        for (int i = 0; i < circleXs.size(); ++i) {
            circle(circleXs.get(i), circleYs.get(i), diameter);
        }
    }

    @Override
    public void mouseReleased() {
        circleXs.add(mouseX);
        circleYs.add(mouseY);
    }

    @Override
    public void keyTyped() {
        if (key == '+' && diameter < 100) diameter += 10;
        if (key == '-' && diameter > 10) diameter -= 10;
    }

    public static void main(String[] args) {
        PApplet.runSketch(new String[] {"Examen"}, new CorrectionExamen());
    }
}
