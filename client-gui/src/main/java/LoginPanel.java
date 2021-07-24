import javax.swing.*;
import java.awt.*;

public class LoginPanel extends JPanel {
    LoginButton loginButton;

    public LoginPanel(JFrame frame, UsernamePanel userPanel, PasswordPanel passPanel){
        this.setBackground(new Color( 1.0f, 1.0f, 1.0f, 0.0f));

        LoginButton loginButton = new LoginButton(frame, userPanel.getUserTextField(), passPanel.getPassTextField());
        this.add(loginButton);

        this.loginButton = loginButton;
    }

    public LoginButton getLoginButton() {
        return this.loginButton;
    }
}
