package day17;

public class ChessBoard {
    private ChessPiece[][] chessPiecesArrangement;

    public ChessBoard(ChessPiece[][] chessPiecesArrangement) {
        this.chessPiecesArrangement = chessPiecesArrangement;
    }

    public void print() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < chessPiecesArrangement.length; j++) {
                stringBuilder.append(chessPiecesArrangement[i][j]);
            }
            stringBuilder.append("\n");
        }
        System.out.println(stringBuilder);
    }
}
