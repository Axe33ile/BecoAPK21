package com.example.becoapk21.Login_Register;

/*
                        UserHelperClass.java ---> INFORMATION
            ------------------------------------------------------------
            This class manages data from all the intents.
            -------------------------------------------------------------
 */
public class UserHelperClass {
    //Attributes
    private String user_name, user_password, user_email, user_phone, parkingSpot, message;
    int messageType;


    //constructor
    public UserHelperClass() {

    }

    //constructor
    public UserHelperClass(String user_name, String user_password, String user_email, String user_phone, String parkingSpot,String message,int messageType) {
        this.user_name = user_name; // user name
        this.user_password = user_password; // user password
        this.user_email = user_email; // email user entered
        this.user_phone = user_phone; //phone number from the user
        this.parkingSpot = parkingSpot; // parking spot the user parked the bike
        this.messageType= messageType; //0 -> כללי 1-> תשלום 2-> תיקון
        this.message=""; //staring message from empty
    }

    //methods
    public int getMessageType() {
        return messageType;
    }

    public void setMessageType(int messageType) {
        this.messageType = messageType;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }

    public String getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(String parkingSpot) {
        this.parkingSpot = parkingSpot;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    //ToString
    public String messageString(){
        return this.getUser_name()+" "+this.getUser_phone()+" \n"+this.getMessage();

    }
}
