package sample;

// Import of libraries.
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

// Define extended main application.
public class Main extends Application {

    // Define TableView controller & text fields within the window.
    Stage window;
    TableView<Product> table;
    TextField characternameInput, initiativerollInput, dexscoreInput, extranotesInput;

    // Main function call.
    public static void main(String[] args) {
        launch(args);
    }

    // Override & primaryStage definition.
    @Override
    public void start(Stage primaryStage) throws Exception {

// Setting window as primaryStage.
        window = primaryStage;

// Setting window title to "D&D 5e Initiative Tracker".
        window.setTitle("D&D 5e Initiative Tracker");

// Adding columns for Character Name, Initiative Roll, Extra Notes, DEX Score.

        //Character Name column.
        TableColumn<Product, String> CharacterNameColumn = new TableColumn<>("Character Name");
        CharacterNameColumn.setMinWidth(200);
        CharacterNameColumn.setCellValueFactory(new PropertyValueFactory<>("CharacterName"));

        //Initiative Roll column.
        TableColumn<Product, String> InitiativeRollColumn = new TableColumn<>("Initiative Roll");
        InitiativeRollColumn.setMinWidth(100);
        InitiativeRollColumn.setCellValueFactory(new PropertyValueFactory<>("InitiativeRoll"));

        //Extra Notes column.
        TableColumn<Product, String> ExtraNotesColumn = new TableColumn<>("Extra Notes");
        ExtraNotesColumn.setMinWidth(100);
        ExtraNotesColumn.setCellValueFactory(new PropertyValueFactory<>("ExtraNotes"));

        //DEX Score column.
        TableColumn<Product, Integer> DexScoreColumn = new TableColumn<>("Dex Score");
        DexScoreColumn.setMinWidth(100);
        DexScoreColumn.setCellValueFactory(new PropertyValueFactory<>("DexScore"));

        //Character Name Input.
        characternameInput = new TextField();
        characternameInput.setPromptText("Character Name");
        characternameInput.setMinWidth(100);

        //Initiative Roll Input.
        initiativerollInput = new TextField();
        initiativerollInput.setPromptText("Initiative Roll");

        //Extra Notes Input.
        extranotesInput = new TextField();
        extranotesInput.setPromptText("Extra Notes");

        //DEX Score Input.
        dexscoreInput = new TextField();
        dexscoreInput.setPromptText("DEX Score");

        //Add Button + Event.
        Button addButton = new Button("Add");
        addButton.setOnAction(e -> addButtonClicked());

        //Delete Button + Event.
        Button deleteButton = new Button("Delete");
        deleteButton.setOnAction(e -> deleteButtonClicked());

        //HBox.
        HBox hBox = new HBox();
        hBox.setPadding(new Insets(10,10,10,10));
        hBox.setSpacing(10);
        hBox.getChildren().addAll(characternameInput, initiativerollInput, extranotesInput, dexscoreInput, addButton, deleteButton);

        //Get TableItems.
        table = new TableView<>();
        table.setItems(getProduct());
        table.getColumns().addAll(CharacterNameColumn, InitiativeRollColumn, ExtraNotesColumn, DexScoreColumn);
        //VBox.
        VBox vBox = new VBox();
        vBox.getChildren().addAll(table, hBox);

        //VBox scene + showing window function.
        Scene scene = new Scene(vBox);
        window.setScene(scene);
        window.show();
    }

    //Add button clicked
    public void addButtonClicked(){
        Product product = new Product();
        product.setCharacterName(characternameInput.getText());
        try {
            product.setInitiativeRoll(initiativerollInput.getText());
            product.setExtraNotes(extranotesInput.getText());
            product.setDexScore(Integer.parseInt(dexscoreInput.getText()));
            table.getItems().add(product);
        }

        catch(NumberFormatException e){
            System.out.println("Non-numeric value inserted in numeric field or a field was left blank; Please try again.");

        }
        if(table.getItems().size() != 0) {
            System.out.println(table.getItems().size());
        }
        characternameInput.clear();
        initiativerollInput.clear();
        extranotesInput.clear();
        dexscoreInput.clear();
    }

    //Delete button clicked
    public void deleteButtonClicked(){
        ObservableList<Product> productSelected, allProducts;
        allProducts = table.getItems();
        productSelected = table.getSelectionModel().getSelectedItems();
        productSelected.forEach(allProducts::remove);
    }

    //Get all of the products
    public ObservableList<Product> getProduct(){
        ObservableList<Product> products = FXCollections.observableArrayList();
        products.add(new Product("Nicolai er gud", "20*", "Og det ved alle", 20));
        products.add(new Product("Jakob er gud", "21*", "Du ved det Nico", 21));

        return products;
    }


}