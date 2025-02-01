import java.util.Deque;
import java.util.LinkedList;

public class Game {
    Board board;
    Dice dice;
    Deque<Player> players = new LinkedList<>();
    Player winner;

    public Game() {
        initialize();
    }

    private void initialize() {
        board = new Board(10, 5, 4);
        dice = new Dice(1);
        winner = null;
        Player player1 = new Player("p1", 0);
        Player player2 = new Player("p2", 0);
        players.add(player1);
        players.add(player2);
    }

    public void startGame() {
        while (winner == null) {
            Player currentPlayer = players.removeFirst();
            players.addLast(currentPlayer);

            System.out.println("player " + currentPlayer.id + ": current position: " + currentPlayer.curPos);

            int diceRoll = dice.roll();

            int newPos = currentPlayer.curPos + diceRoll;
            newPos = checkJump(newPos);
            currentPlayer.curPos = newPos;
            System.out.println("player " + currentPlayer.id + ": new position: " + currentPlayer.curPos);

            if (currentPlayer.curPos >= board.cells.length * board.cells.length - 1) {
                winner = currentPlayer;
            }
        }
        System.out.println("winner is " + winner.id);
    }

    private int checkJump(int newPos) {
        if (newPos > board.cells.length * board.cells.length - 1) {
            return newPos;
        }
        Cell cell = board.getCell(newPos);
        if (cell.jump != null && cell.jump.start == newPos) {
            String jumpBy = (cell.jump.start < cell.jump.end)? "ladder" : "snake";
            System.out.println("jump done by: " + jumpBy);
            return cell.jump.end;
        }
        return newPos;
    }

}
