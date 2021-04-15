package exam02.cv;

public class Skill {

    private String name;
    private int level;

    public Skill(String name, int level) {
        this.name = name;
        if (level < 1 || level > 5){
            throw new IllegalArgumentException("skill must be between 1 and 5!");
        }
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

//    @Override
//    public String toString() {
//        return name + " (" + level + ")";
//    }
}
