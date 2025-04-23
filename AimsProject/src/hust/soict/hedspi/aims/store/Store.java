package hust.soict.hedspi.aims.store;

import hust.soict.hedspi.aims.media.Media;

import java.util.ArrayList;

public class Store {
    public static final int MAX_ITEMS_NUMBERED = 100;
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();

    public void addMedia(Media media) {
        if (itemsInStore.contains(media))
            System.out.println(media.getTitle() + " is already in the store.");
        if (itemsInStore.size() >= 98) {
            System.out.println("The hust.soict.hedspi.aims.store.Store is almost full.");
        }
        if (itemsInStore.size() < MAX_ITEMS_NUMBERED) {
            itemsInStore.add(media);
            System.out.println("The disc " + media.getTitle() + " has been added in the hust.soict.dsai.aims.store.Store");
        } else {
            System.out.println("The store is already full");
        }
    }

    public void removeMedia(Media media) {
        if (itemsInStore.isEmpty()) {
            System.out.println("The cart does not have any disc");
            return;
        }
        if (itemsInStore.contains(media)) {
            itemsInStore.remove(media);
            System.out.println(media.getTitle() + " has been removed from the store.");
        } else {
            System.out.println(media.getTitle() + " is not in the store.");
        }
    }
}
