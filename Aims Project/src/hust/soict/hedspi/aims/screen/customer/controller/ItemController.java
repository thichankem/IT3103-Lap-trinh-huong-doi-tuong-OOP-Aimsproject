package hust.soict.hedspi.aims.screen.customer.controller;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.exception.LimitExceededException;
import hust.soict.hedspi.aims.exception.PlayerException;

public class ItemController
{
    @FXML
    private Button btnAddToCart;

    @FXML
    private Button btnPlay;

    @FXML
    private Label lblCost;

    @FXML
    private Label lblTitle;

    private Cart cart;
    private Media media;

    public ItemController(Cart cart)
    {
        this.cart = cart;
    }

    @FXML
    void btnAddToCartClicked(ActionEvent event)
    {
        if (media == null)
        {
            new Alert(Alert.AlertType.ERROR, "Media item is not available.").showAndWait();
            return;
        }
        if (cart == null)
        {
            new Alert(Alert.AlertType.ERROR, "Cart is not initialized. Cannot add media.").showAndWait();
            return;
        }
        try
        {
            cart.addMedia(media);
            new Alert(Alert.AlertType.INFORMATION,
                       "'" + media.getTitle() + "' added successfully to cart!").showAndWait();
        }
        catch (LimitExceededException e)
        {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).showAndWait();
        }
        catch (Exception e)
        {
            new Alert(Alert.AlertType.ERROR,
                       "An unexpected error occurred while adding to cart: " + e.getMessage())
                       .showAndWait();
        }
    }

    @FXML
    void btnPlayClicked(ActionEvent event)
    {
        if (media == null)
        {
            new Alert(Alert.AlertType.ERROR, "Media item is not available to play.").showAndWait();
            return;
        }
        if (!(media instanceof Playable))
        {
            new Alert(Alert.AlertType.WARNING, "'" + media.getTitle() + "' is not playable.").showAndWait();
            return;
        }
        try
        {
            StringBuffer info = ((Playable) media).play();
            new Alert(Alert.AlertType.INFORMATION, info.toString()).showAndWait();
        }
        catch (PlayerException e)
        {
            new Alert(Alert.AlertType.ERROR, "Error playing media: " + e.getMessage()).showAndWait();
        }
        catch (Exception e)
        {
            new Alert(Alert.AlertType.ERROR,
                       "An unexpected error occurred while trying to play: " + e.getMessage())
                       .showAndWait();
        }
    }

    public void setData(Media media)
    {
        this.media = media;
        lblTitle.setText(media.getTitle());
        lblCost.setText(media.getCost() + " $");
        if (media instanceof Playable)
        {
            btnPlay.setVisible(true);
        }
        else
        {
            btnPlay.setVisible(false);
            HBox.setMargin(btnAddToCart, new Insets(0, 0, 0, 60));
        }
    }
}
