package web.servet;

import web.JDBC.JDBC_CourseCreate;
import web.domain.Course;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zty
 */
@WebServlet("/NewCourse")
public class NewCourse extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        if(1 == new JDBC_CourseCreate().create(new Course(request.getParameter("teachername"), request.getParameter("coursename"), request.getParameter("password"), Integer.parseInt(request.getParameter("credit"))))){
            response.getWriter().write("课程创建成功！");
        }else{
            response.getWriter().write("课程已存在，创建失败！");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
