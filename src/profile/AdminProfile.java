package profile;

import java.sql.Date;



public class AdminProfile {
    String id;
    String firstName;
    String lastName;
    Date dob;
    Date joinDate;
    int experience;
    int age;
    String martialStatus;
    String contactNumber;
    String gender;
    String permanentAddress;
    String temporaryAddress;
    int salary;
    String state;
    String district;
    String designation;

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getDob() {
        return dob;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public int getExperience() {
        return experience;
    }

    public int getAge() {
        return age;
    }

    public String getMartialStatus() {
        return martialStatus;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getGender() {
        return gender;
    }

    public String getPermanentAddress() {
        return permanentAddress;
    }

    public String getTemporaryAddress() {
        return temporaryAddress;
    }

    public int getSalary() {
        return salary;
    }

    public String getState() {
        return state;
    }

    public String getDistrict() {
        return district;
    }

    public String getDesignation() {
        return designation;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setMartialStatus(String martialStatus) {
        this.martialStatus = martialStatus;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setPermanentAddress(String permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    public void setTemporaryAddress(String temporaryAddress) {
        this.temporaryAddress = temporaryAddress;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
 
    public static void setAdminProfile(String id){
        AdminProfile details = Database.DatabaseOperations.getAdminProfile(id);
        System.out.println(details.getPermanentAddress());
    }
}
