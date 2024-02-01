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
        dataModel.loadData();
        savingsListView.setItems(FXCollections.observableArrayList(
                dataModel.getSavings().getSubCategories().stream()
                        .map(SubCategory::toString)
                        .collect(Collectors.toList())
        ));

        incomeListView.setItems(FXCollections.observableArrayList(
                dataModel.getIncome().getSubCategories().stream()
                        .map(SubCategory::toString)
                        .collect(Collectors.toList())
        ));

        investmentsListView.setItems(FXCollections.observableArrayList(
                dataModel.getInvestments().getSubCategories().stream()
                        .map(SubCategory::toString)
                        .collect(Collectors.toList())
        ));

        costsListView.setItems(FXCollections.observableArrayList(
                dataModel.getCosts().getSubCategories().stream()
                        .map(SubCategory::toString)
                        .collect(Collectors.toList())
        ));
    }



}
