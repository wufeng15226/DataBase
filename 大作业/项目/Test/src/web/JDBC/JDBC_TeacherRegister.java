package web.JDBC;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import web.domain.Teacher;

import java.lang.annotation.Target;

public class JDBC_TeacherRegister {
    private JdbcTemplate template = new JdbcTemplate(JDBC_Util.getDateSource());

    public int register(Teacher teacher){
        try{
            String sql = "insert into Teacher values(?, ?, ?, ?)";
            return template.update(sql, teacher.getTeachername(), teacher.getPassword(), teacher.getGender(), teacher.getDepartment());
        }catch (DataAccessException e){
            return 0;
        }
    }
}
