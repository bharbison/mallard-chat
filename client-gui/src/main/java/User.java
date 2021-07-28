//username taken from login
//could add a login token here, also
public class User {
    private static String currentUser;

    User(String username){
        this.currentUser = username;
    }
    public String getUsername(){
        return currentUser;
    }
}