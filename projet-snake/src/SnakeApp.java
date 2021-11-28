import processing.core.PApplet;

public class SnakeApp extends PApplet {
    int numberOfCells = 7;
    int size = numberOfCells * 30;
    final int IS_EAT = -1;
    int foodIndexX = IS_EAT;
    int foodIndexY = IS_EAT;
    int snakeX[];
    int snakeY[];

    @Override
    public void settings() {
        size(size, size);
    }

    @Override
    public void setup() {
        surface.setTitle("Snake");
        initSnake();
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
                moveSnake(snakeX[0], snakeY[0] - 1);
                break;
            case RIGHT:
                moveSnake(snakeX[0] + 1, snakeY[0]);
                break;
            case DOWN:
                moveSnake(snakeX[0], snakeY[0] + 1);
                break;
            case LEFT:
                moveSnake(snakeX[0] - 1, snakeY[0]);
        }
    }

    private void initSnake() {
        snakeX = new int[1];
        snakeY = new int[1];
        snakeX[0] = (int) random(numberOfCells);
        snakeY[0] = (int) random(numberOfCells);
    }

    private void moveSnake(int indexX, int indexY) {
        indexX = replaceInBoard(indexX);
        indexY = replaceInBoard(indexY);
        if (isInSnake(indexX, indexY)) return;
        int len = snakeX.length;
        if (eatFood(indexX, indexY)) {
            int[] newSnakeX = new int[len + 1];
            int[] newSnakeY = new int[len + 1];
            copyArray(snakeX, newSnakeX);
            copyArray(snakeY, newSnakeY);
            snakeX = newSnakeX;
            snakeY = newSnakeY;
            snakeX[len] = snakeX[len - 1];
            snakeY[len] = snakeY[len - 1];
            System.out.println("queue " + snakeX[len] + " " + snakeY[len]);
        }
        for (int i = len - 1; i > 0; --i) {
            snakeX[i] = snakeX[i - 1];
            snakeY[i] = snakeY[i - 1];
        }
        snakeX[0] = indexX;
        snakeY[0] = indexY;
        for (int i = 0; i < snakeX.length; ++i) println("snake " + snakeX[i] + " " + snakeY[i]);
    }

    private void copyArray(int[] source, int[] destination) {
        for (int i = 0; i < source.length && i < destination.length; ++i) {
            destination[i] = source[i];
        }
    }

    private boolean eatFood(int indexX, int indexY) {
        if (foodIndexX == indexX && foodIndexY == indexY) {
            foodIndexX = IS_EAT;
            foodIndexY = IS_EAT;
            return true;
        }
        return false;
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
            System.out.println("food " + foodIndexX + " " + foodIndexY);
        }
        drawCell(foodIndexX, foodIndexY, color(0, 255, 0));
    }

    private void randomFood() {
        do {
            foodIndexX = (int) random(numberOfCells);
            foodIndexY = (int) random(numberOfCells);
        } while (isInSnake(foodIndexX, foodIndexY));
    }

    private boolean isInSnake(int indexX, int indexY) {
        for (int i = 0; i < snakeX.length; ++i) {
            if (indexX == snakeX[i] && indexY == snakeY[i]) return true;
        }
        return false;
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
        for (int index = 0; index < snakeX.length; ++index) {
            drawCell(snakeX[index], snakeY[index], color(255, 255, 0));
        }
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
