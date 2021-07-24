import javax.swing.*;

public class TitleBar extends JMenuBar {
    public TitleBar(JFrame frame, boolean exitOnly){
        //will be left aligned
        this.add(new AppTitle());

        //all below will be right aligned
        this.add(Box.createHorizontalGlue());

        if(!exitOnly){
            this.add(new MinimizeButton(frame));
            this.add(new MaximizeButton(frame));
        }

        this.add(new ExitButton(frame));
    }
}
