import javax.swing.*;
import java.awt.*;

public class PasswordPanel extends JPanel {
    private JLabel passLabel;
    private JTextField passTF;

    public PasswordPanel(){
        this.setBackground(new Color( 1.0f, 1.0f, 1.0f, 0.0f));
        this.passLabel = new JLabel("Password:  ");
        this.add(this.passLabel);

        this.passTF = new JTextField(20);
        this.passTF.setBackground(new Color(175, 193, 191));

        this.add(this.passLabel);
        this.add(this.passTF);
    }
    public JLabel getPassLabel(){
        return this.passLabel;
    }
    public JTextField getPassTextField(){
        return this.passTF;
    }
}
