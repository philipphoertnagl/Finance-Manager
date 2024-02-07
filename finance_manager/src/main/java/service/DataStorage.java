package service;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.DataModel;

import java.io.File;
import java.io.IOException;

public class DataStorage {

    private ObjectMapper objectMapper = new ObjectMapper();

    public void saveDataModel(DataModel dataModel, String filePath) {
        try {
            objectMapper.writeValue(new File(filePath), dataModel);
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
