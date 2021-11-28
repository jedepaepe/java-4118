import processing.core.PApplet;

public class SnakeApp extends PApplet {
    int size = 800;
    int numberOfCells = 10;

    @Override
    public void settings() {
        size(size, size);
    }

    @Override
    public void setup() {
        surface.setTitle("Snake");
    }

    @Override
    public void draw() {
        background(0);
        drawBoard();
    }

    private void drawBoard() {
        stroke(255);
        for (int xy = 0; xy < size; xy += size / numberOfCells) {
            line(xy, 0, xy, height);
            line(0, xy, width, xy);
        }
    }

    public static void main(String[] args) {
        PApplet.runSketch(new String[]{"SnakeApp"}, new SnakeApp());
    }
}
