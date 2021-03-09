package web.domain;

public class Teacher{
    String teachername;
    String password;
    String gender;
    String department;

    public Teacher() {
    }

    public Teacher(String teachername, String password) {
        this.teachername = teachername;
        this.password = password;
    }

    public Teacher(String teachername, String password, String gender, String department) {
        this.teachername = teachername;
        this.password = password;
        this.gender = gender;
        this.department = department;
    }

    public String getTeachername() {
        return teachername;
    }

    public void setTeachername(String teachername) {
        this.teachername = teachername;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teachername='" + teachername + '\'' +
                ", password='" + password + '\'' +
                ", gender='" + gender + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
