import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.cognitoidp.AWSCognitoIdentityProviderClient;
import com.amazonaws.services.cognitoidp.model.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class LoginButton extends JButton {
    JFrame frame;
    JTextField userTF;
    JTextField passTF;

    public LoginButton(JFrame frame, JTextField userTF, JTextField passTF){
        this.frame = frame;
        this.userTF = userTF;
        this.passTF = passTF;

        this.setText("Login");

        pressListener();
    }
    private void pressListener(){
            this.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg) {
                    if (userTF.getText().equals("")) {
                        System.out.println("error, no username");
                    } else if (passTF.getText().equals("")) {
                        System.out.println("error, no password");
                    } else {
                        //try to login as user
                        boolean failedAttempt = login();

                        //if credentials approved, switch to channel view
                        if(!failedAttempt) {
                            frame.dispose();
                            new ChannelSelectWindow(userTF.getText());
                        }
                    }
                }
            });
    }
    private boolean login(){
        BasicAWSCredentials credentials = new BasicAWSCredentials("AKIA5AN72NACHEHRS4FP", "nRdwtFGLrUcW4aq4ubVtl7PvUdDhmrCXUNH8avEf");

        AWSCognitoIdentityProviderClient client = new AWSCognitoIdentityProviderClient(credentials).withRegion(Regions.US_EAST_2);

        HashMap authParams = new HashMap<>();
        authParams.put("USERNAME", this.userTF.getText());
        authParams.put("PASSWORD", this.passTF.getText());

        //should create a panel with text to inform the user that the login failed later
        boolean failedAttempt = true;
            try {
                InitiateAuthRequest initiateAuthRequest = new InitiateAuthRequest().withClientId("5br30fh1mkrkn6r6ir7bf92obp").withAuthFlow(AuthFlowType.USER_PASSWORD_AUTH).withAuthParameters(authParams);
                System.out.println(client.initiateAuth(initiateAuthRequest));
                failedAttempt = false;
            } catch (NotAuthorizedException e) {
                System.err.println(e);
            }

            return failedAttempt;
    }
}
