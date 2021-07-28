import javax.swing.*;
import java.awt.*;

public class ChatWindow extends JFrame {

        public ChatWindow(String channelName, String userName){
                //remove default title-bar (because it looks terrible), allow the window to be visible, and set window color
                this.setUndecorated(true);
                this.setVisible(true);
                this.setBackground(new Color( 0.2f, 0.2f, 0.2f, 0.93f));

                //adds custom title-bar, with minimize, maximize, and exit buttons
                this.setJMenuBar(new TitleBar(this, false));

                //allows the window to be dragged
                DragListener dragListener = new DragListener(this);
                this.addMouseListener(dragListener);
                this.addMouseMotionListener(dragListener);

                //set size and when window is opened, opens at center of screen
                this.setSize(1000, 800);
                this.setLocationRelativeTo(null);

                ChatViewArea chatView = new ChatViewArea();

                ScrollableChatPanel scroll = new ScrollableChatPanel(chatView, channelName);

                //sets up the user text entry area, and send button.
                //Don't hardcode this
                SendEntryPanel textEntryPanel = new SendEntryPanel(chatView, scroll.getChatHistory(), userName);
                this.getRootPane().setDefaultButton(textEntryPanel.getSendButton());

                //puts tabs on the left of window, chat view in the center, and user text entry at the bottom.
                this.getContentPane().add(BorderLayout.LINE_START, new TabbedPanel());
                this.getContentPane().add(BorderLayout.CENTER, scroll);
                this.getContentPane().add(BorderLayout.PAGE_END, textEntryPanel);
        }
}
