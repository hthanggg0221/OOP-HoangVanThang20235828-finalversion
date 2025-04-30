package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.screen.manager.StoreManagerScreen;
import hust.soict.hedspi.aims.store.Store;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Aims {
    static Scanner scanner = new Scanner(System.in);
    private static Store store = new Store();
    private static Cart cart = new Cart();
    private static StoreManagerScreen storeManagerScreen;

    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }

    public static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-4");
    }

    public static void mediaDetailsMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }

    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
    }

    public static void filterCartMenu(){
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart by Id");
        System.out.println("2. Filter medias in cart by title");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }

    public static void updateStoreMenu(){
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add media to store");
        System.out.println("2. Remove Media from store");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }

    public static void sortCartMenu(){
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Sort by Title and Cost");
        System.out.println("2. Sort by Cost and Title");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }

    public static Store getStore() {
        return store;
    }

    public static StoreManagerScreen getStoreManagerScreen() {
        return storeManagerScreen;
    }

    public static void main(String[] args){
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

        storeManagerScreen = new StoreManagerScreen(store);
        List<Media> media = new ArrayList<Media>();
        media.add(cd2);
        media.add(dvd1);
        media.add(book3);
        for(Media m : media) {
            System.out.println(m.toString());
        }

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

        int choice;
        String userTitle;
        Media mediaByTitle;
        do {
            showMenu();
            choice = scanner.nextInt();
            switch (choice) {
                case 1: // View store
                    int storeChoice;
                    do {
                        store.print();
                        storeMenu();
                        storeChoice = scanner.nextInt();
                        switch (storeChoice) {
                            case 1:
                                System.out.println("Enter the title of media: ");
                                scanner.nextLine();

                                userTitle = scanner.nextLine();
                                mediaByTitle = store.findMediaByTitle(userTitle);
                                if (mediaByTitle != null) {
                                    int mediaDetailMenuChoice;

                                    mediaDetailsMenu();
                                    mediaDetailMenuChoice = scanner.nextInt();
                                    switch (mediaDetailMenuChoice) {
                                        case 1:
                                            System.out.println("Enter the title of media: ");
                                            cart.addMedia(mediaByTitle);
                                            break;
                                        case 2:
                                            System.out.println("Playing " + mediaByTitle.getTitle());
                                            break;
                                        case 0:
                                            System.out.println("Returning to store menu...");
                                            break;
                                        default:
                                            System.out.println("Invalid choice. Please try again.");
                                    }
                                }
                                break;
                            case 2:
                                System.out.println("Enter the title of media: ");
                                scanner.nextLine();
                                userTitle =  scanner.nextLine().trim();
                                mediaByTitle = store.findMediaByTitle(userTitle);
                                if(mediaByTitle != null){
                                    cart.addMedia(mediaByTitle);
                                }else{
                                    System.out.println("Title does not exist");
                                }
                                break;
                            case 3:
                                System.out.println("Enter the title of the media to play: ");
                                scanner.nextLine(); // Consume the leftover newline
                                String titleToPlay = scanner.nextLine();

                                Media mediaToPlay = store.findMediaByTitle(titleToPlay);
                                if (mediaToPlay != null) {
                                    if (mediaToPlay instanceof Playable) {
                                        ((Playable) mediaToPlay).play();
                                    } else {
                                        System.out.println("The selected media is not playable.");
                                    }
                                } else {
                                    System.out.println("Media not found in the store.");
                                }
                                break;

                            case 4:
                                int cartChoice;
                                do {
                                    cart.print();
                                    cartMenu();
                                    cartChoice = scanner.nextInt();
                                    CartMenuChoice(cartChoice, cart);
                                } while (cartChoice != 0);
                                break;
                            case 0:
                                System.out.println("Returning to main menu...");
                                break;
                            default:
                                System.out.println("Invalid choice. Please try again.");
                        }
                    } while (storeChoice != 0);
                    break;

                case 2: // Update store
                    int updateChoice;
                    do {
                        updateStoreMenu(); // Display the update store menu
                        updateChoice = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline character
                        switch (updateChoice) {
                            case 1: // Add media to store
                                System.out.println("Enter details of the media to add:");
                                System.out.print("Type (CD/DVD/Book): ");
                                String type = scanner.nextLine();
                                System.out.println(type);
                                Media newMedia = null;
                                if ("CD".equalsIgnoreCase(type)) {

                                    System.out.print("Enter Title: ");
                                    String title = scanner.nextLine();

                                    System.out.print("Enter Category: ");
                                    String category = scanner.nextLine();

                                    System.out.print("Enter Cost: ");
                                    float cost = scanner.nextFloat();
                                    scanner.nextLine();  // Consume newline left-over

                                    System.out.print("Enter Artist: ");
                                    String artist = scanner.nextLine();

                                    System.out.print("Enter Length: ");
                                    int length = scanner.nextInt();
                                    scanner.nextLine();  // Consume newline left-over

                                    System.out.print("Enter Director: ");
                                    String director = scanner.nextLine();

                                    // Create the new CompactDisc object
                                    newMedia = new CompactDisc(title, category, cost, artist);

                                } else if ("DVD".equalsIgnoreCase(type)) {

                                    System.out.print("Enter Title: ");
                                    String title = scanner.nextLine();

                                    System.out.print("Enter Category: ");
                                    String category = scanner.nextLine();

                                    System.out.print("Enter Cost: ");
                                    float cost = scanner.nextFloat();
                                    scanner.nextLine();  // Consume newline left-over

                                    System.out.print("Enter Director: ");
                                    String director = scanner.nextLine();

                                    System.out.print("Enter Length: ");
                                    int length = scanner.nextInt();
                                    scanner.nextLine();  // Consume newline left-over

                                    // Create the new DigitalVideoDisc object
                                    newMedia = new DigitalVideoDisc(title, category, director, length, cost);
                                } else if ("Book".equalsIgnoreCase(type)) {
                                    System.out.print("Enter Title, Category, and Cost: ");

                                    System.out.print("Enter Title: ");
                                    String title = scanner.nextLine();

                                    System.out.print("Enter Category: ");
                                    String category = scanner.nextLine();

                                    System.out.print("Enter Cost: ");
                                    float cost = scanner.nextFloat();
                                    scanner.nextLine();  // Consume newline left-over

                                    newMedia = new Book(title, category, cost);
                                }

                                if (newMedia != null) {
                                    store.addMedia(newMedia);
                                    System.out.println("Media added successfully!");
                                } else {
                                    System.out.println("Invalid media type.");
                                }
                                break;

                            case 2: // Remove media from store
                                System.out.println("Enter the title of the media to remove: ");
                                String titleToRemove = scanner.nextLine();
                                Media mediaToRemove = store.findMediaByTitle(titleToRemove);
                                if (mediaToRemove != null) {
                                    store.removeMedia(mediaToRemove);
                                    System.out.println("Media removed successfully!");
                                } else {
                                    System.out.println("Media not found in the store.");
                                }
                                break;

                            case 0: // Back to main menu
                                System.out.println("Returning to the main menu...");
                                break;

                            default:
                                System.out.println("Invalid choice. Please try again.");
                        }
                    } while (updateChoice != 0);
                    break;


                case 3: // See current cart
                    int cartChoice;
                    do {
                        cartMenu();
                        cartChoice = scanner.nextInt();
                        CartMenuChoice(cartChoice, cart);
                    } while (cartChoice != 0);
                    break;

                case 0: // Exit
                    System.out.println("Exiting the program...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);

        scanner.close();

    }

    private static void CartMenuChoice(int cartChoice, Cart cart) {
        Scanner scanner = new Scanner(System.in);
        switch (cartChoice) {
            case 1:
                int filterCartMenu;
                do{
                    filterCartMenu();
                    filterCartMenu = scanner.nextInt();
                    switch (filterCartMenu){
                        case 1:
                            int id;
                            System.out.println("Enter the id");
                            id = scanner.nextInt();
                            cart.searchByID(id);
                            break;
                        case 2:
                            String title;
                            scanner.nextLine();
                            System.out.println("Entered the title");
                            title = scanner.nextLine();
                            cart.searchTitle(title);
                            break;
                        case 0:
                            System.out.println("Returning to cart menu...");
                            break;
                    }
                }while (filterCartMenu != 0);
                break;
            case 2:
                int sortCartMenu;
                do{
                    sortCartMenu();
                    sortCartMenu = scanner.nextInt();
                    switch (sortCartMenu){
                        case 1:
                            cart.sortCartByTitleAndCost();
                            System.out.println("Finished sorting");
                            cart.print();
                            break;
                        case 2:
                            System.out.println("Sorting by Cost then Title:");
                            cart.sortCartByCostAndTitle();
                            System.out.println("Finished sorting");
                            cart.print();
                            break;
                        case 0:
                            System.out.println("Returning to cart menu...");
                            break;
                    }
                }while (sortCartMenu != 0);
                break;
            case 3:
                System.out.println("Enter the title: ");
                //scanner.nextLine(); // Consume the leftover newline
                String titleToRemove = scanner.nextLine();

                Media mediaToRemove = cart.searchByTitle(titleToRemove);
                if (mediaToRemove != null) {
                    cart.removeMedia(mediaToRemove);
                } else {
                    System.out.println("Media not found in the cart.");
                }
                break;
            case 4:
                System.out.println("Enter the title of the media to play: ");
                //scanner.nextLine(); // Consume the leftover newline
                String titleToPlay = scanner.nextLine();

                Media mediaToPlay = cart.searchByTitle(titleToPlay);
                if (mediaToPlay != null) {
                    if (mediaToPlay instanceof Playable) {
                        ((Playable) mediaToPlay).play();
                    } else {
                        System.out.println("The selected media is not playable.");
                    }
                } else {
                    System.out.println("Media not found in the cart.");
                }
                break;
            case 5:
                System.out.println("Order placed");
                cart.emptyCart();
                break;
            case 0:
                System.out.println("Returning to main menu...");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
}
