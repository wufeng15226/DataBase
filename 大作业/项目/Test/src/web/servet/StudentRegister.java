package web.servet;

import web.JDBC.JDBC_StudentRegister;
import web.JDBC.JDBC_TeacherRegister;
import web.domain.Student;
import web.domain.Teacher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/StudentnameRegister")
public class StudentRegister extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        if(1 == new JDBC_StudentRegister().register(new Student(request.getParameter("studentname"), request.getParameter("password"), request.getParameter("gender"), request.getParameter("department")))){
            response.sendRedirect("./student_worktable.html?studentname="+request.getParameter("studentname"));
        }else {
            request.getRequestDispatcher("/RegisterFailed").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
