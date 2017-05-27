package mx.ohanahome.firebaseexample;

/**
 * Created by Ken on 26/05/17.
 */
public class ChatObject {

    private String message;
    private String username;

    public ChatObject() {
    }

    public ChatObject(String message, String username) {
        this.message = message;
        this.username = username;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "ChatObject{" +
                "message='" + message + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}