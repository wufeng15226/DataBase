package web.JDBC;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import web.domain.Student;
import web.domain.Teacher;

public class JDBC_StudentLogin {
private JdbcTemplate template = new JdbcTemplate(JDBC_Util.getDateSource());

public Student login(Student student){
    try {
        String sql = "select * from Student where studentname=? and password=?";
        return template.queryForObject(sql, new BeanPropertyRowMapper<>(Student.class), student.getStudentname(), student.getPassword());
    } catch (DataAccessException e) {
        return null;
    }
}
}
