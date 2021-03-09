package web.domain;

public class Course {
    String teachername;
    String coursename;
    String password;
    int credit;

    public Course() {
    }

    public Course(String teachername, String coursename) {
        this.teachername = teachername;
        this.coursename = coursename;
    }

    public Course(String teachername, String coursename, String password) {
        this.teachername = teachername;
        this.coursename = coursename;
        this.password = password;
    }

    public Course(String teachername, String coursename, String password, int credit) {
        this.teachername = teachername;
        this.coursename = coursename;
        this.password = password;
        this.credit = credit;
    }

    public String getTeachername() {
        return teachername;
    }

    public void setTeachername(String teachername) {
        this.teachername = teachername;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    @Override
    public String toString() {
        return "Course{" +
                "teachername='" + teachername + '\'' +
                ", coursename='" + coursename + '\'' +
                ", password='" + password + '\'' +
                ", credit=" + credit +
                '}';
    }
}
