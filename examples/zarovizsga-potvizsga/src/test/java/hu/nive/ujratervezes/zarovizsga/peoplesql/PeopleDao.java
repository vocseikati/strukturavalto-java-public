package hu.nive.ujratervezes.zarovizsga.peoplesql;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class PeopleDao {

    private JdbcTemplate jdbcTemplate;

    public PeopleDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public String findIpByName(String firstName, String lastName){
        try {
            String sql = "select ip_address from people where first_name = ? and last_name = ?";
            return jdbcTemplate.queryForObject(sql, new Object[]{firstName, lastName},
                    String.class);
        }catch (EmptyResultDataAccessException e){
            throw new IllegalArgumentException("Not found");
        }
    }





    //    private DataSource dataSource;
//
//    public PeopleDao(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }
//
//
//    public String findIpByName(String firstName, String lastName) {
//        try (Connection connection = dataSource.getConnection();
//             PreparedStatement ps = connection.prepareStatement("select ip_address from people where first_name = ? and last_name = ?")
//        ) {
//
//            ps.setString(1, firstName);
//            ps.setString(2, lastName);
//
//            return selectIpAddressByName(ps);
//
//        } catch (SQLException sqle) {
//            throw new IllegalStateException("Cannot query", sqle);
//        }
//    }
//
//    private String selectIpAddressByName(PreparedStatement ps) {
//        try (ResultSet rs = ps.executeQuery()) {
//            if (rs.next()){
//                return rs.getString("ip_address");
//            }
//            throw new IllegalArgumentException("Not found");
//        } catch (SQLException sqle) {
//            throw new IllegalStateException("Cannot query", sqle);
//        }
//    }
}
