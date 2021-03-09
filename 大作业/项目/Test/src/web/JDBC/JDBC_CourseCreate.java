package web.JDBC;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import web.domain.Course;
import web.domain.Teacher;

/**
 * @author zty
 */

public class JDBC_CourseCreate {
    private JdbcTemplate template = new JdbcTemplate(JDBC_Util.getDateSource());

    public int create(Course course){
        try {
            String sql = "insert into Course values(?, ?, ?, ?)";
            return template.update(sql, course.getTeachername() , course.getCoursename(), course.getPassword(), course.getCredit());
        } catch (DataAccessException e) {
            return 0;
        }
    }

    public Course check(Course course){
        try {
            String sql = "select * from Course where teachername=? and coursename=?";
            return template.queryForObject(sql, new BeanPropertyRowMapper<>(Course.class), course.getTeachername(), course.getCoursename());
        } catch (DataAccessException e) {
            return null;
        }
    }

    public Course checkpassword(Course course){
        try {
            String sql = "select * from Course where teachername=? and coursename=? and password=?";
            return template.queryForObject(sql, new BeanPropertyRowMapper<>(Course.class), course.getTeachername(), course.getCoursename(), course.getPassword());
        } catch (DataAccessException e) {
            return null;
        }
    }

}
