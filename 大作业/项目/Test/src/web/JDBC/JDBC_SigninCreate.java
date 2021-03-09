package web.JDBC;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import web.domain.CouSignin;
import web.domain.Course;
import web.domain.SignIn;

public class JDBC_SigninCreate {
    private JdbcTemplate template = new JdbcTemplate(JDBC_Util.getDateSource());

    public int link(CouSignin cousignin){
        try {
            String sql = "insert into CouSign values(?, ?, ?)";
            return template.update(sql, cousignin.getSid(), cousignin.getTeachername() , cousignin.getCoursename());
        } catch (DataAccessException e) {
            return 0;
        }
    }

    public int create(SignIn signin){
        try {
            String sql = "insert into Signin values(?, ?, ?)";
            return template.update(sql, signin.getSid(), signin.getBegintime(), signin.getEndtime());
        } catch (DataAccessException e) {
            return 0;
        }
    }
}
