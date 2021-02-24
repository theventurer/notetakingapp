import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Container;

public class SwingPaint {
    
    JButton clearBtn, blackBtn, blueBtn, greenBtn, redBtn, magBtn, eraseBtn;
    DrawArea drawarea;
    ActionListener actionListener = new ActionListener() {

        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == clearBtn) {
                drawarea.clear();
            }
            else if(e.getSource() == blackBtn) {
                drawarea.black();
            }
            else if(e.getSource() == blueBtn) {
                drawarea.blue();
                
            }
            else if(e.getSource() == greenBtn) {
                drawarea.green();                
            }
            else if(e.getSource() == redBtn) {
                drawarea.red();                
            }
            else if(e.getSource() == magBtn) {
                drawarea.magenta();                
            }
            else if(e.getSource() == eraseBtn) {
                drawarea.erase();                
            }
        }
    };

    public static void main(String args[]) {
        new SwingPaint().show();
    }

    public void show() {
        // Create main frame
        JFrame f = new JFrame("Swing Paint");
        Container content = f.getContentPane();
        // Set Layout on content pane
        content.setLayout(new BorderLayout());
        // Create draw area
        drawarea = new DrawArea();

        // Add to content pane
        content.add(drawarea, BorderLayout.CENTER);

        // Create controls to apply colors and call clear features
        JPanel controls = new JPanel();

        clearBtn = new JButton("Clear");
        clearBtn.addActionListener(actionListener);
        blackBtn = new JButton("Black");
        blackBtn.addActionListener(actionListener);
        blueBtn = new JButton("Blue");
        blueBtn.addActionListener(actionListener);
        greenBtn = new JButton("Green");
        greenBtn.addActionListener(actionListener);
        redBtn = new JButton("Red");
        redBtn.addActionListener(actionListener);
        magBtn = new JButton("Magenta");
        magBtn.addActionListener(actionListener);
        eraseBtn = new JButton("Erase");
        eraseBtn.addActionListener(actionListener);

        // Add to panel
        controls.add(greenBtn);
        controls.add(blueBtn);
        controls.add(blackBtn);
        controls.add(redBtn);
        controls.add(magBtn);
        controls.add(eraseBtn);
        controls.add(clearBtn);

        // Add to content pane
        content.add(controls, BorderLayout.NORTH);

        f.setSize(800, 800);
        // Can close frame
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // show the swing paint result
        f.setVisible(true);
    }
}
