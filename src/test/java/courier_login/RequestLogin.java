package courier_login;



public class RequestLogin {

    private String login;
    private String password;



    public RequestLogin(String login, String password) {
        this.login = login;
        this.password = password;
    }


    public RequestLogin() {}


    public String getLogin() {
        return login;
    }


    public String getPassword() {
        return login;
    }


    public void setLogin(String newLogin) {
        login = newLogin;
    }


    public void setPassword(String newPassword) {
        password = newPassword;
    }
}
