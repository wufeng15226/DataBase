package web.servet;

import web.JDBC.JDBC_TeacherLogin;
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
@WebServlet("/TeacherLogin")
public class TeacherLogin extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Teacher teacher = new JDBC_TeacherLogin().login(new Teacher(request.getParameter("teachername"), request.getParameter("password")));
        if(teacher==null){
            request.getRequestDispatcher("/LoginFailed").forward(request, response);
        }else {
            response.sendRedirect("./teacher_worktable.html?teachername="+request.getParameter("teachername"));
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
