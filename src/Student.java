import java.util.Arrays;

public class Student {
    private String email;
    private String pd;
    private String f_name;
    private String l_name;
    private String dob;
    private int gender;
    private String[] allergens;
    private String mobile_number;

    public Student(String email){
        this.email = email;
    }
    public Student(String email, String pd, String f_name, String l_name, String dob, int gender, String[] allergens, String mobile_number) {
        this.email = email;
        this.pd = pd;
        this.f_name = f_name;
        this.l_name = l_name;
        this.dob = dob;
        this.gender = gender;
        this.allergens = allergens;
        this.mobile_number = mobile_number;

    }

    @Override
    public String toString() {
        return "Student{" +
                "email='" + email + '\'' +
                ", pd='" + pd + '\'' +
                ", f_name='" + f_name + '\'' +
                ", l_name='" + l_name + '\'' +
                ", dob='" + dob + '\'' +
                ", gender=" + gender +
                ", allergens=" + Arrays.toString(allergens) +
                ", mobile_number='" + mobile_number + '\'' +
                '}';
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public void setPd(String pd) {
        this.pd = pd;
    }
    public void setF_name(String f_name) {
        this.f_name = f_name;
    }
    public void setL_name(String l_name) {
        this.l_name = l_name;
    }
    public void setDob(String dob) {
        this.dob = dob;
    }
    public void setGender(int gender) {
        this.gender = gender;
    }
    public void setAllergens(String[] allergens) {
        this.allergens = allergens;
    }
    public void setMobile_number(String mobile_number) {
        this.mobile_number = mobile_number;
    }
    public String getEmail() {
        return email;
    }
    public String getPd() {
        return pd;
    }
    public String getF_name() {
        return f_name;
    }
    public String getL_name() {
        return l_name;
    }
    public String getDob() {
        return dob;
    }
    public int getGender() {
        return gender;
    }
    public String[] getAllergens() {
        return allergens;
    }
    public String getMobile_number() {
        return mobile_number;
    }


}
