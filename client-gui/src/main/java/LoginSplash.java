import javax.swing.*;
import java.awt.*;

public class LoginSplash extends JFrame {
    public LoginSplash(){
        this.setUndecorated(true);
        this.setResizable(false);
        this.setBackground(new Color( 0.2f, 0.2f, 0.2f, 0.93f));

        DragListener dragListener = new DragListener(this);
        this.addMouseListener(dragListener);
        this.addMouseMotionListener(dragListener);

        this.setSize(360, 150);
        this.setLocationRelativeTo(null);

        this.setJMenuBar(new TitleBar(this, true));

        UsernamePanel userPanel = new UsernamePanel();
        PasswordPanel passPanel = new PasswordPanel();
        LoginPanel loginPanel = new LoginPanel(this, userPanel, passPanel);
        this.getRootPane().setDefaultButton(loginPanel.getLoginButton());

        this.getContentPane().add(BorderLayout.NORTH, userPanel);
        this.getContentPane().add(BorderLayout.CENTER, passPanel);
        this.getContentPane().add(BorderLayout.SOUTH, loginPanel);

        this.setVisible(true);
    }
}