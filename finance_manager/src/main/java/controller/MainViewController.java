package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.CheckBox;
import javafx.collections.FXCollections;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import model.DataModel;
import model.SubCategory;
import service.DataStorage;

import java.io.File;
import java.io.IOException;
import java.util.stream.Collectors;

public class MainViewController {
    private DataModel dataModel = new DataModel();


    //ListView objects
    @FXML
    private ListView<String> savingsListView;
    @FXML
    private ListView<String> incomeListView;
    @FXML
    private ListView<String> investmentsListView;
    @FXML
    private ListView<String> costsListView;

    //Checkbox objects
    @FXML
    private CheckBox checkboxSavings;
    @FXML
    private CheckBox checkboxIncome;
    @FXML
    private CheckBox checkboxInvestments;
    @FXML
    private CheckBox checkboxCosts;

    //Total Sum Labels Top:
    @FXML
    private Label labelSumInvestSaving;
    @FXML
    private Label labelIncomeCosts;
    @FXML
    private Label labelSumSelected;

    public void initialize() {

        //Sum on TOp Calculations:
        double sumInvestmentsSavings = dataModel.getInvestments().getTotalAmount() + dataModel.getSavings().getTotalAmount();
        labelSumInvestSaving.setText("Total of Savings & Investments: " + sumInvestmentsSavings);

        double resultIncomeCosts = dataModel.getIncome().getTotalAmount() - dataModel.getCosts().getTotalAmount();
        labelIncomeCosts.setText("Total Income - Costs: " + resultIncomeCosts);



        checkboxSavings.setText("Savings: " + dataModel.getSavings().getTotalAmount());
        savingsListView.setItems(FXCollections.observableArrayList(
                dataModel.getSavings().getSubCategories().stream()
                        .map(SubCategory::toString)
                        .collect(Collectors.toList())
        ));

        checkboxIncome.setText("Income: " + dataModel.getIncome().getTotalAmount());
        incomeListView.setItems(FXCollections.observableArrayList(
                dataModel.getIncome().getSubCategories().stream()
                        .map(SubCategory::toString)
                        .collect(Collectors.toList())
        ));

        checkboxInvestments.setText("Investments: " + dataModel.getInvestments().getTotalAmount());
        investmentsListView.setItems(FXCollections.observableArrayList(
                dataModel.getInvestments().getSubCategories().stream()
                        .map(SubCategory::toString)
                        .collect(Collectors.toList())
        ));

        checkboxCosts.setText("Fixcosts: " + -dataModel.getCosts().getTotalAmount());
        costsListView.setItems(FXCollections.observableArrayList(
                dataModel.getCosts().getSubCategories().stream()
                        .map(SubCategory::toString)
                        .collect(Collectors.toList())
        ));

    }

    public void updateSelectedTotal() {
        double total = 0;
        if (checkboxSavings.isSelected()) {
            total += dataModel.getSavings().getTotalAmount();
        }
        if (checkboxIncome.isSelected()) {
            total += dataModel.getIncome().getTotalAmount();
        }
        if (checkboxInvestments.isSelected()) {
            total += dataModel.getInvestments().getTotalAmount();
        }
        if (checkboxCosts.isSelected()) {
            total -= dataModel.getCosts().getTotalAmount();
        }

        labelSumSelected.setText(String.format("Sum of selected categories: $%.2f", total));
    }

    @FXML
    protected void handleEditAction(ActionEvent event) throws IOException {
        Node source = (Node) event.getSource();
        String id = source.getId(); // This is the fx:id of the button

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/CategoryEdit.fxml"));
        Parent root = loader.load();

        CategoryEditController editController = loader.getController();
        System.out.println("Button ID: " + id);
        editController.setCategoryBasedOnId(id); // A method you'll define in CategoryEditController

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }


}
