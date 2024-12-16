import java.util.LinkedList;

public class Snake {
    private LinkedList<int[]> segments; // Slangens segmenter
    private int[] direction = {1, 0}; // Bevægelsesretning
    private int cols, rows; // Spillets gridstørrelse

    public Snake(int startX, int startY, int cols, int rows) {
        this.segments = new LinkedList<>();
        this.segments.add(new int[]{startX, startY});
        this.cols = cols;
        this.rows = rows;
    }

    // Flyt slangen
    public void move(boolean grow) {
        // Beregn hovedets nye position
        int[] head = segments.getFirst();
        int newX = (head[0] + direction[0] + cols) % cols;
        int newY = (head[1] + direction[1] + rows) % rows;

        // Tilføj nyt hoved til listen
        segments.addFirst(new int[]{newX, newY});

        // Hvis slangen ikke skal vokse, fjern halen
        if (!grow) {
            segments.removeLast();
        }
    }

    // Tjek om slangen rammer sig selv
    public boolean checkSelfCollision() {
        int[] head = segments.getFirst();
        for (int i = 1; i < segments.size(); i++) {
            if (segments.get(i)[0] == head[0] && segments.get(i)[1] == head[1]) {
                return true;
            }
        }
        return false;
    }

    // Opdater retningen, hvis den ikke vender om
    public void setDirection(int dx, int dy) {
        if (direction[0] + dx != 0 || direction[1] + dy != 0) {
            direction[0] = dx;
            direction[1] = dy;
        }
    }

    // Hent slangens hoved
    public int[] getHead() {
        return segments.getFirst();
    }

    // Hent slangens segmenter
    public LinkedList<int[]> getSegments() {
        return segments;
    }

    // Nulstil slangen
    public void reset(int startX, int startY) {
        segments.clear();
        segments.add(new int[]{startX, startY});
        direction[0] = 1;
        direction[1] = 0;
    }
}
