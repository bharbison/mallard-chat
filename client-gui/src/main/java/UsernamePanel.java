import javax.swing.*;
import java.awt.*;

public class UsernamePanel extends JPanel{
    private JLabel userLabel;
    private JTextField userTF;

    public UsernamePanel(){
        this.setBackground(new Color( 1.0f, 1.0f, 1.0f, 0.0f));
        this.userLabel = new JLabel("Username: ");
        this.add(this.userLabel);

        this.userTF = new JTextField(20);
        this.userTF.setBackground(new Color(175, 193, 191));

        this.add(this.userLabel);
        this.add(this.userTF);
    }
    public JLabel getUserLabel(){
        return this.userLabel;
    }
    public JTextField getUserTextField(){
        return this.userTF;
    }
}