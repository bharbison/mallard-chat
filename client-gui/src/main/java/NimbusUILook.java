import javax.swing.UIManager;
import java.awt.Color;

public class NimbusUILook extends UIManager {
    public NimbusUILook(){
            try {
                this.put("control", new Color(128, 128, 128));
                this.put("info", new Color(128, 128, 128));
                this.put("nimbusBase", new Color(18, 30, 49));
                this.put("nimbusAlertYellow", new Color(248, 187, 0));
                this.put("nimbusDisabledText", new Color(128, 128, 128));
                this.put("nimbusFocus", new Color(115, 164, 209));
                this.put("nimbusGreen", new Color(176, 179, 50));
                this.put("nimbusInfoBlue", new Color(66, 139, 221));
                this.put("nimbusLightBackground", new Color(18, 30, 49));
                this.put("nimbusOrange", new Color(191, 98, 4));
                this.put("nimbusRed", new Color(169, 46, 34));
                this.put("nimbusSelectedText", new Color(255, 255, 255));
                this.put("nimbusSelectionBackground", new Color(104, 93, 156));
                this.put("text", new Color(230, 230, 230));
                this.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            } catch (Exception ex) {
                System.out.println("look not found");
            }
    }
}
