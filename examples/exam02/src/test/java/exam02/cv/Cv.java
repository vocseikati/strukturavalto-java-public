package exam02.cv;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cv {

    private String name;
    private List<Skill> skills = new ArrayList<>();

    public Cv(String name) {
        this.name = name;
    }



    public String getName() {
        return name;
    }


    public List<Skill> getSkills() {
        return skills;
    }

    public void addSkills(String... skillParams) {
        for (String s : skillParams) {
            String level = s.substring(s.indexOf("(") + 1, s.indexOf(")"));
            String skillName = s.substring(0, s.indexOf("(")-1).trim();
            skills.add(new Skill(skillName, Integer.parseInt(level)));
        }
    }

    public int findSkillLevelByName(String skillName) {
        for (Skill skill : skills) {
            if (skill.getName().equals(skillName)){
                return skill.getLevel();
            }
        }
        throw new SkillNotFoundException();
    }
}
