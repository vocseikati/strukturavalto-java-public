package hu.nive.ujratervezes.zarovizsga.housecup;

public class HousePoints {

    private String houseName;
    private String studentName;
    private Integer pointsEarned;

    public HousePoints(String houseName, String studentName, Integer pointsEarned) {
        this.houseName = houseName;
        this.studentName = studentName;
        this.pointsEarned = pointsEarned;
    }

    public HousePoints() {
    }

    public String getHouseName() {
        return houseName;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Integer getPointsEarned() {
        return pointsEarned;
    }

    public void setPointsEarned(Integer pointsEarned) {
        this.pointsEarned = pointsEarned;
    }

    @Override
    public String toString() {
        return "HousePoints{" +
                "houseName='" + houseName + '\'' +
                ", studentName='" + studentName + '\'' +
                ", pointsEarned=" + pointsEarned +
                '}';
    }
}
