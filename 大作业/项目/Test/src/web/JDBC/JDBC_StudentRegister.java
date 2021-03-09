package web.JDBC;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import web.domain.Student;
import web.domain.Teacher;

public class JDBC_StudentRegister {
    private JdbcTemplate template = new JdbcTemplate(JDBC_Util.getDateSource());

    public int register(Student student){
        try{
            String sql = "insert into Student values(?, ?, ?, ?)";
            return template.update(sql, student.getStudentname(), student.getPassword(), student.getGender(), student.getDepartment());
        }catch (DataAccessException e){
            return 0;
        }
    }
}
