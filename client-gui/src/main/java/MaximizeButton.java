import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MaximizeButton extends JButton {
    JFrame frame;

    public MaximizeButton (JFrame frame){
        this.frame = frame;
        this.setText("\uD83D\uDDD6");

        maximizeListener();
    }
    private void maximizeListener(){
        this.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg) {
                if(frame.getExtendedState() == frame.NORMAL) {
                    frame.setExtendedState(frame.MAXIMIZED_BOTH);
                }
                else{
                    frame.setExtendedState(frame.NORMAL);
                }
            }
        });
    }
}
