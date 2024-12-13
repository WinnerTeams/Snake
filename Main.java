import processing.core.PApplet;

public class Main extends PApplet {


    private Game game;
    private Money money;
    private int gridSize = 20;
    private boolean gamePaused = false;


    @Override
    public void settings() {
        size(600, 600); // Vinduesstørrelse
    }

    @Override
    public void setup() {
        money = new Money();
        int cols = width / gridSize;
        int rows = height / gridSize;

        // Initialiser spillet og baggrundsmusikken
        game = new Game(gridSize, cols, rows, money, this);
        frameRate(14);

    }

    @Override
    public void draw() {
        if (gamePaused) {
            displayPauseScreen();
            return;
        }

        background(50);
        game.drawBoard(this);
        game.updateGame();

        if (game.isGameOver()) {
            displayGameOverScreen();
            money.saveBalance();
            noLoop();
        } else {
            displayScoreAndLevel();
        }
    }

    void displayScoreAndLevel() {
        fill(255);
        textSize(20);
        text("Score: " + game.getScore(), 10, 20);
        text("Money: " + money.getBalance() + " kr", 10, 40);
        text("Level: " + game.getLevel(), 10, 60);
        text("Lives: " + game.getLives(), 10, 80);
    }

    void displayPauseScreen() {
        fill(255);
        textSize(50);
        text("Paused", width / 3, height / 2);
    }

    void displayGameOverScreen() {
        fill(255, 0, 0);
        textSize(50);
        text("Game Over!", width / 4, height / 2);
        textSize(20);
        text("Press 'R' to restart", width / 4, height / 2 + 50);
    }

    @Override
    public void keyPressed() {
        if (key == 'p' || key == 'P') {
            gamePaused = !gamePaused;

        } else if (key == 'r' || key == 'R') {
            setup();
            loop();
        } else if (!gamePaused) {
            if (keyCode == UP) game.getSnake().setDirection(0, -1);
            if (keyCode == DOWN) game.getSnake().setDirection(0, 1);
            if (keyCode == LEFT) game.getSnake().setDirection(-1, 0);
            if (keyCode == RIGHT) game.getSnake().setDirection(1, 0);
        }
    }
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.startMenu();



}
}