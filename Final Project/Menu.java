import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.*;
import java.io.IOException;
import javax.imageio.ImageIO;
public class Menu {
    // the image in the menu
    public BufferedImage image;
    // the click here button
    public Rectangle clickButton = new Rectangle(59, 10, 530, 80);
    // the writings on the menu screen
    public void render(Graphics welcomeGraphics) throws IOException{
        // the source image for the hikaru image on the menu screen
        image = ImageIO.read(getClass().getResourceAsStream("/hikaru.png"));
        Graphics2D g2d = (Graphics2D) welcomeGraphics;
        // the settings for the writings and the click here button
        g2d.draw(clickButton);
        g2d.drawImage(image,300,380,450,450,null);
        Font font = new Font("Times New Roman",Font.BOLD, 70);
        Font font2 = new Font("Taban",Font.BOLD, 40);
        Font font3 = new Font("Arial",Font.BOLD,15);
        welcomeGraphics.setFont(font);
        welcomeGraphics.setColor(Color.darkGray);
        welcomeGraphics.drawString("Hello, click here!", 70, 70);
        welcomeGraphics.setFont(font2);
        welcomeGraphics.drawString("tis' a chess board simulator", 300,150);
        welcomeGraphics.drawString("to quit, close the window!", 400, 200);
        welcomeGraphics.setFont(font3);
        welcomeGraphics.drawString("This chess board can be used to play a game of chess", 300, 300);
        welcomeGraphics.drawString("the chess board can be a good tool to practice and analyze as well", 350, 340);
    }
    
}
