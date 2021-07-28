import javax.swing.*;
import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ScrollableChatPanel extends JScrollPane {
    private JTextArea textArea;
    private ArrayList<String> chatHist;

    public ScrollableChatPanel(JTextArea textArea, String channelName){
        super(textArea);
        this.textArea = textArea;

        this.chatHist = loadChatHistory(channelName);
        for (String i : this.chatHist){
             this.textArea.append(i + "\n");
        }

        this.textArea.setCaretPosition(this.textArea.getDocument().getLength());

        this.getViewport().setOpaque( false );
        this.setBackground(new Color( 1.0f, 1.0f, 1.0f, 0.0f));
    }
    //channelName will later be used to get data from a specific Kafka topic
    private ArrayList<String> loadChatHistory(String ChannelName) {
        //**************************************
        //full text history --- should be imported from kafka topic later
        ArrayList<String> chat_hist = new ArrayList<>();
        //import from file
        try {
            File file = new File("chat_history.txt");
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                chat_hist.add(scan.nextLine());
            }
            return chat_hist;
        } catch (FileNotFoundException ex) {
            System.err.println(ex);
            return chat_hist;
        }
        //**************************************
    }
    public JTextArea getTextArea(){
        return textArea;
    }
    public ArrayList<String> getChatHistory(){
        return this.chatHist;
    }
}
