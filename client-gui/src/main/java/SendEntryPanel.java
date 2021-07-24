import javax.swing.*;
import java.awt.*;

public class SendEntryPanel extends JPanel {
    private JTextField textField;

    public SendEntryPanel(){
        JLabel label = new JLabel("Enter Text");
        this.textField = new JTextField(60);
        this.textField.setBackground(new Color(175, 193, 191));
        JButton send = new JButton("Send");

        this.add(label);
        this.add(this.textField);
        this.add(send);
    }
}
