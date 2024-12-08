import processing.core.PApplet;
import java.util.ArrayList;

public class SnakeGame extends PApplet {

    int gridSize = 20; // Størrelsen på hver celle i spillet
    int cols, rows; // Antal kolonner og rækker
    int[][] board; // Repræsenterer spilområdet
    int score = 0; // Spillerens score
    int money = 0; // Penge vundet af spilleren

    ArrayList<int[]> snake = new ArrayList<>();
    int snakeX = 0, snakeY = 0; // Snake's startposition
    int foodX, foodY; // Fødeposition
    int dirX = 1, dirY = 0; // Startbevægelse for slangen




    @Override
    public void settings() {
        size(600, 600); // Vinduesstørrelse
    }

    @Override
    public void setup() {
        cols = width / gridSize;
        rows = height / gridSize;
        board = new int[cols][rows];
        spawnFood(); // Placer mad på boardet
        int[] initialSegment = {snakeX, snakeY};
        snake.add(initialSegment); // Start slangen med ét segment
        frameRate(17);


    }

    @Override
    public void draw() {
        background(50);
        drawBoard();
        updateSnake();
        checkCollision();
        displayScore();
    }

    void drawBoard() {
        // Tegn brættet
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                stroke(100);
                noFill();
                rect(i * gridSize, j * gridSize, gridSize, gridSize);
            }
        }
        // Tegn mad
        fill(255, 0, 0);
        rect(foodX * gridSize, foodY * gridSize, gridSize, gridSize);

        // Tegn slangen
        fill(0, 255, 0);
        for (int[] segment : snake) {
            rect(segment[0] * gridSize, segment[1] * gridSize, gridSize, gridSize);
        }

    }

    void spawnFood() {
        boolean validPosition = false;
        while (!validPosition) {
            foodX = (int) random(cols);
            foodY = (int) random(rows);
            validPosition = true;

            // Tjek, om maden overlapper med slangen
            for (int[] segment : snake) {
                if (foodX == segment[0] && foodY == segment[1]) {
                    validPosition = false;
                    break;
                }
            }
        }
    }


    void updateSnake() {
        // Beregn ny position for slangens hoved
        snakeX += dirX;
        snakeY += dirY;

        // Wrap rundt om kanterne
        if (snakeX < 0) {
            snakeX = cols - 1;
        } else if (snakeX >= cols) {
            snakeX = 0;
        }

        if (snakeY < 0) {
            snakeY = rows - 1;
        } else if (snakeY >= rows) {
            snakeY = 0;
        }

        // Tilføj det nye hoved til slangens positioner
        int[] newHead = {snakeX, snakeY};
        snake.add(0, newHead); // Tilføj ny position foran slangen

        // Hvis slangen spiser mad
        if (snakeX == foodX && snakeY == foodY) {
            score += 10; // Forøg score
            money += 5;  // Forøg penge
            spawnFood(); // Generer ny mad
        } else {
            // Fjern det sidste segment (hvis der ikke spises mad)
            snake.remove(snake.size() - 1);
        }

        // Tjek for kollision med slangens egen krop
        for (int i = 1; i < snake.size(); i++) {
            if (snakeX == snake.get(i)[0] && snakeY == snake.get(i)[1]) {
                gameOver();
                return;
            }
        }
    }



    void checkCollision() {
        // Hvis slangen spiser mad
        if (snakeX == foodX && snakeY == foodY) {
            score += 10; // Forøg score
            money += 5; // Tildel penge
            spawnFood(); // Generer ny mad
        }
    }

    void displayScore() {
        fill(255);
        textSize(20);
        text("Score: " + score, 10, 20);
        text("Money: $" + money, 10, 40);
    }

    void gameOver() {
        noLoop(); // Stop draw-loopet
        fill(255, 0, 0);
        textSize(50);
        text("Game Over!", width / 4, height / 2);
    }

    @Override
    public void keyPressed() {
        // Ændring af retning baseret på tastetryk
        if (keyCode == UP && dirY == 0) {
            dirX = 0;
            dirY = -1;
        } else if (keyCode == DOWN && dirY == 0) {
            dirX = 0;
            dirY = 1;
        } else if (keyCode == LEFT && dirX == 0) {
            dirX = -1;
            dirY = 0;
        } else if (keyCode == RIGHT && dirX == 0) {
            dirX = 1;
            dirY = 0;
        }
    }

    public static void main(String[] args) {
        PApplet.main("SnakeGame");
    }
}