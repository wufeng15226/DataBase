package web.servet;

import web.JDBC.JDBC_TeacherLogin;
import web.JDBC.JDBC_TeacherRegister;
import web.domain.Teacher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/TeacherRegister")
public class TeacherRegister extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        if(1 == new JDBC_TeacherRegister().register(new Teacher(request.getParameter("teachername"), request.getParameter("password"), request.getParameter("gender"), request.getParameter("department")))){
            response.sendRedirect("./teacher_worktable.html?teachername="+request.getParameter("teachername"));
        }else {
            request.getRequestDispatcher("/RegisterFailed").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
