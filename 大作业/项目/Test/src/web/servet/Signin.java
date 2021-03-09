package web.servet;

import web.JDBC.JDBC_CourseCreate;
import web.JDBC.JDBC_JoinCourse;
import web.JDBC.JDBC_Signin;
import web.domain.CouStu;
import web.domain.Course;
import web.domain.SignIn;
import web.domain.StuSignin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Time;

@WebServlet("/Signin")
public class Signin extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        Time time = new Time(System.currentTimeMillis());
        StuSignin stusignin = new StuSignin(request.getParameter("studentname"), Integer.parseInt(request.getParameter("sid")), time);
        CouStu coustu = new JDBC_Signin().check(stusignin);
        if(coustu==null){
            response.getWriter().write("签到不存在或你未加入该课程！");
            return;
        }
        SignIn signin = new JDBC_Signin().getSignin(request.getParameter("sid"));
        if(signin==null){
            response.getWriter().write("签到不存在！");
            return;
        }
        System.out.println(signin.getEndtime());
        System.out.println(time);
        if(signin.getEndtime().toString().compareTo(time.toString())<0){
            response.getWriter().write("签到已结束！");
            return;
        }
        if(1 != new JDBC_Signin().signin(stusignin)){
            response.getWriter().write("签到失败！");
        }else{
            response.getWriter().write("签到成功！");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
