package exam03retake02;

public class Station {

    private Integer id;
    private String allomas;
    private String lat;
    private String lng;
    private String description;
    private int level;
    private String groupId;
    private String stationType;

    public Station(Integer id, String allomas, String lat, String lng, String description, int level, String groupId, String stationType) {
        this.id = id;
        this.allomas = allomas;
        this.lat = lat;
        this.lng = lng;
        this.description = description;
        this.level = level;
        this.groupId = groupId;
        this.stationType = stationType;
    }

    public Integer getId() {
        return id;
    }

    public String getAllomas() {
        return allomas;
    }

    public String getLat() {
        return lat;
    }

    public String getLng() {
        return lng;
    }

    public String getDescription() {
        return description;
    }

    public int getLevel() {
        return level;
    }

    public String getGroupId() {
        return groupId;
    }

    public String getStationType() {
        return stationType;
    }

    @Override
    public String toString() {
        return "Stations{" +
                "id=" + id +
                ", allomas='" + allomas + '\'' +
                ", lat='" + lat + '\'' +
                ", lng='" + lng + '\'' +
                ", description='" + description + '\'' +
                ", level=" + level +
                ", groupId='" + groupId + '\'' +
                ", stationType='" + stationType + '\'' +
                '}';
    }
}
