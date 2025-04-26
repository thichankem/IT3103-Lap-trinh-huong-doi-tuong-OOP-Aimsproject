package hust.soict.hedspi.aims.media;
import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {
    @Override
    public int compare(Media media1, Media media2) {

        try {
            if (media1.getTitle().compareTo(media2.getTitle()) > 0) {
                return -1;
            } else if (media1.getTitle().compareTo(media2.getTitle()) < 0) {
                return 1;
            } else {
                if (media1.getCost() > media2.getCost()) {
                    return -1;
                } else if (media1.getCost() < media2.getCost()) {
                    return 1;
                }
            }
        } catch (NullPointerException e) {
            if (media1.getTitle() == null && media2.getTitle() == null) {
                return -1;
            }
            if (media1.getTitle() == null && media2.getTitle() != null) {
                return -1;
            }
            if (media1.getTitle() != null && media2.getTitle() == null) {
                return 1;
            }
        }
        return 0;
    }

}