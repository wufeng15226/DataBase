package web.domain;

public class CouStu {
    String studentname;
    String teachername;
    String coursename;

    public CouStu() {
    }

    public CouStu(String studentname, String teachername, String coursename) {
        this.studentname = studentname;
        this.teachername = teachername;
        this.coursename = coursename;
    }

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname;
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

    @Override
    public String toString() {
        return "CouStu{" +
                "studentname='" + studentname + '\'' +
                ", teachername='" + teachername + '\'' +
                ", coursename='" + coursename + '\'' +
                '}';
    }
}
