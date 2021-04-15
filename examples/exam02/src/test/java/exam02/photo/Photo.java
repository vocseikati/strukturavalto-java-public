package exam02.photo;

public class Photo implements Qualified {

    private String name;
    private Quality quality;

    public Photo(String name) {
        this.name = name;
        quality = Quality.NO_STAR;
    }

    public Photo(String name, Quality quality) {
        this.name = name;
        this.quality = quality;
    }

    public String getName() {
        return name;
    }

    public int getStars() {
        int star = 0;
        if (quality.name().equals("ONE_STAR")) {
            star = 1;
        }
        if (quality.name().equals("TWO_STAR")) {
            star = 2;
        }
        return star;
    }

    public Quality getQuality() {
        return quality;
    }

    @Override
    public void setQuality(Quality quality) {
        this.quality = quality;
    }


}
