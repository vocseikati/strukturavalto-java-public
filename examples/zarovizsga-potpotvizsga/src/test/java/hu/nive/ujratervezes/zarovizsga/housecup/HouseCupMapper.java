package hu.nive.ujratervezes.zarovizsga.housecup;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HouseCupMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        HousePoints housePoints = new HousePoints();
        housePoints.setHouseName(resultSet.getString("house_name"));
        housePoints.setStudentName(resultSet.getString("student_name"));
        housePoints.setPointsEarned(resultSet.getInt("points_earned"));
        return housePoints;
    }
}
