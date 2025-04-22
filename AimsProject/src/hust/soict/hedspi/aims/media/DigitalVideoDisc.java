package hust.soict.hedspi.aims.media;

public class DigitalVideoDisc extends Media {
    public DigitalVideoDisc(String title) {
        super(title);
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        super(title, category, cost);
    }

    public boolean isMatch(String title) {
        String[] tmp = title.split(" ", 0);
        for (String s: tmp) {
            if (getTitle().toLowerCase().contains(s.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

}
