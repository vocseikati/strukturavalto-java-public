package hu.nive.ujratervezes.zarovizsga.peoplesql;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class PeopleDao {

    private DataSource dataSource;

    public PeopleDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    public String findIpByName(String firstName, String lastName) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement("select ip_address from people where first_name = ? and last_name = ?")
        ) {

            ps.setString(1, firstName);
            ps.setString(2, lastName);

            return selectIpAddressByName(ps);

        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot query", sqle);
        }
    }

    private String selectIpAddressByName(PreparedStatement ps) {
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()){
                return rs.getString("ip_address");
            }
            throw new IllegalArgumentException("Not found");
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot query", sqle);
        }
    }
}
