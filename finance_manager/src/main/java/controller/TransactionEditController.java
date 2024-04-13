package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.NumberStringConverter;
import model.DataModel;
import model.Transaction;
import model.SubCategory;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TransactionEditController {
    private DataModel dataModel = new DataModel();
    private SubCategory subCategory;

    @FXML
    private TableView<Transaction> tableviewCategory;
    @FXML
    private TableColumn<Transaction, String> tableColumnTransaction;
    @FXML
    private TableColumn<Transaction, Number> tableColumnAmount;
    @FXML
    private TableColumn<Transaction, String> tableColumnDate;

    @FXML
    public void initialize() {
        setupTableColumns();
    }

    private void setupTableColumns() {
        tableColumnTransaction.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        tableColumnTransaction.setCellFactory(TextFieldTableCell.forTableColumn());
        tableColumnTransaction.setOnEditCommit(event -> {
            Transaction transaction = event.getRowValue();
            transaction.setName(event.getNewValue());

        });

        tableColumnAmount.setCellValueFactory(cellData -> cellData.getValue().amountProperty());
        tableColumnAmount.setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
        tableColumnAmount.setOnEditCommit(event -> {
            Transaction transaction = event.getRowValue();
            transaction.setAmount(event.getNewValue().doubleValue());
            transaction.setDate(LocalDate.now());  // Set the current date when the amount is edited
        });

        tableColumnDate.setCellValueFactory(cellData -> cellData.getValue().dateProperty().asString());
        tableColumnDate.setCellFactory(TextFieldTableCell.forTableColumn());

        tableviewCategory.setEditable(true);
        tableColumnTransaction.setEditable(true);
    }

    @FXML
    private void handleAddButtonAction(ActionEvent event) {
        Transaction newTransaction = new Transaction(0); // Start with an amount of 0
        newTransaction.setDate(LocalDate.now());  // Set the current date when adding a new transaction
        tableviewCategory.getItems().add(newTransaction);
        subCategory.addTransaction(newTransaction);

        int newRowIndex = tableviewCategory.getItems().size() - 1;
        tableviewCategory.getSelectionModel().select(newRowIndex);
        tableviewCategory.scrollTo(newTransaction);
        tableviewCategory.edit(newRowIndex, tableColumnTransaction);
    }
}
