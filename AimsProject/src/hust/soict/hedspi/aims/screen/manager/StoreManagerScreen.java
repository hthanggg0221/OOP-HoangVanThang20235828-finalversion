package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class StoreManagerScreen extends JFrame{
    private Store store;
    private JPanel center;

    public StoreManagerScreen(Store store) {
        this.store = store;

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(center = createCenter(store.getItemsInStore()), BorderLayout.CENTER);

        setTitle("Store");
        setSize(1024, 768);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");

        JMenuItem viewStoreItem = new JMenuItem("View store");
        viewStoreItem.addActionListener(e -> {
            new StoreManagerScreen(store);
            dispose();
        });
        menu.add(viewStoreItem);

        JMenu smUpdateStore = new JMenu("Update Store");

        JMenuItem addBookItem = new JMenuItem("Add Book");
        addBookItem.addActionListener(e -> {
            new AddBookToStoreScreen();
            dispose();
        });
        smUpdateStore.add(addBookItem);

        JMenuItem addCDItem = new JMenuItem("Add CD");
        addCDItem.addActionListener(e -> {
            new AddCompactDiscToStoreScreen();
        });
        smUpdateStore.add(addCDItem);

        JMenuItem addDVDItem = new JMenuItem("Add DVD");
        addDVDItem.addActionListener(e -> {
            new AddDigitalVideoDiscToStoreScreen();
        });
        smUpdateStore.add(addDVDItem);
        menu.add(smUpdateStore);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        return menuBar;
    }

    JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(Box.createRigidArea(new Dimension(10, 10)));

        return header;
    }

    JPanel createCenter(List<Media> itemList) {
        JPanel center = new JPanel();

        int itemsToShow = itemList.size() < 9 ? itemList.size() : 9;

        if (itemsToShow == 0) {
            center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));

            JLabel lblStoreEmpty = new JLabel("No item found.");
            lblStoreEmpty.setAlignmentX(CENTER_ALIGNMENT);
            lblStoreEmpty.setFont(new Font(lblStoreEmpty.getName(), Font.PLAIN, 20));

            center.add(Box.createRigidArea(new Dimension(10, 200)));
            center.add(lblStoreEmpty);
            return center;
        }

        center.setLayout(new GridLayout(0, 3, 2, 2));

        for (int i = 0; i < itemsToShow; i++) {
            MediaStore cell = new MediaStore(itemList.get(i), this);
            center.add(cell);
        }

        return center;
    }

    public void loadItemsToStore(List<Media> itemList) {
        remove(center);
        add(center = createCenter(itemList), BorderLayout.CENTER);
        repaint();
        revalidate();
    }

    public void loadItemsToStore() {
        loadItemsToStore(store.getItemsInStore());
    }

    public static void main(String[] args) {
        Store store = new Store();

        store.addMedia(new DigitalVideoDisc("Harry Potter and the Phisolopher's Stone (2001)", "Science Fiction", "Chris Columbus", 87, 3.0f));
        store.addMedia(new DigitalVideoDisc("Harry Potter and the Chamber of Secrets (2002)", "Science Fiction", "Chris Columbus", 124, 3.5f));
        store.addMedia(new DigitalVideoDisc("Harry Potter and the Prisoner of Azkaban (2004)", "Science Fiction", "Chris Columbus", 124, 5.0f));
        store.addMedia(new DigitalVideoDisc("Harry Potter and the Goblet of Fire (2005)", "Science Fiction", "Chris Columbus", 124, 4.5f));
        store.addMedia(new CompactDisc("Fetch the Bolt Cutters", "Pop",10.39f, "Fiona Apple"));
        store.addMedia(new CompactDisc("Future Nostalgia", "Pop",9.5f, "Dua Lipa"));
        store.addMedia(new Book("The Hunger Games", "Action", 5.5f));
        store.addMedia(new Book("Catching Fire", "Action", 4.9f));
        store.addMedia(new Book("Mockingjay", "Action", 5.1f));

        new StoreManagerScreen(store);
    }
}