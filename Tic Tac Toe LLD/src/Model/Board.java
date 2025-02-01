package Model;

import java.util.ArrayList;
import java.util.List;

import javafx.util.Pair;

public class Board {
    public int size;
    public PlayingPiece[][]board;

    public Board(int size) {
        this.size = size;
        board = new PlayingPiece[size][size];
    }

    public boolean addPiece(int x, int y, PlayingPiece piece) {
        if (board[x][y] != null) {
            return false;
        }
        board[x][y] = piece;
        return true;
    }

    public List<Pair<Integer, Integer>> getFreeCells() {
        List<Pair<Integer, Integer>> freeCells = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == null) {
                    Pair<Integer, Integer> rowCol = new Pair<>(i, j);
                    freeCells.add(rowCol);
                }
            }
        }

        return freeCells;
    }

    public void printBoard() {
        for (int i = 0; i < size; i++) {
            System.out.print("|");
            for (int j = 0; j < size; j++) {
                if (board[i][j] == null) {
                    System.out.print("  ");
                } else {
                    System.out.print(board[i][j].pieceType.name() + " ");
                }
                System.out.print("|");
            }
            System.out.println();
        }
    }
}
