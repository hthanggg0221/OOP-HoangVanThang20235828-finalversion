package hust.soict.hedspi.test.cart;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;

public class CartTest {
    public static void main(String[] args) {
        Cart cart = new Cart();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("Metaphor Refantazio", "Animation", "Atlus", 123, 59.99f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Warhammer 40K", "Sci-Fi", "Game workshop",117, 59.99f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Titanic", "Romance", "James Cameroon", 195, 19.99f);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("The Dark Knight", "Action", "Christopher Nolan", 152, 29.99f);
        DigitalVideoDisc dvd5 = new DigitalVideoDisc("Sword Art Online", "Animation", "A1", 134, 49.99f);


        DigitalVideoDisc[]  dvdList = {dvd1,dvd2, dvd3, dvd4, dvd5};
        cart.addMedia(dvdList);
        cart.print();
        cart.searchByID(5);
        cart.searchTitle("hahaha");
        cart.searchTitle("Metaphor");
    }
}
