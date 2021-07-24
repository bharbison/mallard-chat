import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DragListener extends MouseAdapter{
    private JFrame frame;
    private int posX=0,posY=0;

    public DragListener(JFrame frame) {
        this.frame = frame;
    }
    public void mousePressed(MouseEvent e){
            posX=e.getX();
            posY=e.getY();
    }
    public void mouseDragged(MouseEvent e){
        frame.setLocation (e.getXOnScreen()-posX,e.getYOnScreen()-posY);
    }
}
