//username taken from login
public class User {
    private static String currentUser;

    User(String username){
        this.currentUser = username;
    }
    public String getUsername(){
        return currentUser;
    }
}