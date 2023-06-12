import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

public class Board {
    // this is for the separation of the menu and the board screen
    public static enum STATES{
        MENU,
        BOARD
    };
    public static STATES status = STATES.MENU;
    public static Menu menu;
    // the linked list is used to keep track of the pieces of the chess board
    public static LinkedList<Piece> pc = new LinkedList<Piece>();
    // this functions is used to help with the dragging of the chess pieces, to get the position of the boards and panels of the board
    public static Piece draggedPiece = null;
    public static Piece DragPiece(int x, int y){
        int xp = x/104;
        int yp = y/104;
        for (Piece p : pc){
            if (p.xp == xp && p.yp == yp){
                return p;
            }
        }
        return null;
    }
    // the main class or argument main method whatever it is called
    public static void main(String[] args) throws IOException{
        // the menu
        menu = new Menu();
        // the reference image file for the chess pieces
        BufferedImage all=ImageIO.read(new File("C:\\Users\\Nicholaus\\Desktop\\SAD\\cs\\code\\javashit\\java chess\\chesstraditional\\chess.png"));
        // the frame for the workspace or the size of the board
        JFrame frame = new JFrame();
        frame.setBounds(10, 10, 1100, 870);
        // to make the frame windowed
        frame.setUndecorated(false);
        // the title
        frame.setTitle("Chess Board Simulator");
        // to make the board not resizable
        frame.setResizable(false);
        // to cut the image from the chess piece image and index them to be used as different icons for each pieces
        Image imgs[]=new Image[12];
        int ind=0;
        for(int y=0;y<400;y+=200){
            for(int x=0;x<1200;x+=200){
            imgs[ind]=all.getSubimage(x, y, 200, 200).getScaledInstance(104, 104, BufferedImage.SCALE_SMOOTH);
            ind++;
            }    
        }
        //literally every black piece visible on the board and next to it
        Piece blackrook = new Piece(0, 0, false, "ROOK", pc);
        Piece blackknight = new Piece(1, 0, false, "KNIGHT", pc);
        Piece blackbishop = new Piece(2,0, false, "BISHOP", pc);
        Piece blackqueen = new Piece(3,0, false, "QUEEN", pc);
        Piece blackking = new Piece(4,0, false, "KING", pc);
        Piece blackkingbishop = new Piece(5,0, false, "BISHOP", pc);
        Piece blackkingknight = new Piece(6,0, false, "KNIGHT", pc);
        Piece blackkingrook = new Piece(7,0, false, "ROOK",pc);
        Piece bpawn1 = new Piece(1, 1, false, "PAWN", pc);
        Piece bpawn2 = new Piece(2, 1, false, "PAWN", pc);
        Piece bpawn3 = new Piece(3, 1, false, "PAWN", pc);
        Piece bpawn4 = new Piece(4, 1, false, "PAWN", pc);
        Piece bpawn5 = new Piece(5, 1, false, "PAWN", pc);
        Piece bpawn6 = new Piece(6, 1, false, "PAWN", pc);
        Piece bpawn7 = new Piece(7, 1, false, "PAWN", pc);
        Piece bpawn8 = new Piece(0, 1, false, "PAWN", pc);
        Piece ExtraBBish = new Piece(8,2,false, "BISHOP", pc);
        Piece ExtraBQueen = new Piece(8,3,false, "QUEEN", pc);
        Piece ExtraBKnight = new Piece(8,4,false, "KNIGHT", pc);
        Piece ExtraBRook = new Piece(8,5,false, "Rook", pc);

        // literally every white piece that is visible on the board and next to it for extras and promotions
        Piece wrook = new Piece(0, 7, true, "ROOK", pc);
        Piece wkinght = new Piece(1, 7, true, "KNIGHT", pc);
        Piece wbishop = new Piece(2, 7, true, "BISHOP", pc);
        Piece wqueen = new Piece(3, 7, true, "QUEEN", pc);
        Piece wking = new Piece(4, 7, true, "KING", pc);
        Piece wbishop2 = new Piece(5, 7, true, "BISHOP", pc);
        Piece wkight2 = new Piece(6, 7, true, "KNIGHT", pc);
        Piece wrook2 = new Piece(7, 7, true, "ROOK", pc);
        Piece wpawn1 = new Piece(1, 6, true, "PAWN", pc);
        Piece wpawn2 = new Piece(2, 6, true, "PAWN", pc);
        Piece wpawn3 = new Piece(3, 6, true, "PAWN", pc);
        Piece wpawn4 = new Piece(4, 6, true, "PAWN", pc);
        Piece wpawn5 = new Piece(5, 6, true, "PAWN", pc);
        Piece wpawn6 = new Piece(6, 6, true, "PAWN", pc);
        Piece wpawn7 = new Piece(7, 6, true, "PAWN", pc);
        Piece wpawn8 = new Piece(0, 6, true, "PAWN", pc);
        Piece ExtraWBish = new Piece(9, 2, true, "Bishop", pc);
        Piece ExtraWQueen = new Piece(9, 3, true, "queen", pc);
        Piece ExtraWKnight = new Piece(9, 4, true, "Knight", pc);
        Piece ExtraWRook = new Piece(9, 5, true, "Rook", pc);

        // the panel used for drawing the white and black squares
        JPanel panel = new JPanel(){
            @Override
            public void paint(Graphics g){
                boolean colorwhite = true;
                if(status == STATES.BOARD){
                    for(int y= 0; y<8; y++){
                        for(int x=0;x<8;x++){ // the colors of the squares
                            if(colorwhite){
                                g.setColor(Color.white);
                            }else{
                                g.setColor(new Color(120,150,80));
                            }
                            g.fillRect(y*104, x*104, 104, 104);
                            colorwhite=!colorwhite;
                            }
                         colorwhite=!colorwhite;
                        }
                        for(Piece p : pc){ // indexing and naming the pieces
                            int index = 0;
                            if(p.name.equalsIgnoreCase("KING")){
                                index = 0;
                            }
                            if(p.name.equalsIgnoreCase("QUEEN")){
                                index = 1;
                            }
                            if(p.name.equalsIgnoreCase("BISHOP")){
                                index = 2;
                            }
                            if(p.name.equalsIgnoreCase("KNIGHT")){
                                index = 3;
                            }
                            if(p.name.equalsIgnoreCase("ROOK")){
                                index = 4;
                            }
                            if(p.name.equalsIgnoreCase("PAWN")){
                                index = 5;
                            }
                            if(!p.white){
                                index += 6;
                            }
                            g.drawImage(imgs[index], p.x, p.y, this);
                        }
                }
                // rendering the things on the menu screen
                else if(status == STATES.MENU) {
                    try {
                        menu.render(g);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        // the add panel function for the files
        frame.add(panel);
        // the mouse sensor or listener to drag the pieces of the chess board
        frame.addMouseMotionListener(new MouseMotionListener(){
            @Override
            public void mouseDragged(MouseEvent e){
                if(draggedPiece!=null){
                    draggedPiece.x = e.getX()-52;
                    draggedPiece.y = e.getY()-52;
                    frame.repaint();
                }
            }

            @Override
            public void mouseMoved(MouseEvent e) {}
        });
        frame.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
            }
            @Override
            public void mousePressed(MouseEvent e) {
                draggedPiece=DragPiece(e.getX(), e.getY());
                if(status==STATES.MENU) {
                    int nx = e.getX();
                    int ny = e.getY();
                    if(nx >= 70 && nx <= 600){
                        if(ny >= 70 && ny <= 200){
                            Board.status = Board.STATES.BOARD;
                        }
                    }
                }
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                draggedPiece.piecemovements(e.getX()/104, e.getY()/104);
                frame.repaint();
            }
            @Override
            public void mouseEntered(MouseEvent e) {
            }
            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        // to close the operation when the window is closed
        frame.setDefaultCloseOperation(3);
        // to make the frame visible
        frame.setVisible(true);
    }
    
}