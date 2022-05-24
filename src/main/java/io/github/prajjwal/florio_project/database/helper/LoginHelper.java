/* Created by IntelliJ IDEA.

Author: Prajjwal Pachauri(cypher)
Date: 24-05-2022
Time: 20:17
File: LoginHelper.java */
package io.github.prajjwal.florio_project.database.helper;

import io.github.prajjwal.florio_project.database.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginHelper {
    public boolean loginUser(String email, String password) throws SQLException {

        DatabaseConnection databaseConnection = new DatabaseConnection();

        databaseConnection.createConnection();
        // login Query
        String LoginQuery = "SELECT * FROM user WHERE Email = ? AND Password = ?";
        Connection connection = databaseConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(LoginQuery);
        preparedStatement.setString(1, email);
        preparedStatement.setString(2, password);
        ResultSet resultSet = preparedStatement.executeQuery();

        return resultSet.next();
    }
}