package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Book {
    private int id;
    private String title;
    private String category;
    private float cost;
    private List<String> authors = new ArrayList<String>();

    public Book() {
        this.id = 0;
        this.title = "";
        this.category = "";
        this.cost = 0.0f;
    }

    public Book(int id, String title, String category, float cost) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

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

    public List<String> getAuthors() {
        return authors;
    }

    public void addAuthor(String authorName) {
        for (String i : authors) {
            if(Objects.equals(i, authorName)) {
                System.out.println("Author already existed");
                return;
            }
        }
        authors.add(authorName);
    }

    public void removeAuthor(String authorName) {
        for (int i = 0; i < authors.size(); i++) {
            if (Objects.equals(authors.get(i), authorName)) {
                authors.remove(i);
                System.out.println("Author removed successful");
                return;
            }
        }
        System.out.println("Author not exist");
    }
}
