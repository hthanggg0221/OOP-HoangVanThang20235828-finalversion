package hust.soict.hedspi.aims.media;

public abstract class Media {
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
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Media media = (Media) obj;
        return title.equals(media.title);
    }
}
