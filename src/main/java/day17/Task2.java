package day17;

public class Task2 {
    public static void main(String[] args) {
        ChessPiece[][] chessPiecesArrangement = new ChessPiece[8][8];
        chessPiecesArrangement[0][0] = chessPiecesArrangement[0][5] = ChessPiece.ROOK_BLACK;
        chessPiecesArrangement[0][6] = ChessPiece.KING_BLACK;
        chessPiecesArrangement[1][1] = chessPiecesArrangement[7][5] = ChessPiece.ROOK_WHITE;
        chessPiecesArrangement[1][4] = chessPiecesArrangement[1][5] = chessPiecesArrangement[1][7] = chessPiecesArrangement[2][0] = chessPiecesArrangement[2][6] = ChessPiece.PAWN_BLACK;
        chessPiecesArrangement[2][2] = ChessPiece.KNIGHT_BLACK;
        chessPiecesArrangement[3][0] = ChessPiece.QUEEN_BLACK;
        chessPiecesArrangement[3][3] = chessPiecesArrangement[5][4] = ChessPiece.BISHOP_WHITE;
        chessPiecesArrangement[4][3] = ChessPiece.BISHOP_BLACK;
        chessPiecesArrangement[4][4] = chessPiecesArrangement[5][5] = chessPiecesArrangement[6][0] = chessPiecesArrangement[6][5] = chessPiecesArrangement[6][7] = ChessPiece.PAWN_WHITE;
        chessPiecesArrangement[6][3] = ChessPiece.QUEEN_WHITE;
        chessPiecesArrangement[7][6] = ChessPiece.KING_WHITE;
        for (int i = 0; i < chessPiecesArrangement.length; i++) {
            for (int j = 0; j < chessPiecesArrangement.length; j++) {
                if (chessPiecesArrangement[i][j] == null) {
                    chessPiecesArrangement[i][j] = ChessPiece.EMPTY;
                }
            }
        }
        ChessBoard chessBoard = new ChessBoard(chessPiecesArrangement);
        chessBoard.print();
    }
}
