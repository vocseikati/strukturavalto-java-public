package exam02.photo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class PhotoCollection {

    List<Photo> photos = new ArrayList<>();

    public List<Photo> getPhotos() {
        return photos;
    }

    public void addPhoto(String... s) {
        List<String> params = Arrays.asList(s);
        for (String param : params) {
            photos.add(new Photo(param));
        }
    }

    public void starPhoto(String photoName, Quality star) {
//        for (Photo photo : photos) {
//            if (photo.getName().equals(photoName)) {
//                photo.setQuality(star);
//            }
//            if (!photo.getName().equals(photoName)) {
//                throw new PhotoNotFoundException("There is no photo with this name " + photoName);
//            }
//        }
        boolean found = false;
        for (Photo photo: photos) {
            if (photo.getName().equals(photoName)) {
                photo.setQuality(star);
                found = true;
            }
        }
        if (!found) {
            throw new PhotoNotFoundException("There is no photo with this name " + photoName);
        }
    }

    public int numberOfStars() {
        int count = 0;
        for (Photo photo : photos) {
//            switch(photo.getQuality()) {
//                case TWO_STAR:
//                    count ++;
//                case ONE_STAR:
//                    count ++;
//            }
            if (photo.getQuality().equals(Quality.ONE_STAR)){
                count++;
            }
            if (photo.quality.equals(Quality.TWO_STAR)){
                count += 2;
            }
        }
        return count;
    }
}
