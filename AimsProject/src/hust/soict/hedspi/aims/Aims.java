package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.store.Store;

import java.util.ArrayList;
import java.util.List;

public class Aims {
    public static void main(String[] args){
        Store store = new Store();
        Cart cart = new Cart();

        CompactDisc cd1= new CompactDisc("P3 Reload OST", "Music", 10.99f, "Atlus", 180, "Atlus");
        CompactDisc cd2 = new CompactDisc("Epilogue", "Pop", 12.99f, "HVT", 170, "HVT");
        CompactDisc cd3 = new CompactDisc("Nightcore Hits", "Remix", 8.99f, "Various Artists", 200, "Various");
        CompactDisc cd4 = new CompactDisc("Jazz Vibes", "Jazz", 14.99f, "Norah Jones", 240, "Norah Jones");
        CompactDisc cd5 = new CompactDisc("Epic Classics", "Classical", 9.99f, "Ludwig Orchestra", 120, "Beethoven");

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Winter of Rebirth", "Action", "Atlus", 105, 13.99f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Persona", "Animation", "Atlus", 92, 20.67f);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Metaphor", "Animation", "Atlus", 210, 59.99f);
        DigitalVideoDisc dvd5 = new DigitalVideoDisc("Warhammer 40K", "Animation", "GW", 250, 59.99f);

        Book book1 = new Book("Dune Book", "Sci-fi", 9.99f);
        Book book2 = new Book("1984", "Dystopian", 8.99f);
        Book book3 = new Book("To Kill a Mockingbird", "Classic", 7.99f);
        Book book4 = new Book("The Hobbit", "Fantasy", 10.49f);
        Book book5 = new Book("The Catcher in the Rye", "Classic", 6.99f);

        List<Media> media = new ArrayList<Media>();
        media.add(cd2);
        media.add(dvd1);
        media.add(book3);
        for(Media m : media) {
            System.out.println(m.toString());
        }
    }
}
