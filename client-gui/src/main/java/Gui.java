import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Scanner;

class Gui {

    public static void main(String args[]) {
        try {
            UIManager.put( "control", new Color( 128, 128, 128) );
            UIManager.put( "info", new Color(128,128,128) );
            UIManager.put( "nimbusBase", new Color( 18, 30, 49) );
            UIManager.put( "nimbusAlertYellow", new Color( 248, 187, 0) );
            UIManager.put( "nimbusDisabledText", new Color( 128, 128, 128) );
            UIManager.put( "nimbusFocus", new Color(115,164,209) );
            UIManager.put( "nimbusGreen", new Color(176,179,50) );
            UIManager.put( "nimbusInfoBlue", new Color( 66, 139, 221) );
            UIManager.put( "nimbusLightBackground", new Color( 18, 30, 49) );
            UIManager.put( "nimbusOrange", new Color(191,98,4) );
            UIManager.put( "nimbusRed", new Color(169,46,34) );
            UIManager.put( "nimbusSelectedText", new Color( 255, 255, 255) );
            UIManager.put( "nimbusSelectionBackground", new Color( 104, 93, 156) );
            UIManager.put( "text", new Color( 230, 230, 230) );
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        }
        catch (Exception ex){
            System.out.println("look not found");
        }

        //**************************************
        //chat history

            //this should be in a different class (not in gui). probably need authentication, also
            final String userName = "Bob";

            //full text history --- should be imported from server later (stored in database)
            final ArrayList<String> chat_hist = new ArrayList<String>();
            //import from file
            try {
                File file = new File("chat_history.txt");
                Scanner scan = new Scanner(file);
                while(scan.hasNextLine())
                {
                    chat_hist.add(scan.nextLine());
                }
            }
            catch(FileNotFoundException ex){
                System.err.println(ex);
            }

        //**************************************

            JFrame frame = new JFrame("Mallard");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(1000, 800);

            JPanel panel = new JPanel();
            JLabel label = new JLabel("Enter Text");
            final JTextField tf = new JTextField(60);
            tf.setBackground(new Color( 175,193,191));
            JButton send = new JButton("Send");
            panel.add(label);
            panel.add(tf);
            panel.add(send);

            final JTextArea ta = new JTextArea();
            ta.setLineWrap(true);

            JScrollPane scroll = new JScrollPane(ta);

            frame.getContentPane().add(BorderLayout.SOUTH, panel);
            frame.getContentPane().add(BorderLayout.CENTER, scroll);
            frame.setVisible(true);

            for (String i : chat_hist) ta.append(i + "\n");
            ta.setCaretPosition(ta.getDocument().getLength());

            frame.getRootPane().setDefaultButton(send);

            send.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg) {
                    if(!tf.getText().equals("")) {
                        System.out.println(tf.getText());
                        String msg = userName.toUpperCase() + ": " + tf.getText() + "\n";
                        chat_hist.add(msg);
                        ta.append(msg);

                        //update db with new text
                        try {
                            Files.write(Paths.get(System.getProperty("user.dir") + "\\chat_history.txt"), msg.getBytes(), StandardOpenOption.APPEND);
                        } catch (IOException ex) {
                            System.err.println(ex);
                        }
                    }
                }
            });
        }
    }
