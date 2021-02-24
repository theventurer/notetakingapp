import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DrawArea extends JComponent{
    
    // Image in which we will draw
    Image image;
    // Graphics2D object to draw on
    Graphics2D g2;
    // Mouse coordinates
    int currX, currY, oldX, oldY;

    public DrawArea() {
        setDoubleBuffered(false);
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                // Save coorinates x,y when mouse is pressed
                oldX = e.getX();
                oldY = e.getY();
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                // Coordinates x,y when mouse is dragged
                currX = e.getX();
                currY = e.getY();

                if(g2 != null) {
                    // Draw line if g2 context is not null
                    g2.drawLine(oldX, oldY, currX, currY);
                    // Refresh draw area to repaint
                    repaint();
                    // Stores current coordinates x,y as old x,y
                    oldX = currX;
                    oldY = currY;
                }
            }
        });
    }

    protected void paintComponent(Graphics g) {
        if(image == null) {
            // Image to draw null => we create
            image = createImage(getSize().width, getSize().height);
            g2 = (Graphics2D)image.getGraphics();
            //Enable antialiasing
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            // Clear Draw Area
            clear();
        }
        g.drawImage(image, 0, 0, null);
    }

    // Create exposed Methods

    public void clear() {
        g2.setPaint(Color.white);
        // Draw white on entire draw area to clear
        g2.fillRect(0, 0, getSize().width, getSize().height);
        g2.setPaint(Color.black);
        repaint();
    }

    public void red() {
        // Apply red color on g2 context
        g2.setPaint(Color.red);
    }
    public void black() {
        // Apply black color on g2 context
        g2.setPaint(Color.black);
    }
    public void magenta() {
        // Apply magenta color on g2 context
        g2.setPaint(Color.magenta);
    }
    public void green() {
        // Apply green color on g2 context
        g2.setPaint(Color.green);
    }
    public void blue() {
        // Apply blue color on g2 context
        g2.setPaint(Color.blue);
    }
    public void erase() {
        // Apply blue color on g2 context
        g2.setPaint(Color.white);
    }
}