package hust.soict.hedspi.aims.cart;

import hust.soict.hedspi.aims.media.Media;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

import static hust.soict.hedspi.aims.media.Media.COMPARE_BY_COST_TITLE;
import static hust.soict.hedspi.aims.media.Media.COMPARE_BY_TITLE_COST;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();

    public ObservableList<Media> getItemsOrdered() {
        return itemsOrdered;
    }

    public void addMedia(Media media) {
        if (itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
            itemsOrdered.add(media);
            System.out.println(media.getTitle() + " has been added to the cart.");
        }
        else {
            System.out.println("The cart is almost full");
        }
    }
    public void addMedia(Media media1, Media media2) { // Bui Quang Phuong 20235809
        if (itemsOrdered.size() > MAX_NUMBERS_ORDERED) {
            System.out.println("MAX NUMBERS ORDERED REACHED");
            return;
        }
        itemsOrdered.add(media1);
        System.out.println("Product " + media1.getTitle() + " added successfully");
        if (itemsOrdered.size() > MAX_NUMBERS_ORDERED) {
            System.out.println("MAX NUMBERS ORDERED REACHED");
            return;
        }
        itemsOrdered.add(media2);
        System.out.println("Product " + media2.getTitle() + " added successfully");
    }
    public void addMedia(Media[] mediaList) { // Bui Quang Phuong 20235809
        for (Media media : mediaList) {
            // Assuming hust.soict.ite6.aims.cart.Cart class handles this method to add DVDs
            if (itemsOrdered.size() > MAX_NUMBERS_ORDERED) {
                System.out.println("MAX NUMBERS ORDERED REACHED");
                return;
            }
            itemsOrdered.add(media);
            System.out.println("Product " + media.getTitle() + " added successfully");
        }
    }

    public void removeMedia(Media media) {
        if (itemsOrdered.contains(media)) {
            itemsOrdered.remove(media);
            System.out.println(media.getTitle() + " has been removed from the cart.");
        } else {
            System.out.println(media.getTitle() + " is not exist in the cart.");
        }
    }

    public float totalCost() {
        if (itemsOrdered.isEmpty()) {
            return 0;
        }
        float cost = 0;
        for (Media media : itemsOrdered) {
            cost += media.getCost();
        }
        return cost;
    }

    public void displayCartItems() {
        for (int i = 0; i < itemsOrdered.size(); i++) {
            System.out.printf("%-3d %-20s %10.2f\n", i + 1, itemsOrdered.get(i).getTitle(), itemsOrdered.get(i).getCost());
        }
        System.out.printf("%-3s %-20s %10.2f\n", "", "Total Cost", totalCost());
    }

    public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for (int i = 0; i < itemsOrdered.size(); i++) {
            System.out.println(i+1 + ". " + itemsOrdered.get(i).toString());
        }
        System.out.println("Total cost: " + totalCost());
        System.out.println("***************************************************");
    }

    public void searchByID(int id) {
        if (itemsOrdered.isEmpty()) {
            System.out.println("The cart is empty!");
            return;
        }

        boolean found = false;

        for (Media media : itemsOrdered) {
            if (id == media.getId()) {
                System.out.println(media);
                System.out.println("---------------------------------------------------");
                found = true;
            }
        }

        if (!found) {
            System.out.println("No matching titles found for \"" + id + "\".");
        }
    }

    public void searchTitle(String title) {
        if (itemsOrdered.isEmpty()) {
            System.out.println("The cart is empty!");
            return;
        }

        boolean found = false;

        for (Media media : itemsOrdered) {
            if (media.getTitle().equals(title)) {
                System.out.println(media);
                System.out.println("---------------------------------------------------");
                found = true;
            }
        }

        if (!found) {
            System.out.println("No matching titles found for \"" + title + "\".");
        }
    }

    public Media searchByTitle(String titleToPlay) {
        boolean found = false;
        for (int i = 0; i < itemsOrdered.size(); i++) {
            if (isMatch(itemsOrdered.get(i).getTitle(), titleToPlay)) {
                return itemsOrdered.get(i);
            }
        }
        return null;
    }

    public boolean isMatch(String mediaTitle, String inputTitle) {
        return mediaTitle.contains(inputTitle);
    }

    public void emptyCart() {
        itemsOrdered.clear();
        System.out.println("The cart has been emptied.");
    }

    public void sortCartByTitleAndCost() {
        itemsOrdered.sort(COMPARE_BY_TITLE_COST);
    }

    public void sortCartByCostAndTitle() {
        itemsOrdered.sort(COMPARE_BY_COST_TITLE);
    }
}
