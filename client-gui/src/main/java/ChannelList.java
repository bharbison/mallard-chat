import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChannelList extends JPanel {
    JFrame frame;
    String userName;
    private String[] channelNames;

    public ChannelList(JFrame frame, String userName){
        this.frame = frame;
        this.userName = userName;
        getAllChannels();

        this.setLayout(new GridLayout(0,1));

        for (String i : this.channelNames){
            JButton channelButton = new JButton(i);
            pressListener(channelButton);
            this.add(channelButton);
        }
    }
    private void getAllChannels(){
        //placeholder. change to get all topics from Kafka (where a topic is a channel)
        this.channelNames = new String[] {"channel1", "channel2", "channel3", "channel4", "channel5", "channel6", "channel7", "channel8"};
    }
    //should pass in a parameter with the channel-data, for multiple different channels
    private void pressListener(JButton channelButton){
        channelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg) {
                frame.dispose();
                //goto main window
                new ChatWindow(((JButton)arg.getSource()).getText(), userName);
            }
        });
    }
}
