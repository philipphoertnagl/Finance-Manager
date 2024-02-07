package controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.NumberStringConverter;
import model.Category;
import model.DataModel;
import model.SubCategory;

import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.Label;
import service.DataStorage;

import java.util.List;


public class CategoryEditController {
    private DataModel dataModel = new DataModel();
    private DataStorage dataStorage = new DataStorage();

    @FXML
    private TableView<SubCategory> tableviewCategory;
    @FXML
    private TableColumn<SubCategory, String> tablecolumnSubcategory;
    @FXML
    private TableColumn<SubCategory, Number> tablecolumnAmount;
    @FXML
    private Label labelCategoryName;
    @FXML
    private ComboBox<String> categoryComboBox;
    private Category currentCategory;

    public void initialize() {
        String filePath = "src/main/java/service/DataModel.json"; // This could also be dynamically determined
        dataModel = dataStorage.loadDataModel(filePath);
        if (dataModel == null) {
            dataModel = new DataModel(); // Fallback strategy if loading fails
        }

        //dataModel.loadData();
        labelCategoryName.setText(dataModel.getInvestments().getName()); //TODO: change later to autmatic category_name setting
        tableviewCategory.setEditable(true);


        List<SubCategory> existingSubcategories = dataModel.getInvestments().getSubCategories();
        tableviewCategory.setItems(FXCollections.observableArrayList(existingSubcategories));

        categoryComboBox.getItems().addAll("Investments", "Income", "Costs", "Savings");

        // Pre-select the first category or set to a default
        categoryComboBox.getSelectionModel().selectFirst();
        updateCurrentCategory();

        setupTableColumns();
    }


    private void setupTableColumns() {
        // Set cell factories for editable columns
        tablecolumnSubcategory.setCellFactory(TextFieldTableCell.forTableColumn());
        tablecolumnSubcategory.setOnEditCommit(event -> {
            SubCategory subCategory = event.getRowValue();
            subCategory.setSubName(event.getNewValue());
        });

        tablecolumnAmount.setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
        tablecolumnAmount.setOnEditCommit(event -> {
            SubCategory subCategory = event.getRowValue();
            subCategory.setAmount(event.getNewValue().doubleValue());
        });

        tableviewCategory.setEditable(true);
    }

    @FXML
    private void handleAddButtonAction(ActionEvent event) {
        SubCategory newSubCategory = new SubCategory(""); // Create a new subcategory with an empty name
        tableviewCategory.getItems().add(newSubCategory); // Add it to the TableView
        dataModel.addSubCategory(currentCategory, newSubCategory);

        int newRowIndex = tableviewCategory.getItems().size() - 1;
        tableviewCategory.getSelectionModel().select(newRowIndex); // Select the new row
        tableviewCategory.scrollTo(newSubCategory); // Scroll to the new row if necessary
        tableviewCategory.edit(newRowIndex, tablecolumnSubcategory); // Optional: directly start editing the name
    }

    @FXML
    private void handleDeleteButtonAction(ActionEvent event) {
        SubCategory selectedRow = tableviewCategory.getSelectionModel().getSelectedItem();
        if (selectedRow != null) {
            tableviewCategory.getItems().remove(selectedRow);
            dataModel.removeSubCategory(currentCategory, selectedRow);
        }
         else {

            System.out.println(("No subcategory selected."));
         }
     }

    @FXML
    private void handleSaveAction(ActionEvent event) {
        String filePath = "src/main/java/service/DataModel.json"; // Define how you get or set this path
        dataStorage.saveDataModel(dataModel, filePath);
    }


    @FXML
    private void onCategoryChanged(ActionEvent event) {
        updateCurrentCategory();
    }

    private void updateCurrentCategory() {
        String selectedCategory = categoryComboBox.getValue();
        if (selectedCategory != null) {
            switch (selectedCategory) {
                case "Investments":
                    currentCategory = dataModel.getInvestments();
                    break;
                case "Income":
                    currentCategory = dataModel.getIncome();
                    break;
                case "Costs":
                    currentCategory = dataModel.getCosts();
                    break;
                case "Savings":
                    currentCategory = dataModel.getSavings();
                    break;
            }
        }

        // Load subcategories for the selected category into the TableView
        loadSubcategories();
    }

    private void loadSubcategories() {
        if (currentCategory != null) {
            List<SubCategory> subcategories = currentCategory.getSubCategories();
            tableviewCategory.setItems(FXCollections.observableArrayList(subcategories));
        }
    }


}
