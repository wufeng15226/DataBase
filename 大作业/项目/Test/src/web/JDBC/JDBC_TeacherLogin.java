package web.JDBC;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import web.domain.Teacher;

    public class JDBC_TeacherLogin {
    private JdbcTemplate template = new JdbcTemplate(JDBC_Util.getDateSource());

    public Teacher login(Teacher teacher){
        try {
            String sql = "select * from Teacher where teachername=? and password=?";
            return template.queryForObject(sql, new BeanPropertyRowMapper<>(Teacher.class), teacher.getTeachername(), teacher.getPassword());
        } catch (DataAccessException e) {
            return null;
        }
    }
}
