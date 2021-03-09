package web.domain;

import java.sql.Time;

public class SignIn {
    int sid;
    Time begintime;
    Time endtime;

    public SignIn() {
    }

    public SignIn(int sid, Time begintime, Time endtime) {
        this.sid = sid;
        this.begintime = begintime;
        this.endtime = endtime;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public Time getBegintime() {
        return begintime;
    }

    public void setBegintime(Time begintime) {
        this.begintime = begintime;
    }

    public Time getEndtime() {
        return endtime;
    }

    public void setEndtime(Time endtime) {
        this.endtime = endtime;
    }

    @Override
    public String toString() {
        return "SignIn{" +
                "sid=" + sid +
                ", begintime=" + begintime +
                ", endtime=" + endtime +
                '}';
    }
}
