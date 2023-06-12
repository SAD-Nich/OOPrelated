import java.util.LinkedList;
// using linked list for the pieces
// the Piece class for the addition of the pieces of the board
public class Piece {
    int xp;
    int yp;
    int x;
    int y;
    boolean white;
    LinkedList<Piece> pc;
    String name;
    public Piece(int xp, int yp, boolean white, String n, LinkedList<Piece> pc) {
        this.xp = xp;
        this.yp = yp;
        x = xp*104;
        y = yp*104;
        this.white = white;
        this.pc = pc;
        pc.add(this);
        name = n;
    }
    // function to determine the sitting place of the pieces, to not eat the same color, to be able to go back to the beginning of the position of the board
    // and to kill the different color of the pieces
    public void piecemovements(int xp, int yp){
        if(Board.DragPiece(xp*104, yp*104)!=null){
            if(Board.DragPiece(xp*104, yp*104).white!=white){
                Board.DragPiece(xp*104, yp*104).kill();
            }
            else{
                x = this.xp*104;
                y = this.yp*104;
                return;
            }
        }
        this.xp = xp;
        this.yp = yp;
        x = xp*104;
        y = yp*104;
    }
    // to remove or to kill, remove the pieces from the linked list
    public void kill(){
        pc.remove(this);
    }
}
