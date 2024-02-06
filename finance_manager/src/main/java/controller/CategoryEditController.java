package controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import model.DataModel;
import model.SubCategory;

import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.Label;

import java.util.List;


public class CategoryEditController {
    private DataModel dataModel = new DataModel();

    @FXML
    private TableView<SubCategory> tableviewCategory;
    @FXML
    private Label labelCategoryName;

    public void initialize() {
        dataModel.loadData();
        labelCategoryName.setText(dataModel.getInvestments().getName()); //TODO: change later to autmatic category_name setting
        tableviewCategory.setEditable(true);


        List<SubCategory> existingSubcategories = dataModel.getInvestments().getSubCategories();

        // Populate the TableView
        tableviewCategory.setItems(FXCollections.observableArrayList(existingSubcategories));


    }

    @FXML
    public void handleAddButtonAction(ActionEvent event) {
        SubCategory newSubCategory = new SubCategory(""); // Create a new subcategory with an empty name
        tableviewCategory.getItems().add(newSubCategory); // Add it to the TableView
        int newRowIndex = tableviewCategory.getItems().size() - 1;
        tableviewCategory.getSelectionModel().select(newRowIndex); // Select the new row
        tableviewCategory.scrollTo(newSubCategory); // Scroll to the new row if necessary
       // tableviewCategory.edit(newRowIndex, tablecolumnSubcategory); // Optional: directly start editing the name
    }




}
