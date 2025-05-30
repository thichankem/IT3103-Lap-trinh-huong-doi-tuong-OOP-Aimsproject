package hust.soict.hedspi.aims.screen.customer.controller;

import java.io.IOException;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.exception.PlayerException;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.store.Store;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class CartController
{
    private Cart cart;
    private Store store;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private TableColumn<Media, Integer> colMediaId;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private Label costLabel;

    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private TableView<Media> tblMedia;

    public CartController(Cart cart, Store store)
    {
        this.cart = cart;
        this.store = store;
    }

    @FXML
    void btnViewStorePressed(ActionEvent event)
    {
        try
        {
            String path = "/hust/soict/hedspi/aims/screen/customer/view/Store.fxml";
            FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
            if (cart == null || store == null)
            {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Cannot load store: critical data missing.");
                alert.showAndWait();
                return;
            }
            ViewStoreController controller = new ViewStoreController(cart, store);
            loader.setController(controller);
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("AIMS Store");
        }
        catch (IOException e)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Error loading the store screen: " + e.getMessage());
            alert.showAndWait();
        }
        catch (Exception e)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR, "An unexpected error occurred: " + e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    public void initialize()
    {
        colMediaId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<>("cost"));

        if (cart != null && cart.getItemsOrdered() != null)
        {
            tblMedia.setItems(FXCollections.observableArrayList(cart.getItemsOrdered()));
        }
        updateTotalCostLabel();

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>()
        {
            @Override
            public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue)
            {
                updateButtonBar(newValue);
            }
        });
    }

    void updateButtonBar(Media media)
    {
        if (media == null)
        {
            btnPlay.setVisible(false);
            btnRemove.setVisible(false);
        }
        else
        {
            btnRemove.setVisible(true);
            btnPlay.setVisible(media instanceof Playable);
        }
    }

    private void updateTotalCostLabel()
    {
        if (cart != null && costLabel != null)
        {
            float total = cart.totalCost();
            costLabel.setText(String.format("%.2f $", total));
        }
        else if (costLabel != null)
        {
            costLabel.setText("0.00 $");
        }
    }

    @FXML
    void btnRemovePressed(ActionEvent event)
    {
        Media selected = tblMedia.getSelectionModel().getSelectedItem();
        if (selected != null && cart != null)
        {
            try
            {
                cart.removeMedia(selected);
                tblMedia.getItems().remove(selected);
                updateTotalCostLabel();
            }
            catch (Exception e)
            {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Error removing media: " + e.getMessage());
                alert.showAndWait();
            }
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Please select an item to remove.");
            alert.showAndWait();
        }
    }

    @FXML
    void btnPlayPressed(ActionEvent event)
    {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        if (media instanceof Playable)
        {
            try
            {
                StringBuffer info = ((Playable) media).play();
                Alert alert = new Alert(Alert.AlertType.INFORMATION, info.toString());
                alert.setTitle("Playing Media");
                alert.setHeaderText("Now playing: " + media.getTitle());
                alert.showAndWait();
            }
            catch (PlayerException e)
            {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Error playing media: " + e.getMessage());
                alert.showAndWait();
            }
            catch (Exception e)
            {
                Alert alert = new Alert(Alert.AlertType.ERROR, "An unexpected error occurred: " + e.getMessage());
                alert.showAndWait();
            }
        }
        else if (media == null)
        {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Please select an item to play.");
            alert.showAndWait();
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.WARNING, "'" + media.getTitle() + "' is not playable.");
            alert.showAndWait();
        }
    }

    @FXML
    void btnPlaceOrderClicked(ActionEvent event)
    {
        if (cart != null && !cart.getItemsOrdered().isEmpty())
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION,
                "Order placed successfully! Total: " + String.format("%.2f $", cart.totalCost()));
            alert.setHeaderText(null);
            alert.showAndWait();
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Your cart is empty. Cannot place order.");
            alert.setHeaderText(null);
            alert.showAndWait();
        }
    }
}
