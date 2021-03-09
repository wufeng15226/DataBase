package web.domain;

import java.sql.Time;

public class StuSignin {
    String studentname;
    int sid;
    Time signintime;

    public StuSignin(String studentname, int sid, Time signintime) {
        this.studentname = studentname;
        this.sid = sid;
        this.signintime = signintime;
    }

    public StuSignin() {
    }

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public Time getSignintime() {
        return signintime;
    }

    public void setSignintime(Time signintime) {
        this.signintime = signintime;
    }

    @Override
    public String toString() {
        return "StuSignin{" +
                "studentname='" + studentname + '\'' +
                ", sid=" + sid +
                ", signintime=" + signintime +
                '}';
    }
}
