package hust.soict.hedspi.aims.store;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;

public class Store {
    public static final int MAX_ITEMS_NUMBERED = 100;
    private DigitalVideoDisc[] itemsInStore = new DigitalVideoDisc[MAX_ITEMS_NUMBERED];
    private int numberItems = 0;

    public void addDVD(DigitalVideoDisc disc) {
        if (numberItems >= 98) {
            System.out.println("The hust.soict.hedspi.aims.store.Store is almost full.");
        }
        if (numberItems < MAX_ITEMS_NUMBERED) {
            itemsInStore[numberItems] = disc;
            System.out.println("The disc " + itemsInStore[numberItems].getTitle() + " has been added in the hust.soict.dsai.aims.store.Store");
            numberItems++;
        } else {
            System.out.println("The store is already full");
        }
    }

    public void removeDVD(DigitalVideoDisc disc) {
        if (numberItems == 0) {
            System.out.println("The cart does not have any disc");
            return;
        }
        for (int i = 0; i < numberItems; i++) {
            if (itemsInStore[i].equals(disc)) {
                for (int j = i; j < numberItems; j++) {
                    itemsInStore[j] = itemsInStore[j+1];
                }
                itemsInStore[numberItems - 1] = null;
                numberItems--;
                System.out.println("The disc " + disc.getTitle() + " has been removed");
                break;
            }
        }
    }
}
