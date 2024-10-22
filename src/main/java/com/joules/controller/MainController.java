package com.joules.controller;

import com.joules.DatabaseConnection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class MainController {
    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private TextField middleName;
    @FXML
    private TextField address;
    @FXML
    private TextField email;
    @FXML
    private TextField number;
    @FXML
    private RadioButton genderMale;
    @FXML
    private RadioButton genderFemale;

    public ToggleGroup gender;

    @FXML
    private DatabaseConnection connection;

    public MainController() {
    }

    public void initialize(){
        connection = new DatabaseConnection();
    }

    @FXML
    private void save() throws SQLException {
        String sql = "INSERT INTO students(first_name, last_name, middle_name, address, email, phone_number, gender) VALUES(?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = this.connection.connection.prepareStatement(sql);
        stmt.setString(1, this.firstName.getText());
        stmt.setString(2, this.lastName.getText());
        stmt.setString(3, this.middleName.getText());
        stmt.setString(4, this.address.getText());
        stmt.setString(5, this.email.getText());
        stmt.setString(6, this.number.getText());
        if(genderMale.isSelected()){
            stmt.setString(7,"Male");
        }
        else if (genderFemale.isSelected()){
            stmt.setString(7, "Female");
        }
        stmt.execute();
    }
}

