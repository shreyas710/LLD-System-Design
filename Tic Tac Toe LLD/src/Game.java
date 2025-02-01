import Model.*;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import javafx.util.Pair;

public class Game {
    Deque<Player> players;
    Board board;

    Game() {
        initializeGame();
    }

    void initializeGame() {
        players = new LinkedList<>();
        PlayingPieceX x = new PlayingPieceX();
        Player p1 = new Player("Player 1", x);
        PlayingPieceO o = new PlayingPieceO();
        Player p2 = new Player("Player 2", o);

        players.add(p1);
        players.add(p2);

        board = new Board(3);
    }

    public String startGame() {
        boolean gameOver = false;
        while (!gameOver) {
            Player currentPlayer = players.removeFirst();

            board.printBoard();
            List<Pair<Integer, Integer>> freeSpaces = board.getFreeCells();
            if (freeSpaces.isEmpty()) {
                gameOver = true;
                continue;
            }

            System.out.print("Player: " + currentPlayer.getName() + " Enter row, col: ");
            Scanner scanner = new Scanner(System.in);
            String s = scanner.nextLine();
            String[] values = s.split(",");
            int row = Integer.parseInt(values[0]);
            int col = Integer.parseInt(values[1]);

            boolean addPiece = board.addPiece(row, col, currentPlayer.getPiece());

            if (!addPiece) {
                System.out.println("Incorrect position");
                players.addFirst(currentPlayer);
                continue;
            }
            players.addLast(currentPlayer);

            boolean winner = isThereWinner(row, col, currentPlayer.getPiece().pieceType);
            if (winner) {
                return currentPlayer.getName();
            }
        }
        return "Tie";
    }

    boolean isThereWinner(int row, int col, PieceType pieceType) {
        boolean rowMatch = true, colMatch = true, diagonalMatch = true, antiDiagonalMatch = true;
        for (int i = 0; i < board.size; i++) {
            if (board.board[row][i] == null || board.board[row][i].pieceType != pieceType) {
                rowMatch = false;
                break;
            }
        }

        for (int i = 0; i < board.size; i++) {
            if (board.board[i][col] == null || board.board[i][col].pieceType != pieceType) {
                colMatch = false;
                break;
            }
        }

        for (int i = 0; i < board.size; i++) {
            if (board.board[i][i] == null || board.board[i][i].pieceType != pieceType) {
                diagonalMatch = false;
                break;
            }
        }

        for (int i = 0; i < board.size; i++) {
            if (board.board[i][board.size - i - 1] == null || board.board[i][board.size - i - 1].pieceType != pieceType) {
                antiDiagonalMatch = false;
                break;
            }
        }

        return rowMatch || colMatch || diagonalMatch || antiDiagonalMatch;
    }
}
