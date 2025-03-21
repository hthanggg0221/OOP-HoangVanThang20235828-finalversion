public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc[] itemsOrdered = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered = 0;

    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered[qtyOrdered++] = disc;
            System.out.println("The disc " + disc.getTitle() + " has been added");
        }
        else {
            System.out.println("The cart is almost full");
        }
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered == 0) {
            System.out.println("The cart does not have any disc");
            return;
        }
        for (int i = 0; i < qtyOrdered && itemsOrdered[i] != null; i++) {
            if (itemsOrdered[i].equals(disc)) {
                for (int j = i; j < qtyOrdered; j++) {
                    itemsOrdered[j] = itemsOrdered[j + 1];
                }
                itemsOrdered[qtyOrdered - 1] = null;
                qtyOrdered--;
                System.out.println("The disc " + disc.getTitle() + " has been removed");
                break;
            }
        }
    }

    public float totalCost() {
        if (qtyOrdered == 0) {
            return 0;
        }
        float cost = 0;
        for (int i = 0; i < qtyOrdered && itemsOrdered[i] != null; i++) {
            cost += itemsOrdered[i].getCost();
        }
        return cost;
    }

    public void displayCartItems() {
        for (int i = 0; i < qtyOrdered; i++) {
            System.out.printf("%-3d %-20s %10.2f\n", i+1, itemsOrdered[i].getTitle(), itemsOrdered[i].getCost());
        }
        System.out.printf("%-3s %-20s %10.2f\n","","Total Cost", totalCost());
    }
}
