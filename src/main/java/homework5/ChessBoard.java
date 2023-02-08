package homework5;

public class ChessBoard {
    private char[][] board = new char[8][8];

    public ChessBoard() {
        fillBoard();
    }

    private void fillBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = '-';
            }
        }
    }

    public int getSize() {
        return board.length;
    }

    public char[][] getBoard() {
        return board;
    }

    public void placeQueen(Queen queen) {
        board[queen.getX()][queen.getY()] = 'Q';
    }

    public void deleteQueen(Queen queen) {
        board[queen.getX()][queen.getY()] = '-';
    }


    public void drawBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
