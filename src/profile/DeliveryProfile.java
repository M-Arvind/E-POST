package profile;

import Admin.AdminDeliveryProfile;
import Admin.deliveryDetails;
import Database.DatabaseOperations;
import java.sql.Date;
import java.util.ArrayList;

public class DeliveryProfile {
    String id;
    String firstName;
    String lastName;
    Date dob;
    Date joinDate;
    int age;
    String martialStatus;
    String contactNumber;
    String gender;
    String permanentAddress;
    String temporaryAddress;
    int salary;
    String state;
    String district;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    
    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMartialStatus() {
        return martialStatus;
    }

    public void setMartialStatus(String martialStatus) {
        this.martialStatus = martialStatus;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPermanentAddress() {
        return permanentAddress;
    }

    public void setPermanentAddress(String permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    public String getTemporaryAddress() {
        return temporaryAddress;
    }

    public void setTemporaryAddress(String temporaryAddress) {
        this.temporaryAddress = temporaryAddress;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }    
    public static void setDeliveryDetails(){
        
            deliveryDetails.deliveryDetailsTable.getSelectionModel().clearSelection();

            while(deliveryDetails.deliveryModel.getRowCount()>0){
                deliveryDetails.deliveryModel.removeRow(0);
//                System.out.println("deleted row");
            }
 
            ArrayList<DeliveryProfile> listForDeliveryConsignment = DatabaseOperations.getDeliveryDetails();         
            for(int i=0;i<listForDeliveryConsignment.size();i++)
            {
                DeliveryProfile temp = listForDeliveryConsignment.get(i);
                deliveryDetails.deliveryModel.addRow(new Object[]{temp.getId(),temp.getFirstName(),temp.getLastName(),temp.getDob(),temp.getJoinDate(),temp.getContactNumber(),temp.getGender(),temp.getSalary()});
            }
    }
    public static void setDeliveryProfile(String id){
        DeliveryProfile details = DatabaseOperations.getDeliveryProfile(id);

        AdminDeliveryProfile.UserNameValue.setText(details.getId());
        AdminDeliveryProfile.ContactNoValue.setText(details.getContactNumber());
//        System.out.println(details.getDob().toString());
        AdminDeliveryProfile.DOBValue.setText(details.getDob().toString());
        AdminDeliveryProfile.AgeValue.setText(Integer.toString(details.getAge()));
        AdminDeliveryProfile.JoinDateValue.setText(details.getJoinDate().toString());
        AdminDeliveryProfile.PAddressValue.setText(details.getPermanentAddress());
        AdminDeliveryProfile.TAddressValue.setText(details.getTemporaryAddress());
        AdminDeliveryProfile.MaritalValue.setText(details.getMartialStatus());
        AdminDeliveryProfile.DesignationValue.setText("Delivery Member");
//        AdminDeliveryProfile.ExperienceValue.setText("None");
        AdminDeliveryProfile.GenderValue.setText(details.getGender());
        AdminDeliveryProfile.SalaryValue.setText(Integer.toString(details.getSalary()));
        AdminDeliveryProfile.UserNameTop.setText(details.getFirstName()+" "+details.getLastName());
//        System.out.println(details.getPermanentAddress());
//        System.out.println(details.getDob());
    }
}
//JLabel UserNameValue,ContactNoValue,DOBValue,AgeValue,JoinDateValue,PAddressValue,TAddressValue,MaritalValue,DesignationValue, ExperienceValue, GenderValue, SalaryValue;