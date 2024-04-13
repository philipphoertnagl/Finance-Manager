package service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import model.DataModel;

import java.io.File;
import java.io.IOException;

public class DataStorage {

    private ObjectMapper objectMapper = new ObjectMapper();

    public DataStorage() {
        objectMapper.registerModule(new JavaTimeModule());
        // Disable writing dates as timestamps
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        // Enable pretty printing
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
    }
    public void saveDataModel(DataModel dataModel, String filePath) {
        try {
            objectMapper.writeValue(new File(filePath), dataModel);
            System.out.println("DataModel saved to JSON: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public DataModel loadDataModel(String filePath) {
        try {
            return objectMapper.readValue(new File(filePath), DataModel.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
