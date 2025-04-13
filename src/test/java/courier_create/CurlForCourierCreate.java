package courier_create;


public class CurlForCourierCreate {

    private String URL = "https://qa-scooter.praktikum-services.ru/";
    private String endpoint = "/api/v1/courier";


    public String getEndpoint() {
        return endpoint;
    }


    public String getURL() {
        return URL;
    }


    public void setURL(String newURL) {
         URL = newURL;
    }


    public void setEndpoint(String newEndpoint) {
        endpoint = newEndpoint;
    }
}
