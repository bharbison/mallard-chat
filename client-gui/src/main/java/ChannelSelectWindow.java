import javax.swing.*;
import java.awt.Color;

public class ChannelSelectWindow extends JFrame {
    public ChannelSelectWindow(String userName){
        //remove default title-bar (because it looks terrible), allow the window to be visible, and set window color
        this.setUndecorated(true);
        this.setVisible(true);
        this.setResizable(false);
        this.setBackground(new Color( 0.2f, 0.2f, 0.2f, 0.93f));

        //set size and when window is opened, opens at center of screen
        this.setSize(150, 200);
        this.setLocationRelativeTo(null);

        //adds custom title-bar, with minimize, maximize, and exit buttons
        this.setJMenuBar(new TitleBar(this, true));

        //allows the window to be dragged
        DragListener dragListener = new DragListener(this);
        this.addMouseListener(dragListener);
        this.addMouseMotionListener(dragListener);

        this.getContentPane().add(new ScrollableChannelPanel(new ChannelList(this, userName)));
    }
}
