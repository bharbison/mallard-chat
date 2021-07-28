import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Scanner;

class Gui {
    public static void main(String[] args) {
        NimbusUILook nimbusLook = new NimbusUILook();

        LoginWindow login = new LoginWindow();
    }
    private static ArrayList<String> getChatHistory() {
        //**************************************
        //full text history --- should be imported from server later (stored in database)
        final ArrayList<String> chat_hist = new ArrayList<>();
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

    private static void saveNewMsg(String msg) {
        //update db with new text
        try {
            Files.write(Paths.get(System.getProperty("user.dir") + "\\chat_history.txt"), msg.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}
