/* Created by IntelliJ IDEA.

Author: Prajjwal Pachauri(cypher)
Date: 25-05-2022
Time: 22:38
File: AddAddressHelper.java */
package io.github.prajjwal.florio_project.database.helper;

import io.github.prajjwal.florio_project.database.DatabaseConnection;
import io.github.prajjwal.florio_project.model.User;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddAddressHelper {
    public void addAddress(String address) throws SQLException {
        DatabaseConnection connection = new DatabaseConnection();
        String insertQuery =
                "INSERT INTO user (Address) values ?)";
        PreparedStatement statement = connection.getConnection().prepareStatement(insertQuery);
        statement.setString(1, address);
        statement.executeUpdate();
    }
}