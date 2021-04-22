package hu.nive.ujratervezes.zarovizsga.housecup;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class HouseCup {

    private JdbcTemplate jdbcTemplate;

    public HouseCup(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public int getPointsOfHouse(String houseName) {
        String sql = "select sum(points_earned) as points_earned from house_points where house_name = ?";
        return jdbcTemplate.queryForObject(sql, (resultSet, i) -> resultSet.getInt("points_earned"), houseName);
//        String sql = "select sum(points_earned) from house_points where house_name = ?";
//        return jdbcTemplate.queryForObject(sql, new Object[]{houseName}, Integer.class);
    }

    public List<HousePoints> getAll() {
        return jdbcTemplate.query("select * from house_points",
                (rs, rowNum) -> {
                    HousePoints housePoints = new HousePoints();
                    housePoints.setHouseName(rs.getString("house_name"));
                    housePoints.setStudentName(rs.getString("student_name"));
                    housePoints.setPointsEarned(rs.getInt("points_earned"));
                    return housePoints;
                });
        //lambda nélkül:
//        List<HousePoints> all = jdbcTemplate.query("select * from house_points",
//                new RowMapper<HousePoints>() {
//                    @Override
//                    public HousePoints mapRow(ResultSet rs, int rowNum) throws SQLException {
//                        HousePoints housePoints = new HousePoints();
//                        housePoints.setHouseName(rs.getString("house_name"));
//                        housePoints.setStudentName(rs.getString("student_name"));
//                        housePoints.setPointsEarned(rs.getInt("points_earned"));
//                        return housePoints;
//                    }
//                });
    }

    public List<HousePoints> getAllForHouse(String houseName) {
        String sql = "select * from house_points where house_name = ?";
        return jdbcTemplate.query(sql,
                new Object[]{houseName},
                new HouseCupMapper());
    }



}
