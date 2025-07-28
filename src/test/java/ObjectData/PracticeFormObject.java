package ObjectData;

import java.util.HashMap;
import java.util.List;

public class PracticeFormObject extends CommonObject{

    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String phoneNumber;
    private String gender;
    private List<String> subjects;
    private List<String> hobbies;
    private String city;
    private String state;

    public PracticeFormObject(HashMap<String, String> testData){
        populateData(testData);
    }

    public void populateData(HashMap<String, String> testData){
       for(String key : testData.keySet()){
           switch (key){
               case "firstName" :
                   setFirstName(testData.get(key));
                   break;
               case "lastName" :
                   setLastName(testData.get(key));
                   break;
               case "email" :
                   setEmail(testData.get(key));
                   break;
               case "address" :
                   setAddress(testData.get(key));
                   break;
               case "phoneNumber" :
                   setPhoneNumber(testData.get(key));
                   break;
               case "gender" :
                   setGender(testData.get(key));
                   break;
               case "subjects" :
                   setSubjects(getValueList(testData.get(key)));
                   break;
               case "hobbies" :
                   setHobbies(getValueList(testData.get(key)));
                   break;
               case "city" :
                   setCity(testData.get(key));
                   break;
               case "state" :
                   setState(testData.get(key));
                   break;
           }
       }
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }
}
