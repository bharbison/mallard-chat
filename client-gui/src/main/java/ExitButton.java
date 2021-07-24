import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExitButton extends JButton{
    JFrame frame;

    public ExitButton(JFrame frame){
        this.frame = frame;
        this.setText("\u2716");

        exitListener();
    }
    //this is bad. change later
    private void exitListener(){
        this.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg) {
                frame.dispose();
                System.exit(0);
            }
        });
    }
}
