package birdwatcher;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class BirdWatcher {

    private JdbcTemplate jdbcTemplate;

    public BirdWatcher(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }


    public List<String> getUniqueBirds() {
        return jdbcTemplate.query("select distinct species from birds_spotted order by species asc",
                (rs, rowNum) -> rs.getString("species"));
//        return jdbcTemplate.query("select distinct species from birds_spotted order by species asc", new RowMapper<String>() {
//            @Override
//            public String mapRow(ResultSet rs, int rowNum) throws SQLException{
//                return rs.getString("species");
//            }
//        });
    }
}
