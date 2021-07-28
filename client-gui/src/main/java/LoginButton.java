import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginButton extends JButton {
    JFrame frame;
    JTextField userTF;
    JTextField passTF;

    public LoginButton(JFrame frame, JTextField userTF, JTextField passTF){
        this.frame = frame;
        this.userTF = userTF;
        this.passTF = passTF;

        this.setText("Login");

        pressListener();
    }
    private void pressListener(){
            this.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg) {
                    if (userTF.getText().equals("")) {
                        System.out.println("error, no username");
                    } else if (passTF.getText().equals("")) {
                        System.out.println("error, no password");
                        //should not be hardcoded. replace with db query
                    } else if (userTF.getText().equals("Bob") & passTF.getText().equals("1234")) {
                        frame.dispose();
                        //goto main window
                        //new ChatWindow();
                        new ChannelSelectWindow();
                    } else {
                        System.out.println("error, invalid credentials");
                    }
                }
            });
    }
}
