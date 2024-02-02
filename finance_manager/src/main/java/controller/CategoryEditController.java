package controller;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import model.DataModel;
import model.SubCategory;

import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;

import java.util.List;


public class CategoryEditController {
    private DataModel dataModel = new DataModel();

    @FXML
    private TableView<SubCategory> tableviewCategory;

    public void initialize() {
        dataModel.loadData();
        tableviewCategory.setEditable(true);


        List<SubCategory> existingSubcategories = dataModel.getInvestments().getSubCategories();

        // Populate the TableView
        tableviewCategory.setItems(FXCollections.observableArrayList(existingSubcategories));


    }



}
