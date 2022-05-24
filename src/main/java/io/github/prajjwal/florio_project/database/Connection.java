/* Created by IntelliJ IDEA.

Author: Prajjwal Pachauri(cypher)
Date: 22-05-2022
Time: 7:39 PM
File: Connectiom.java */
package io.github.prajjwal.florio_project.database;

public class Connection {

    private final String URL = "jdbc:mysql://localhost:3306/florio";
    private final String USERNAME = "root";
    private final String PASSWORD = "";

    private Connection connection = null;

    public Connection getConnection() {
        return connection;
    }

    public boolean createConnection() throws SQLException {
        connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        return connection != null;
    }

    public void printConnectionStatus() {
        if (getConnection() != null) {
            printSuccess();
        } else {
            printConnectionInActive();
        }
    }

    public void printSuccess() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Connected Successfully successfully!");
        alert.setTitle("ONLINE");
        alert.show();
    }

    public void printConnectionInActive() {
        try {
            String userName = getConnection().getMetaData().getUserName();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Hi, " + userName + " sorry, we could not connect to the database!" +
                    "Please check your username, password and url.");
            alert.setTitle("OFFLINE");
            alert.show();
        } catch (SQLException ignored) {

        }
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }
}