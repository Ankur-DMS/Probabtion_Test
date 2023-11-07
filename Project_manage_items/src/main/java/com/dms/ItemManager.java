package com.dms;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemManager {
	private Connection connection;

    public ItemManager(Connection connection) {
        this.connection = connection;
    }

    public void addItem(Item item) throws SQLException {
        String query = "INSERT INTO items (name, description, category_id) VALUES (?, ?, ?)";
       
            try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, item.getName());
             statement.setString(2, item.getDescription());
              statement.setInt(3, item.getCategoryId());
            statement.executeUpdate();
        }
    }

  public List<Item> listItemsInCategory(int categoryId) throws SQLException {
           List<Item> items = new ArrayList<>();
        String query = "SELECT * FROM items WHERE category_id = ?";
          try (PreparedStatement statement = connection.prepareStatement(query)) {
              statement.setInt(1, categoryId);
             ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                     int id = resultSet.getInt("id");
                 String name = resultSet.getString("name");
              String description = resultSet.getString("description");
                  int category_id = resultSet.getInt("category_id");
                  Item item = new Item(id, name, description, category_id);
                items.add(item);
            }
        }
        return items;
    }

     public void updateItem(Item item) throws SQLException {
          String query = "UPDATE items SET name=?, description=?, category_id=? WHERE id=?";
          try (PreparedStatement statement = connection.prepareStatement(query)) {
             statement.setString(1, item.getName());
            statement.setString(2, item.getDescription());
             statement.setInt(3, item.getCategoryId());
              statement.setInt(4, item.getId());
             statement.executeUpdate();
        }
    }

    public void deleteItem(int itemId) throws SQLException {
         String query = "DELETE FROM items WHERE id=?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
             statement.setInt(1, itemId);
            statement.executeUpdate();
        }
    }

}
