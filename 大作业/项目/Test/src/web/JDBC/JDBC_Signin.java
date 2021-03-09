package web.JDBC;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import web.domain.CouStu;
import web.domain.SignIn;
import web.domain.StuSignin;
import web.domain.Teacher;

public class JDBC_Signin {
    private JdbcTemplate template = new JdbcTemplate(JDBC_Util.getDateSource());

    public CouStu check(StuSignin stusignin){
        try{
            String sql = "select * from CouStu where teachername=(select teachername from CouSign where sid=?) and coursename=(select coursename from CouSign where sid=?) and studentname=?";
            return template.queryForObject(sql, new BeanPropertyRowMapper<>(CouStu.class), stusignin.getSid(), stusignin.getSid(), stusignin.getStudentname());
        }catch (DataAccessException e){
            return null;
        }
    }

    public SignIn getSignin(String sid){
        try{
            String sql = "select * from Signin where sid=?";
            return template.queryForObject(sql, new BeanPropertyRowMapper<>(SignIn.class), sid);
        }catch (DataAccessException e){
            return null;
        }
    }

    public int signin(StuSignin stusignin){
        try{
            String sql = "insert into StuSignin values(?, ?, ?)";
            return template.update(sql, stusignin.getStudentname(), stusignin.getSid(), stusignin.getSignintime());
        }catch (DataAccessException e){
            return 0;
        }
    }
}
