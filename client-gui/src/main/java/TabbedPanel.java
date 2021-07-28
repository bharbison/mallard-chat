import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;

public class TabbedPanel extends JTabbedPane {

    public TabbedPanel(){
        this.setPreferredSize(new Dimension(180, 600));

        JPanel peoplePanel = new JPanel();
        peoplePanel.setBackground(new Color(18, 30, 49));
        this.add("People", peoplePanel);

        JPanel channelPanel = new JPanel();
        channelPanel.setBackground(new Color(18, 30, 49));
        this.add("Channels", channelPanel);
    }
}
