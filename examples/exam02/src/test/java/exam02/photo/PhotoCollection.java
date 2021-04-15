package exam02.photo;

import java.util.ArrayList;
import java.util.List;

public class PhotoCollection {

    List<Photo> photos = new ArrayList<>();


    public List<Photo> getPhotos() {
        return photos;
    }

    public void addPhoto(String... photoNames) {
        for (String photoName : photoNames) {
            photos.add(new Photo(photoName));
        }
    }

    public int numberOfStars() {
        int stars = 0;
        for (Photo photo : photos) {
            stars += photo.getStars();
        }
        return stars;
    }

    public void starPhoto(String photoName, Quality quality) {
        boolean found = false;
        for (Photo photo : photos) {
            if (photo.getName().equals(photoName)){
                found = true;
                photo.setQuality(quality);
            }
        }
        if (!found) {
            throw new PhotoNotFoundException();
        }
    }
}
