package com.dms;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryManager {
	private Connection connection;

    public CategoryManager(Connection connection) {
        this.connection = connection;
    }
    public CategoryManager(String url, String username, String password) {
        try {
            connection = (Connection) DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
        	
            e.printStackTrace();
        }
    }

    public void addCategory(Category category) throws SQLException {
          String query = "INSERT INTO categories (name) VALUES (?)";
         try (PreparedStatement statement = connection.prepareStatement(query)) {
              statement.setString(1, category.getName());
            statement.executeUpdate();
        }
    }

    public List<Category> listAllCategories() throws SQLException {
          List<Category> categories = new ArrayList<>();
        String query = "SELECT * FROM categories";
         try (PreparedStatement statement = connection.prepareStatement(query)) {
             ResultSet resultSet = statement.executeQuery();
               while (resultSet.next()) {
                  int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                  Category category = new Category(id, name);
                categories.add(category);
              }
        }
                        return categories;
    }
}
