package controller;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.CheckBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import model.DataModel;
import model.SubCategory;

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
    private CheckBox labelSavings;
    @FXML
    private CheckBox labelIncome;
    @FXML
    private CheckBox labelInvestments;
    @FXML
    private CheckBox labelCosts;

    //Total Sum Labels Top:
    @FXML
    private Label labelSumInvestSaving;
    @FXML
    private Label labelIncomeCosts;
    @FXML
    private Label labelSumSelected;

    public void initialize() {
        dataModel.loadData();

        //Sum on TOp Calculations:
        double sumInvestmentsSavings = dataModel.getInvestments().getTotalAmount() + dataModel.getSavings().getTotalAmount();
        labelSumInvestSaving.setText("Total of Savings & Investments: " + sumInvestmentsSavings);

        double resultIncomeCosts = dataModel.getIncome().getTotalAmount() - dataModel.getCosts().getTotalAmount();
        labelIncomeCosts.setText("Total Income - Costs: " + resultIncomeCosts);



        labelSavings.setText("Total: " + dataModel.getSavings().getTotalAmount());
        savingsListView.setItems(FXCollections.observableArrayList(
                dataModel.getSavings().getSubCategories().stream()
                        .map(SubCategory::toString)
                        .collect(Collectors.toList())
        ));

        labelIncome.setText("Total: " + dataModel.getIncome().getTotalAmount());
        incomeListView.setItems(FXCollections.observableArrayList(
                dataModel.getIncome().getSubCategories().stream()
                        .map(SubCategory::toString)
                        .collect(Collectors.toList())
        ));

        labelInvestments.setText("Total: " + dataModel.getInvestments().getTotalAmount());
        investmentsListView.setItems(FXCollections.observableArrayList(
                dataModel.getInvestments().getSubCategories().stream()
                        .map(SubCategory::toString)
                        .collect(Collectors.toList())
        ));

        labelCosts.setText("Total: " + dataModel.getCosts().getTotalAmount());
        costsListView.setItems(FXCollections.observableArrayList(
                dataModel.getCosts().getSubCategories().stream()
                        .map(SubCategory::toString)
                        .collect(Collectors.toList())
        ));




    }

}
