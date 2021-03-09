package web.JDBC;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import web.domain.CouStu;
import web.domain.Student;

public class JDBC_JoinCourse {
    private JdbcTemplate template = new JdbcTemplate(JDBC_Util.getDateSource());

    public int join(CouStu coustu){
        try{
            String sql = "insert into CouStu values(?, ?, ?)";
            return template.update(sql, coustu.getStudentname(), coustu.getTeachername(), coustu.getCoursename());
        }catch (DataAccessException e){
            return 0;
        }
    }
}
