package hust.soict.hedspi.test.screen.customer.store;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.screen.customer.controller.ViewStoreController;
import hust.soict.hedspi.aims.store.Store;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestViewStoreScreen extends Application {
    private static Store store;
    private static Cart cart;

    @Override
    public void start(Stage primaryStage) throws Exception {
        final String STORE_FXML_FILE_PATH = "/hust/soict/hedspi/aims/screen/customer/view/Store.fxml";
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
        ViewStoreController viewStoreController = new ViewStoreController(store, cart);
        fxmlLoader.setController(viewStoreController);
        Parent root = fxmlLoader.load();

        primaryStage.setTitle("Store");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        store = new Store();
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

        store.addMedia(cd1);
        store.addMedia(cd2);
        store.addMedia(cd3);
        store.addMedia(cd4);
        store.addMedia(cd5);

        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);
        store.addMedia(dvd4);
        store.addMedia(dvd5);

        store.addMedia(book1);
        store.addMedia(book2);
        store.addMedia(book3);
        store.addMedia(book4);
        store.addMedia(book5);

        launch(args);
    }
}
