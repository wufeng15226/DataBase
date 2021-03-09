package web.servet;

import web.JDBC.JDBC_StudentLogin;
import web.JDBC.JDBC_TeacherLogin;
import web.domain.Student;
import web.domain.Teacher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zty
 */
@WebServlet("/StudentLogin")
public class StudentLogin extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Student student = new JDBC_StudentLogin().login(new Student(request.getParameter("studentname"), request.getParameter("password")));
        if(student==null){
            request.getRequestDispatcher("/LoginFailed").forward(request, response);
        }else {
            response.sendRedirect("./student_worktable.html?studentname="+request.getParameter("studentname"));
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
