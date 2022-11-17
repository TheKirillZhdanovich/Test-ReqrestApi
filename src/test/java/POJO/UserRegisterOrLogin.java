package POJO;

public class UserRegisterOrLogin {
    private String email;
    private String password;

    public UserRegisterOrLogin() {

    }

    public UserRegisterOrLogin(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
