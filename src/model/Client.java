package model;



public class Client  {


    private int clientId;
    private String name;
    private String address;
    private String phone;
    private boolean isProfessional;

    public Client( String name, String address, String phone, boolean isProfessional) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.isProfessional = isProfessional;

    }

    public Client(  int clientId,String name, String address, String phone, boolean isProfessional) {
        this.clientId = clientId;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.isProfessional = isProfessional;

    }

    // Getters and Setters
    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isProfessional() {
        return isProfessional;
    }

    public void setProfessional(boolean professional) {
        isProfessional = professional;
    }
}

