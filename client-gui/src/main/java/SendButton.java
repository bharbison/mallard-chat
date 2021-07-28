import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

//add listener stuff later (publish msg to Kafka topic)
public class SendButton extends JButton {
    private JTextArea textArea;
    private JTextField textField;
    ArrayList<String> chatHistory;
    String userName;

    public SendButton(JTextArea textArea, JTextField textField, ArrayList<String> chatHistory, String userName) {
        this.textArea = textArea;
        this.textField = textField;
        this.chatHistory = chatHistory;
        this.userName = userName;

        this.setText("Send");

        pressListener();
    }

    private void pressListener() {
        this.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg) {
                if (!textField.getText().equals("")) {
                    //This needs to be changed to a publish to topic once Kafka is implemented
                    // need to change this to send to sentiment analysis script, then append with sentiment (mapped to emoji)
                    String msg = userName.toUpperCase() + ": " + textField.getText() + Emoji.SMILE.getCode() + "\n";
                    chatHistory.add(msg);
                    textArea.append(msg);
                }
            }
        });
    }
}
//    private void pressListener(){
 //       this.addActionListener(new ActionListener() {
 //           public void actionPerformed(ActionEvent arg) {
  //          if (!this.textField.getText().equals("")) {
 //               // need to change this to send to sentiment analysis script, then append with sentiment (mapped to emoji)
 //               String msg = userName.toUpperCase() + ": " + this.textField.getText() + Emoji.SMILE.getCode() + "\n";
 //               chat_hist.add(msg);
 //               this.textArea.append(msg);
 //               }
   //         }
   //         });
   // }