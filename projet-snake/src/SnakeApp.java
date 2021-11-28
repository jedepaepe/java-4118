import processing.core.PApplet;

public class SnakeApp extends PApplet {
    int size = 300;
    int numberOfCells = 10;
    final int IS_EAT = -1;
    int foodIndexX = IS_EAT;
    int foodIndexY = IS_EAT;
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

    @Override
    public void keyPressed() {
        switch (keyCode) {
            case UP:
                moveSnake(snakeX, --snakeY);
                break;
            case RIGHT:
                moveSnake(++snakeX, snakeY);
                break;
            case DOWN:
                moveSnake(snakeX, ++snakeY);
                break;
            case LEFT:
                moveSnake(--snakeX, snakeY);
        }
        eatFood();
    }

    private void moveSnake(int indexX, int indexY) {
        snakeX = replaceInBoard(indexX);
        snakeY = replaceInBoard(indexY);
    }

    private void eatFood() {
        if (foodIndexX == snakeX && foodIndexY == snakeY) {
            foodIndexX = IS_EAT;
            foodIndexY = IS_EAT;
        }
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

    private int replaceInBoard(int index) {
        if (index < 0) return index + numberOfCells;
        if (index >= numberOfCells) return index - numberOfCells;
        return index;
    }

    public static void main(String[] args) {
        PApplet.runSketch(new String[]{"SnakeApp"}, new SnakeApp());
    }
}
