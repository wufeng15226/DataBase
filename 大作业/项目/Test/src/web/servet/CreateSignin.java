package web.servet;

import web.JDBC.JDBC_CourseCreate;
import web.JDBC.JDBC_SigninCreate;
import web.domain.CouSignin;
import web.domain.Course;
import web.domain.SignIn;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Time;

@WebServlet("/CreateSignin")
public class CreateSignin extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        int sid = Math.abs((request.getParameter("teachername")+request.getParameter("coursename")).hashCode());
        Time begintime = new Time(System.currentTimeMillis());
        Time endtime = new Time(System.currentTimeMillis()+1000*Long.parseLong(request.getParameter("time")));

        Course course = new JDBC_CourseCreate().check(new Course(request.getParameter("teachername"), request.getParameter("coursename")));
        if(course==null){
            response.getWriter().write("课程不存在！");
            return;
        }
        if(1 != new JDBC_SigninCreate().link(new CouSignin(sid, request.getParameter("teachername"), request.getParameter("coursename")))){
            response.getWriter().write("签到创建失败！");
            return;
        }
        if(1 == new JDBC_SigninCreate().create(new SignIn(sid, begintime, endtime))){
            response.getWriter().write("签到创建成功！签到码为" + sid);
        }else{
            response.getWriter().write("签到创建失败！");
            System.out.println("异常！");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
