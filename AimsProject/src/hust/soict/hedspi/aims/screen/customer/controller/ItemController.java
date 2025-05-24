package hust.soict.hedspi.aims.screen.customer.controller;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

import javafx.scene.control.Button;
import javafx.event.ActionEvent;

public class ItemController {
    private Media media;
    private Cart cart;

    @FXML
    private Label lb1Title;

    @FXML
    private Label lb1Cost;

    @FXML
    private Button btnAddToCart;

    @FXML
    private Button btnPlay;

    public ItemController(Media media, Cart cart) {
        this.media = media;
        this.cart = cart;
    }

    @FXML
    public void initialize() {
        lb1Title.setText(media.getTitle());
        lb1Cost.setText(String.format("%.2f $", media.getCost()));
        btnPlay.setVisible(media instanceof hust.soict.hedspi.aims.media.Playable);
    }

    @FXML
    private void btnAddtoCartClicked(ActionEvent event) {
        cart.addMedia(media);
    }

    @FXML
    private void btnPlayClicked(ActionEvent event) {
//        try {
//            if (media instanceof hust.soict.hedspi.aims.media.Playable) {
//                ((hust.soict.hedspi.aims.media.Playable) media).play();
//            }
//        } catch (PlayerException e) {
//            Alert alert = new Alert(Alert.AlertType.ERROR, e.getMessage());
//            alert.showAndWait();
//        }
        if (media instanceof hust.soict.hedspi.aims.media.Playable) {
            ((hust.soict.hedspi.aims.media.Playable) media).play();
        }
    }

    public void setData(Media media) {
        this.media = media;
        lb1Title.setText(media.getTitle());
        lb1Cost.setText(media.getCost()+" $");
        if (media instanceof Playable) {
            btnPlay.setVisible(true);
        }
        else {
            btnPlay.setVisible(false);
            HBox.setMargin(btnAddToCart, new Insets(0, 0, 0, 60));
        }
    }
}
