package hu.nive.ujratervezes.zarovizsga.dogtypes;

import org.mariadb.jdbc.MariaDbDataSource;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DogTypes {

    private DataSource dataSource;

    public DogTypes(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    public List<String> getDogsByCountry(String country) {

        try (Connection conn = dataSource.getConnection();
//             Statement stmt = conn.createStatement();
//             ResultSet rs = stmt.executeQuery("select name from dog_types where country = ?")
             PreparedStatement ps = conn.prepareStatement("select name from dog_types where country = ?")
        ) {
            ps.setString(1, country);

            return selectCountry(ps);

        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot query", sqle);
        }
    }

    private List<String> selectCountry(PreparedStatement ps) {
        List<String> dogNamesByCountry = new ArrayList<>();
        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()){
                String name = rs.getString("name");
                dogNamesByCountry.add(name.toLowerCase());
            }
            if (dogNamesByCountry.isEmpty()){
                throw new IllegalArgumentException("Not found");
            }
            return dogNamesByCountry;

        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot query", sqle);
        }
    }
}
