package hust.soict.hedspi.aims.media;

import java.util.Comparator;

public abstract class Media implements Comparator<Media>{
    private int id;
    private String title;
    private String category;
    private float cost;
    private static int nbMedia = 0;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public Media() {

    }

    public Media(int id, String title, String category, float cost) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
        nbMedia++;
        id = nbMedia;
    }

    public Media(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
        nbMedia++;
        id = nbMedia;
    }

    public Media(String title) {
        this.title = title;
        nbMedia++;
        id = nbMedia;
    }

    public Media(String title, float cost) {
        this.title = title;
        this.cost = cost;
        ++nbMedia;
        this.id = nbMedia;
    }

    @Override
    public String toString() {
        return "Media - " + getId() + " - " + getTitle() + " - " + getCategory() + " - " + ": " + getCost() + " $";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Media)) return false;
        Media other = (Media) obj;
        return this.title != null && this.title.equals(other.title) && this.cost == other.cost;
    }

    @Override
    public int compareTo(Media other) {
        if (other == null) throw new NullPointerException("Cannot compare to null");
        int titleCompare = this.title.compareTo(other.title);
        if (titleCompare != 0) return titleCompare;
        return Float.compare(this.cost, other.cost);
    }

    public boolean isMatch(String title) {
        String[] keywords = title.split("\\s+");
        for (String word : keywords) {
            if (this.title.toLowerCase().contains(word.toLowerCase()))
                return true;
        }
        return false;
    }

    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
}
