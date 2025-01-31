package Util;

import java.sql.*;

public class DatabaseUtils {
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=your_database";
    private static final String USER = "your_username";
    private static final String PASSWORD = "your_password";

    public Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }


    // Read data from the database  (String query = "SELECT id, name FROM employees");
    public void readData(String query) {
        try (Connection connection = connect();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                // Assuming the table has columns 'id' and 'name'
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                System.out.println("ID: " + id + ", Name: " + name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

 // Write data to the database
//  String query = "INSERT INTO employees (id, name) VALUES (?, ?)";
//  dbUtils.writeData(query, 1, "John Doe");

    public void writeData(String query, Object... params) {
        try (Connection connection = connect();
             PreparedStatement statement = connection.prepareStatement(query)) {

            for (int i = 0; i < params.length; i++) {
                statement.setObject(i + 1, params[i]);
            }

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Update data in the database
//  String query = "UPDATE employees SET name = ? WHERE id = ?";
//  dbUtils.updateData(query, "Jane Doe", 1);

    public void updateData(String query, Object... params) {
        try (Connection connection = connect();
             PreparedStatement statement = connection.prepareStatement(query)) {

            for (int i = 0; i < params.length; i++) {
                statement.setObject(i + 1, params[i]);
            }

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete data from the database
//  String query = "DELETE FROM employees WHERE id = ?";
//  dbUtils.deleteData(query, 1);

    public void deleteData(String query, Object... params) {
        try (Connection connection = connect();
             PreparedStatement statement = connection.prepareStatement(query)) {

            for (int i = 0; i < params.length; i++) {
                statement.setObject(i + 1, params[i]);
            }

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        DatabaseUtils dbUtils = new DatabaseUtils();
        String query = "SELECT id, name FROM employees";
        dbUtils.readData(query);
    }


}
