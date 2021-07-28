import javax.swing.*;
import java.awt.Color;

public class ChatViewArea extends JTextArea {

    public ChatViewArea(){
        this.setBackground(new Color( 1.0f, 1.0f, 1.0f, 0.0f));
        this.setLineWrap(true);
    }
}
