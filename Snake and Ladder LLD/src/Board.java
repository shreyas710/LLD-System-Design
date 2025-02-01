import java.util.concurrent.ThreadLocalRandom;

public class Board {
    Cell [][] cells;

    Board (int boardSize, int snakes, int ladders) {
        initialize(boardSize);
        addSnakeAndLadder(cells, snakes, ladders);
    }

    public void initialize(int boardSize) {
        cells = new Cell[boardSize][boardSize];
        for (int row = 0; row < boardSize; row++) {
            for (int col = 0; col < boardSize; col++) {
                cells[row][col] = new Cell();
            }
        }
    }

    public void addSnakeAndLadder(Cell[][] cells, int snakes, int ladders) {
        while (snakes > 0) {
            int snakeStart = ThreadLocalRandom.current().nextInt(1, cells.length * cells.length - 1);
            int snakeEnd = ThreadLocalRandom.current().nextInt(1, cells.length * cells.length - 1);
            if (snakeStart <= snakeEnd) { // not possible to go up from snake
                continue;
            }
            Jump snakeObj = new Jump();
            snakeObj.start = snakeStart;
            snakeObj.end = snakeEnd;
            Cell snakeCell = getCell(snakeStart);
            snakeCell.jump = snakeObj;
            snakes--;
        }
        while (ladders > 0) {
            int ladderStart = ThreadLocalRandom.current().nextInt(1, cells.length * cells.length - 1);
            int ladderEnd = ThreadLocalRandom.current().nextInt(1, cells.length * cells.length - 1);
            if (ladderStart >= ladderEnd) { // not possible to go down from ladder
                continue;
            }
            Jump ladderObj = new Jump();
            ladderObj.start = ladderStart;
            ladderObj.end = ladderEnd;
            Cell ladderCell = getCell(ladderStart);
            ladderCell.jump = ladderObj;
            ladders--;
        }
    }

    Cell getCell(int index) {
        int row = index / cells.length;
        int col = index % cells.length;
        return cells[row][col];
    }
}
