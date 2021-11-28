import processing.core.PApplet;

public class SnakeApp extends PApplet {
    int size = 300;
    int numberOfCells = 10;
    int foodIndexX = -1;
    int foodIndexY = -1;
    int snakeX = (int) random(numberOfCells);
    int snakeY = (int) random(numberOfCells);

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
        drawFood();
        drawSnake();
    }

    private void drawBoard() {
        stroke(255);
        for (int xy = 0; xy < size; xy += size / numberOfCells) {
            line(xy, 0, xy, height);
            line(0, xy, width, xy);
        }
    }

    private void drawFood() {
        if (-1 == foodIndexX) {
            randomFood();
            System.out.println(foodIndexX + " " + foodIndexY);
        }
        drawCell(foodIndexX, foodIndexY, color(0, 255, 0));
    }

    private void randomFood() {
        foodIndexX = (int) random(numberOfCells);
        foodIndexY = (int) random(numberOfCells);
    }

    private void drawCell(int indexX, int indexY, int color) {
        fill(color);
        stroke(255);
        float deltaX = width / numberOfCells;
        float x = indexX * deltaX;
        float deltaY = height / numberOfCells;
        float y = indexY * deltaY;
        rect(x, y, deltaX, deltaY);
    }

    private void drawSnake() {
        drawCell(snakeX, snakeY, color(255, 255, 0));
    }

    public static void main(String[] args) {
        PApplet.runSketch(new String[]{"SnakeApp"}, new SnakeApp());
    }
}
