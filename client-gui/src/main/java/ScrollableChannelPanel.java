import javax.swing.*;
import java.awt.Color;

public class ScrollableChannelPanel extends JScrollPane{
    public ScrollableChannelPanel(JPanel channelList){
        super(channelList);

        this.getViewport().setOpaque( false );
        this.setBackground(new Color( 1.0f, 1.0f, 1.0f, 0.0f));
    }
}
