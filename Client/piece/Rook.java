/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piece;

import Board.Board;
import Move.Move;
import Board.Tile;
import resources.PIECE_Configurations;
import Utility.BoardUtilities;
import java.util.ArrayList;
import java.util.List;
import resources.BOARD_Configurations;


/**
 *
 * @author Enes Kızılcın <nazifenes.kizilcin@stu.fsm.edu.tr>
 */
public class Rook extends Piece{

    public Rook(Team team)
    {
        super(team,PieceTypes.ROOK);
    }
    
    @Override
    public List<Move> availableMoves(Board board,Coordinate currentCoord) {
         List<Move> possibleMoves = new ArrayList<Move>();
        Tile currentTile = board.getTile(currentCoord);
        Tile destinationTile;
        Coordinate destinationCoordinate;
        for (Coordinate coord : PIECE_Configurations.ROOK_MOVES) {
            destinationCoordinate = currentCoord;
            while (BoardUtilities.isValidCoordinate(destinationCoordinate.plus(coord))) {
                destinationCoordinate = destinationCoordinate.plus(coord);
                destinationTile = board.getTile(destinationCoordinate);
                if (!destinationTile.hasPiece()) {
                    possibleMoves.add(new Move(board, currentTile, destinationTile));
                } else {
                    if (destinationTile.getPiece().getTeam() != this.getTeam()) {
                        possibleMoves.add(new Move(board, currentTile, destinationTile));
                        break;
                    } else {
                        break;
                    }
                }
            }
        }
        return possibleMoves;
    }
 
}
