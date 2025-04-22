package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Book extends Media {
    private List<String> authors = new ArrayList<String>();

    public List<String> getAuthors() {
        return authors;
    }

    public Book() {
        super();
    }

    public Book(String title, String category, float cost, List<String> authors) {
        super(title, category, cost);
        this.authors = authors;
    }

    public Book(int id, String title, String category, float cost) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
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
