package model;

import java.util.ArrayList;

import view.Board;

public class Pawn extends Piece {
    private boolean isFirstMove;

    public Pawn(int xp, int yp, boolean isWhite, ArrayList<Piece> ps) {
        super(xp, yp, isWhite, "pawn", ps);
        isFirstMove = true;
    }

    public boolean isFirstMove() {
        return isFirstMove;
    }

    public void setFirstMove(boolean isFirstMove) {
        this.isFirstMove = isFirstMove;
    }

    @Override
    public void move(int xp, int yp) {
        // Kiểm tra xem vị trí mới có chứa quân cờ của đối thủ hay không
        Piece opponentPiece = Board.getPiece(xp * 64, yp * 64);
        if (opponentPiece != null) {
            // Nếu có, kiểm tra xem có thể tiến hóa quân cờ Pawn hay không
            if (canPromote(xp, yp)) {
                // Tiến hóa quân cờ Pawn thành quân cờ khác (ví dụ: Queen)
                promote(xp, yp);
                return;
            } else {
                // Nếu không, hủy quân cờ của đối thủ
                opponentPiece.kill();
            }
        }

        // Di chuyển quân cờ đến vị trí mới
        super.move(xp, yp);
        isFirstMove = false;
    }

    private boolean canPromote(int xp, int yp) {
        // Kiểm tra xem quân cờ Pawn đã đến hàng cuối cùng của bàn cờ hay chưa
        // Đối với quân cờ trắng, hàng cuối cùng là hàng đầu tiên (yp = 0)
        // Đối với quân cờ đen, hàng cuối cùng là hàng cuối cùng (yp = 7)
        return (isWhite && yp == 0) || (!isWhite && yp == 7);
    }

    private void promote(int xp, int yp) {
        // Tiến hóa quân cờ Pawn thành quân cờ Queen
        // Tạo một đối tượng quân cờ Queen tại vị trí mới
        new Queen(xp, yp, isWhite, ps);

        // Xóa quân cờ Pawn khỏi danh sách
        ps.remove(this);
    }
}