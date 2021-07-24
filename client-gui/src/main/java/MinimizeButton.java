import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MinimizeButton extends JButton {
    JFrame frame;

    public MinimizeButton (JFrame frame){
        this.frame = frame;
        this.setText("\uD83D\uDDD5");

        minimizeListener();
    }
    private void minimizeListener(){
        this.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg) {
                frame.setState(frame.ICONIFIED);
            }
        });
    }
}
