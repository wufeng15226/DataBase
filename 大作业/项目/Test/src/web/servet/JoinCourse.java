package web.servet;

import web.JDBC.JDBC_CourseCreate;
import web.JDBC.JDBC_JoinCourse;
import web.JDBC.JDBC_SigninCreate;
import web.domain.CouSignin;
import web.domain.CouStu;
import web.domain.Course;
import web.domain.SignIn;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Time;

@WebServlet("/JoinCourse")
public class JoinCourse extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        Course course = new JDBC_CourseCreate().checkpassword(new Course(request.getParameter("teachername"), request.getParameter("coursename"), request.getParameter("password")));
        if(course==null){
            response.getWriter().write("课程不存在或密码错误！");
            return;
        }
        if(1 != new JDBC_JoinCourse().join(new CouStu(request.getParameter("studentname"), request.getParameter("teachername"), request.getParameter("coursename")))){
            response.getWriter().write("加入课程失败！");
        }else{
            response.getWriter().write("加入课程成功！");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
