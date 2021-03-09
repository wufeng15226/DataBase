package web.domain;

public class Student {
    String studentname;
    String password;
    String gender;
    String department;

    public Student() {
    }

    public Student(String studentname, String password) {
        this.studentname = studentname;
        this.password = password;
    }

    public Student(String studentname, String password, String gender, String department) {
        this.studentname = studentname;
        this.password = password;
        this.gender = gender;
        this.department = department;
    }

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname;
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
        return "Student{" +
                "studentname='" + studentname + '\'' +
                ", password='" + password + '\'' +
                ", gender='" + gender + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
