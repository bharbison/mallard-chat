import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Scanner;

public class ChatWindow extends JFrame {
        public ChatWindow(){
                //**************************************
                //final String userName = getUser();

                final ArrayList<String> chat_hist = getChatHistory();

                //**************************************
                this.setUndecorated(true);
                this.setBackground(new Color( 0.2f, 0.2f, 0.2f, 0.93f));

                DragListener dragListener = new DragListener(this);
                this.addMouseListener(dragListener);
                this.addMouseMotionListener(dragListener);

                this.setSize(1000, 800);
                this.setLocationRelativeTo(null);

                this.setJMenuBar(new TitleBar(this, false));

                JPanel textEntryPanel = new JPanel();
                JLabel label = new JLabel("Enter Text");
                final JTextField tf = new JTextField(60);
                tf.setBackground(new Color(175, 193, 191));
                JButton send = new JButton("Send");
                textEntryPanel.add(label);
                textEntryPanel.add(tf);
                textEntryPanel.add(send);

                final JTextArea ta = new JTextArea();
                ta.setBackground(new Color( 1.0f, 1.0f, 1.0f, 0.0f));
                ta.setLineWrap(true);

                JScrollPane scroll = new JScrollPane(ta);
                scroll.getViewport().setOpaque( false );
                scroll.setBackground(new Color( 1.0f, 1.0f, 1.0f, 0.0f));

                JTabbedPane infoPanel = new JTabbedPane();
                infoPanel.setPreferredSize(new Dimension(180, 600));
                JPanel peoplePanel = new JPanel();
                peoplePanel.setBackground(new Color(18, 30, 49));
                JPanel channelPanel = new JPanel();
                channelPanel.setBackground(new Color(18, 30, 49));

                infoPanel.add("People", peoplePanel);
                infoPanel.add("Channels", channelPanel);

                this.getContentPane().add(BorderLayout.LINE_START, infoPanel);
                this.getContentPane().add(BorderLayout.CENTER, scroll);
                this.getContentPane().add(BorderLayout.PAGE_END, textEntryPanel);

                this.setVisible(true);

                for (String i : chat_hist){
                    ta.append(i + "\n");
                }
                ta.setCaretPosition(ta.getDocument().getLength());

                this.getRootPane().setDefaultButton(send);

                //send.addActionListener(new ActionListener() {
                //    public void actionPerformed(ActionEvent arg) {
                //        if (!tf.getText().equals("")) {
                            // need to change this to send to sentiment analysis script, then append with sentiment (mapped to emoji)
                            //String msg = userName.toUpperCase() + ": " + tf.getText() + Emoji.SMILE.getCode() + "\n";
                            //chat_hist.add(msg);
                            //ta.append(msg);

                            //saveNewMsg(msg);
                 //       }
                //    }
                //});

            }
    private ArrayList<String> getChatHistory() {
        //**************************************
        //full text history --- should be imported from server later (stored in database)
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

    private void saveNewMsg(String msg) {
        //update db with new text
        try {
            Files.write(Paths.get(System.getProperty("user.dir") + "\\chat_history.txt"), msg.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
    }
