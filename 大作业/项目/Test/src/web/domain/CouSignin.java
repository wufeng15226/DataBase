package web.domain;

public class CouSignin {
    int sid;
    String teachername;
    String coursename;

    public CouSignin() {
    }

    public CouSignin(int sid, String teachername, String coursename) {
        this.sid = sid;
        this.teachername = teachername;
        this.coursename = coursename;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
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
        return "CouSignin{" +
                "sid=" + sid +
                ", teachername='" + teachername + '\'' +
                ", coursename='" + coursename + '\'' +
                '}';
    }
}
