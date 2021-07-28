import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SendEntryPanel extends JPanel {
    private JTextArea textArea;
    private JTextField textField;
    private SendButton send;

    public SendEntryPanel(JTextArea textArea, ArrayList<String> chatHistory, String userName){
        this.textArea = textArea;
        this.textField = new JTextField(60);
        this.textField.setBackground(new Color(175, 193, 191));

        this.add(new JLabel("Enter Text"));
        this.add(this.textField);

        //Don't hardcode this
        this.send = new SendButton(this.textArea, this.textField, chatHistory, userName);
        this.add(this.send);
    }
    public JTextField getTextField(){
        return this.textField;
    }
    public SendButton getSendButton(){
        return this.send;
    }
}
