package web.JDBC;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author zty
 */
public class JDBC_Util {
    private static DataSource ds;

    static {
        try {
            Properties pro = new Properties();
            InputStream is = JDBC_Util.class.getClassLoader().getResourceAsStream("druid.properties");
            pro.load(is);
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static DataSource getDateSource(){
        return ds;
    }

    @Test
    public void test(){
        System.out.println(ds);
    }


    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

}
