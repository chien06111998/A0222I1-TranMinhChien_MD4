package model;

public class HealthDeclaration {
    private String name;
    private String birthDay;
    private String gender;
    private String nationality;
    private String idCard;
    private String address;
    private String phoneNumber;
    private String email;
    private String travelInformation; //thong tin di lai
    private String vehicleNumber; //so xe
    private String seats; // so ghe
    private String startDate;
    private String endDate;
    private String history;
    private String symptom;//trieu chung
    private String travel; // di qua

    public HealthDeclaration() {
    }

    public HealthDeclaration(String name, String birthDay, String gender, String nationality, String idCard, String address, String phoneNumber, String email, String travelInformation, String vehicleNumber, String seats, String startDate, String endDate, String history, String symptom, String travel) {
        this.name = name;
        this.birthDay = birthDay;
        this.gender = gender;
        this.nationality = nationality;
        this.idCard = idCard;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.travelInformation = travelInformation;
        this.vehicleNumber = vehicleNumber;
        this.seats = seats;
        this.startDate = startDate;
        this.endDate = endDate;
        this.history = history;
        this.symptom = symptom;
        this.travel = travel;
    }

    public String getTravelInformation() {
        return travelInformation;
    }

    public void setTravelInformation(String travelInformation) {
        this.travelInformation = travelInformation;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getSeats() {
        return seats;
    }

    public void setSeats(String seats) {
        this.seats = seats;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public String getSymptom() {
        return symptom;
    }

    public void setSymptom(String symptom) {
        this.symptom = symptom;
    }

    public String getTravel() {
        return travel;
    }

    public void setTravel(String travel) {
        this.travel = travel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
