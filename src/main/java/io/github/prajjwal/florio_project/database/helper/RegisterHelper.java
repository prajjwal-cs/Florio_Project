package io.github.prajjwal.florio_project.database.helper;

import io.github.prajjwal.florio_project.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterHelper {
    public void createUser(Connection connection, User user) throws SQLException {
        String insertQuery =
                "INSERT INTO user (UserID, Name, Phone, Email, Password) values (?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(insertQuery);
        statement.setInt(1, user.getUserID());
        statement.setString(2, user.getName());
        statement.setLong(3, user.getPhone());
        statement.setString(4, user.getEmail());
        statement.setString(5, user.getPassword());

        statement.execute();
    }
}
