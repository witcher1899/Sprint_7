package courier_create;

public class RequestCourierCreate {

    private String login;
    private String firstName;
    private String password;



    public RequestCourierCreate(String login, String firstName, String password) {
        this.login = login;
        this.password = password;
        this.firstName = firstName;
    }


    public RequestCourierCreate() {}


    public String getLogin() {
        return login;
    }


    public String getPassword() {
        return login;
    }


    public String getFirstName() {
        return firstName;
    }


    public void setLogin(String newLogin) {
        login = newLogin;
    }


    public void setPassword(String newPassword) {
        password = newPassword;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
