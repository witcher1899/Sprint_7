package order_create;

import java.util.ArrayList;

public class RequestOrderCreate {


    private String firstName;
    private String lastName;
    private String address;
    private String metroStation;
    private String phone;
    private int rentTime;
    private String deliveryDate;
    private String comment;
    private ArrayList<String> color;


    public RequestOrderCreate(String firstName, String lastName, String address, String metroStation,
                              String phone, int rentTime, String deliveryDate, String comment,
                              ArrayList<String> color) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.metroStation = metroStation;
        this.phone = phone;
        this.rentTime = rentTime;
        this.deliveryDate = deliveryDate;
        this.comment = comment;
        this.color = color;
    }


    public RequestOrderCreate() {}


    public String getFirstName() {
        return firstName;
    }


    public String getLastName() {
        return lastName;
    }


    public String getAddress() {
        return address;
    }


    public String getMetroStation() {
        return metroStation;
    }


    public String getPhone() {
        return phone;
    }


    public int getRentTime() {
        return rentTime;
    }


    public String getComment() {
        return comment;
    }


    public ArrayList<String> getColor() {
        return color;
    }


    public String getDeliveryDate() {
        return deliveryDate;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public void setAddress(String address) {
        this.address = address;
    }


    public void setColor(ArrayList<String> color) {
        this.color = color;
    }


    public void setMetroStation(String metroStation) {
        this.metroStation = metroStation;
    }


    public void setComment(String comment) {
        this.comment = comment;
    }


    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }


    public void setPhone(String phone) {
        this.phone = phone;
    }


    public void setRentTime(int rentTime) {
        this.rentTime = rentTime;
    }
}
