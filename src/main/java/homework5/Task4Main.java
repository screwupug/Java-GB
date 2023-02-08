package homework5;

public class Task4Main {

    public static void main(String[] args) {
        ChessBoard chessBoard = new ChessBoard();
        tryToPlaceQueen(chessBoard, 0);
    }

    public static void tryToPlaceQueen(ChessBoard chessBoard, int row) {
        if (row == chessBoard.getSize()) {
            chessBoard.drawBoard();
            return;
        }
        for (int i = 0; i < chessBoard.getSize(); i++) {
            Queen queen = new Queen(row, i);
            if (queen.isSave(chessBoard.getBoard())) {
                chessBoard.placeQueen(queen);
                tryToPlaceQueen(chessBoard, row + 1);
                chessBoard.deleteQueen(queen);
            }
        }
    }



}
