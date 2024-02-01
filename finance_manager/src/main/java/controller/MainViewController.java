package controller;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.CheckBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.DataModel;
import model.SubCategory;

import java.util.stream.Collectors;
// Import other necessary packages...

public class MainViewController {

    private DataModel dataModel = new DataModel();


    @FXML
    private ListView<String> savingsListView;

    @FXML
    private ListView<String> incomeListView;

    @FXML
    private ListView<String> investmentsListView;

    @FXML
    private ListView<String> costsListView;

    // Initialize with data
    public void initialize() {
        // Assuming you have a method getSubCategories() that returns a list of subcategory names
        savingsListView.setItems(FXCollections.observableArrayList(
                dataModel.getInvestments().getSubCategories().stream()
                        .map(model.SubCategory::toString)
                        .collect(Collectors.toList())
        ));
        /*incomeListView.setItems(FXCollections.observableArrayList(getSubCategories("Income")));
        investmentsListView.setItems(FXCollections.observableArrayList(getSubCategories("Investments")));
        costsListView.setItems(FXCollections.observableArrayList(getSubCategories("Costs")));*/
    }

    private ObservableList<String> getSubCategories(String category) {

        return FXCollections.observableArrayList("Savings", "Income", "Investments", "lklk");
    }

}
